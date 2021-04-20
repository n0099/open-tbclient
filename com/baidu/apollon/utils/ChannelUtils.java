package com.baidu.apollon.utils;
/* loaded from: classes.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3957a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f3958b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f3959c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f3960d;

    public static String getHostPackageName() {
        return f3959c;
    }

    public static String getHostUA() {
        return f3960d;
    }

    public static String getSDKVersion() {
        return f3958b;
    }

    public static void initBussinessParams(String str, boolean z) {
        f3958b = str;
        f3957a = z;
    }

    public static void initHostParams(String str) {
        f3960d = str;
    }

    public static boolean isSpecailPackage() {
        return f3957a;
    }

    public static void setHostPackageName(String str) {
        f3959c = str;
    }
}
