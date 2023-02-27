package com.baidu.mapapi;
/* loaded from: classes2.dex */
public class OpenLogUtil {
    public static ModuleName a = null;
    public static boolean b = true;
    public static boolean c;
    public static String d;

    public static String getMapLogFilePath() {
        return d;
    }

    public static boolean isMapLogEnable() {
        return c;
    }

    public static boolean isNativeLogAnalysisEnable() {
        return b;
    }

    public static void setMapLogEnable(boolean z) {
        c = z;
    }

    public static void setMapLogFilePath(String str) {
        d = str;
    }

    public static void setNativeLogAnalysisEnable(boolean z) {
        b = z;
    }

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, moduleName.ordinal());
    }
}
