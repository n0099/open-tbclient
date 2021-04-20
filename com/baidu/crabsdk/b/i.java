package com.baidu.crabsdk.b;

import java.util.Locale;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static Locale f4722a;

    public static void a() {
        f4722a = Locale.getDefault();
    }

    public static String b() {
        return f4722a.getLanguage() + "-" + f4722a.getCountry();
    }

    public static String c() {
        return f4722a.getCountry();
    }

    public static String d() {
        return f4722a.getLanguage();
    }
}
