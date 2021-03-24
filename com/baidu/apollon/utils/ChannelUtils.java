package com.baidu.apollon.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3921a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f3922b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f3923c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f3924d;

    public static String getHostPackageName() {
        return f3923c;
    }

    public static String getHostUA() {
        return f3924d;
    }

    public static String getSDKVersion() {
        return f3922b;
    }

    public static void initBussinessParams(String str, boolean z) {
        f3922b = str;
        f3921a = z;
    }

    public static void initHostParams(String str) {
        f3924d = str;
    }

    public static boolean isSpecailPackage() {
        return f3921a;
    }

    public static void setHostPackageName(String str) {
        f3923c = str;
    }
}
