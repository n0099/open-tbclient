package com.baidu.crabsdk.lite.a;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static Locale f4676a;

    public static void a() {
        f4676a = Locale.getDefault();
    }

    public static String b() {
        return f4676a.getLanguage() + "-" + f4676a.getCountry();
    }
}
