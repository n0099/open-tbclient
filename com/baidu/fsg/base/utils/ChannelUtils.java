package com.baidu.fsg.base.utils;
/* loaded from: classes16.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1506a;
    private static String b;
    private static String c = "";
    private static String d;
    private static String e;

    public static void initBussinessParams(String str, boolean z, String str2) {
        b = str;
        f1506a = z;
        e = str2;
    }

    public static String getHostAppId() {
        return e;
    }

    public static boolean isSpecailPackage() {
        return f1506a;
    }

    public static String getSDKVersion() {
        return b;
    }

    public static String getHostUA() {
        return d;
    }

    public static void initHostParams(String str) {
        d = str;
    }

    public static String getHostPackageName() {
        return c;
    }

    public static void setHostPackageName(String str) {
        c = str;
    }
}
