package com.baidu.apollon.utils;
/* loaded from: classes.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4012a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f4013b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f4014c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f4015d;

    public static String getHostPackageName() {
        return f4014c;
    }

    public static String getHostUA() {
        return f4015d;
    }

    public static String getSDKVersion() {
        return f4013b;
    }

    public static void initBussinessParams(String str, boolean z) {
        f4013b = str;
        f4012a = z;
    }

    public static void initHostParams(String str) {
        f4015d = str;
    }

    public static boolean isSpecailPackage() {
        return f4012a;
    }

    public static void setHostPackageName(String str) {
        f4014c = str;
    }
}
