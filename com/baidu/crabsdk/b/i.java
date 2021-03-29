package com.baidu.crabsdk.b;

import java.util.Locale;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static Locale f4687a;

    public static void a() {
        f4687a = Locale.getDefault();
    }

    public static String b() {
        return f4687a.getLanguage() + "-" + f4687a.getCountry();
    }

    public static String c() {
        return f4687a.getCountry();
    }

    public static String d() {
        return f4687a.getLanguage();
    }
}
