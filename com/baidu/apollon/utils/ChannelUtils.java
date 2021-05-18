package com.baidu.apollon.utils;
/* loaded from: classes.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4013a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f4014b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f4015c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f4016d;

    public static String getHostPackageName() {
        return f4015c;
    }

    public static String getHostUA() {
        return f4016d;
    }

    public static String getSDKVersion() {
        return f4014b;
    }

    public static void initBussinessParams(String str, boolean z) {
        f4014b = str;
        f4013a = z;
    }

    public static void initHostParams(String str) {
        f4016d = str;
    }

    public static boolean isSpecailPackage() {
        return f4013a;
    }

    public static void setHostPackageName(String str) {
        f4015c = str;
    }
}
