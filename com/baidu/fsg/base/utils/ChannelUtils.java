package com.baidu.fsg.base.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5363a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f5364b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5365c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f5366d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5367e;

    public static String getHostAppId() {
        return f5367e;
    }

    public static String getHostPackageName() {
        return f5365c;
    }

    public static String getHostUA() {
        return f5366d;
    }

    public static String getSDKVersion() {
        return f5364b;
    }

    public static void initBussinessParams(String str, boolean z, String str2) {
        f5364b = str;
        f5363a = z;
        f5367e = str2;
    }

    public static void initHostParams(String str) {
        f5366d = str;
    }

    public static boolean isSpecailPackage() {
        return f5363a;
    }

    public static void setHostPackageName(String str) {
        f5365c = str;
    }
}
