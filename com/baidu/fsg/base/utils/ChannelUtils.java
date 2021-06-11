package com.baidu.fsg.base.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5306a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f5307b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5308c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f5309d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5310e;

    public static String getHostAppId() {
        return f5310e;
    }

    public static String getHostPackageName() {
        return f5308c;
    }

    public static String getHostUA() {
        return f5309d;
    }

    public static String getSDKVersion() {
        return f5307b;
    }

    public static void initBussinessParams(String str, boolean z, String str2) {
        f5307b = str;
        f5306a = z;
        f5310e = str2;
    }

    public static void initHostParams(String str) {
        f5309d = str;
    }

    public static boolean isSpecailPackage() {
        return f5306a;
    }

    public static void setHostPackageName(String str) {
        f5308c = str;
    }
}
