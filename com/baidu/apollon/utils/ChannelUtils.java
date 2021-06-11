package com.baidu.apollon.utils;
/* loaded from: classes.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4035a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f4036b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f4037c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f4038d;

    public static String getHostPackageName() {
        return f4037c;
    }

    public static String getHostUA() {
        return f4038d;
    }

    public static String getSDKVersion() {
        return f4036b;
    }

    public static void initBussinessParams(String str, boolean z) {
        f4036b = str;
        f4035a = z;
    }

    public static void initHostParams(String str) {
        f4038d = str;
    }

    public static boolean isSpecailPackage() {
        return f4035a;
    }

    public static void setHostPackageName(String str) {
        f4037c = str;
    }
}
