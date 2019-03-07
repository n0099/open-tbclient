package com.baidu.pass.biometrics.base.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {
    private static String mHostPackageName = "";
    private static String sHostAppId;
    private static String sHostUA;
    private static boolean sIsSpecialPkg;
    private static String sVersion;

    public static void initBussinessParams(String str, boolean z, String str2) {
        sVersion = str;
        sIsSpecialPkg = z;
        sHostAppId = str2;
    }

    public static String getHostAppId() {
        return sHostAppId;
    }

    public static boolean isSpecailPackage() {
        return sIsSpecialPkg;
    }

    public static String getSDKVersion() {
        return sVersion;
    }

    public static String getHostUA() {
        return sHostUA;
    }

    public static void initHostParams(String str) {
        sHostUA = str;
    }

    public static String getHostPackageName() {
        return mHostPackageName;
    }

    public static void setHostPackageName(String str) {
        mHostPackageName = str;
    }
}
