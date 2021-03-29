package com.baidu.apollon.utils;
/* loaded from: classes.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3922a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f3923b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f3924c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f3925d;

    public static String getHostPackageName() {
        return f3924c;
    }

    public static String getHostUA() {
        return f3925d;
    }

    public static String getSDKVersion() {
        return f3923b;
    }

    public static void initBussinessParams(String str, boolean z) {
        f3923b = str;
        f3922a = z;
    }

    public static void initHostParams(String str) {
        f3925d = str;
    }

    public static boolean isSpecailPackage() {
        return f3922a;
    }

    public static void setHostPackageName(String str) {
        f3924c = str;
    }
}
