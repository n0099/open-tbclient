package com.baidu.fsg.base.utils;
/* loaded from: classes6.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2014a;

    /* renamed from: b  reason: collision with root package name */
    private static String f2015b;
    private static String c = "";
    private static String d;
    private static String e;

    public static void initBussinessParams(String str, boolean z, String str2) {
        f2015b = str;
        f2014a = z;
        e = str2;
    }

    public static String getHostAppId() {
        return e;
    }

    public static boolean isSpecailPackage() {
        return f2014a;
    }

    public static String getSDKVersion() {
        return f2015b;
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
