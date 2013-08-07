package com.baidu.cyberplayer.sdk.internal;
/* loaded from: classes.dex */
public class CyberPlayerEngineConstants {
    public static final String CYBERPLAYER_JAR_NAME = "com.baidu.cyberplayer.engine.jar";
    public static final String CYBERPLAYER_LIBCORE_NAME = "libcyberplayer-core.so";
    public static final String CYBERPLAYER_LIB_LOCAL_RELATIVE_PATH = "/cyberplayer/libs/";
    public static final String CYBERPLAYER_LIB_NAME = "libcyberplayer.so";
    public static final String CYBERPLAYER_ZIP_PKG_LOCAL_RELATIVE_PATH = "/cyberplayer/";
    public static final String CYBERPLAYER_CLASS_PKG_NAME = "com.baidu.cyberplayer.engine";

    /* renamed from: a  reason: collision with root package name */
    private static String f705a = CYBERPLAYER_CLASS_PKG_NAME;
    private static String b = null;

    public static String getEnginePkgName() {
        return f705a;
    }

    public static void setEnginePkgName(String str) {
        f705a = str;
    }

    public static String getLibPath() {
        return b;
    }

    public static void setLibPath(String str) {
        b = str;
    }
}
