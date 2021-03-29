package com.baidu.fsg.base.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5336a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f5337b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5338c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f5339d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5340e;

    public static String getHostAppId() {
        return f5340e;
    }

    public static String getHostPackageName() {
        return f5338c;
    }

    public static String getHostUA() {
        return f5339d;
    }

    public static String getSDKVersion() {
        return f5337b;
    }

    public static void initBussinessParams(String str, boolean z, String str2) {
        f5337b = str;
        f5336a = z;
        f5340e = str2;
    }

    public static void initHostParams(String str) {
        f5339d = str;
    }

    public static boolean isSpecailPackage() {
        return f5336a;
    }

    public static void setHostPackageName(String str) {
        f5338c = str;
    }
}
