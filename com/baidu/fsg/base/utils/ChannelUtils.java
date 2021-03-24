package com.baidu.fsg.base.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5335a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f5336b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5337c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f5338d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5339e;

    public static String getHostAppId() {
        return f5339e;
    }

    public static String getHostPackageName() {
        return f5337c;
    }

    public static String getHostUA() {
        return f5338d;
    }

    public static String getSDKVersion() {
        return f5336b;
    }

    public static void initBussinessParams(String str, boolean z, String str2) {
        f5336b = str;
        f5335a = z;
        f5339e = str2;
    }

    public static void initHostParams(String str) {
        f5338d = str;
    }

    public static boolean isSpecailPackage() {
        return f5335a;
    }

    public static void setHostPackageName(String str) {
        f5337c = str;
    }
}
