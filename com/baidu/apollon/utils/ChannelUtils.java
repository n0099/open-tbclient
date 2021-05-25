package com.baidu.apollon.utils;
/* loaded from: classes.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4016a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f4017b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f4018c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f4019d;

    public static String getHostPackageName() {
        return f4018c;
    }

    public static String getHostUA() {
        return f4019d;
    }

    public static String getSDKVersion() {
        return f4017b;
    }

    public static void initBussinessParams(String str, boolean z) {
        f4017b = str;
        f4016a = z;
    }

    public static void initHostParams(String str) {
        f4019d = str;
    }

    public static boolean isSpecailPackage() {
        return f4016a;
    }

    public static void setHostPackageName(String str) {
        f4018c = str;
    }
}
