package com.baidu.fsg.base.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5371a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f5372b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5373c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f5374d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5375e;

    public static String getHostAppId() {
        return f5375e;
    }

    public static String getHostPackageName() {
        return f5373c;
    }

    public static String getHostUA() {
        return f5374d;
    }

    public static String getSDKVersion() {
        return f5372b;
    }

    public static void initBussinessParams(String str, boolean z, String str2) {
        f5372b = str;
        f5371a = z;
        f5375e = str2;
    }

    public static void initHostParams(String str) {
        f5374d = str;
    }

    public static boolean isSpecailPackage() {
        return f5371a;
    }

    public static void setHostPackageName(String str) {
        f5373c = str;
    }
}
