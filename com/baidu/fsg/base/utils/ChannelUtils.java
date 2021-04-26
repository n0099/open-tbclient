package com.baidu.fsg.base.utils;
/* loaded from: classes2.dex */
public final class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5509a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f5510b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5511c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f5512d;

    /* renamed from: e  reason: collision with root package name */
    public static String f5513e;

    public static String getHostAppId() {
        return f5513e;
    }

    public static String getHostPackageName() {
        return f5511c;
    }

    public static String getHostUA() {
        return f5512d;
    }

    public static String getSDKVersion() {
        return f5510b;
    }

    public static void initBussinessParams(String str, boolean z, String str2) {
        f5510b = str;
        f5509a = z;
        f5513e = str2;
    }

    public static void initHostParams(String str) {
        f5512d = str;
    }

    public static boolean isSpecailPackage() {
        return f5509a;
    }

    public static void setHostPackageName(String str) {
        f5511c = str;
    }
}
