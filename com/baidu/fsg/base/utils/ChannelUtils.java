package com.baidu.fsg.base.utils;
/* loaded from: classes5.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1962a;

    /* renamed from: b  reason: collision with root package name */
    private static String f1963b;
    private static String c = "";
    private static String d;
    private static String e;

    public static void initBussinessParams(String str, boolean z, String str2) {
        f1963b = str;
        f1962a = z;
        e = str2;
    }

    public static String getHostAppId() {
        return e;
    }

    public static boolean isSpecailPackage() {
        return f1962a;
    }

    public static String getSDKVersion() {
        return f1963b;
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
