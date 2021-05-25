package com.baidu.fsg.base.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5263a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f5264b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5265c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f5266d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5267e;

    public static String getHostAppId() {
        return f5267e;
    }

    public static String getHostPackageName() {
        return f5265c;
    }

    public static String getHostUA() {
        return f5266d;
    }

    public static String getSDKVersion() {
        return f5264b;
    }

    public static void initBussinessParams(String str, boolean z, String str2) {
        f5264b = str;
        f5263a = z;
        f5267e = str2;
    }

    public static void initHostParams(String str) {
        f5266d = str;
    }

    public static boolean isSpecailPackage() {
        return f5263a;
    }

    public static void setHostPackageName(String str) {
        f5265c = str;
    }
}
