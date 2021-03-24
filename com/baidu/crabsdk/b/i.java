package com.baidu.crabsdk.b;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static Locale f4686a;

    public static void a() {
        f4686a = Locale.getDefault();
    }

    public static String b() {
        return f4686a.getLanguage() + "-" + f4686a.getCountry();
    }

    public static String c() {
        return f4686a.getCountry();
    }

    public static String d() {
        return f4686a.getLanguage();
    }
}
