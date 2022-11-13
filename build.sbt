ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

val commonSettings = Seq(
  scalaVersion := "3.2.1",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.3.14",
    "org.scalameta" %% "munit" % "0.7.29" % Test
  )
)

val shared = project.settings(commonSettings)

val server = project.settings(commonSettings).dependsOn(shared)

val client = project.settings(commonSettings).dependsOn(shared)

lazy val root = project
  .in(file("."))
  .settings(name := "docker-clone", publish := {})
  .aggregate(server, client, shared)
