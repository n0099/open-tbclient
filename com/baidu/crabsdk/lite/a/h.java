package com.baidu.crabsdk.lite.a;

import java.util.Locale;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static Locale f4734a;

    public static void a() {
        f4734a = Locale.getDefault();
    }

    public static String b() {
        return f4734a.getLanguage() + "-" + f4734a.getCountry();
    }
}
