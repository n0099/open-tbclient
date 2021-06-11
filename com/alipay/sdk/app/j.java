package com.alipay.sdk.app;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1804a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f1805b;

    public static void a(String str) {
        f1805b = str;
    }

    public static boolean b() {
        return f1804a;
    }

    public static String c() {
        k b2 = k.b(k.CANCELED.a());
        return a(b2.a(), b2.b(), "");
    }

    public static String d() {
        k b2 = k.b(k.DOUBLE_REQUEST.a());
        return a(b2.a(), b2.b(), "");
    }

    public static String e() {
        k b2 = k.b(k.PARAMS_ERROR.a());
        return a(b2.a(), b2.b(), "");
    }

    public static String a() {
        return f1805b;
    }

    public static void a(boolean z) {
        f1804a = z;
    }

    public static String a(int i2, String str, String str2) {
        return "resultStatus={" + i2 + "};memo={" + str + "};result={" + str2 + "}";
    }
}
