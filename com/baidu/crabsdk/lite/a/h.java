package com.baidu.crabsdk.lite.a;

import java.util.Locale;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static Locale f4880a;

    public static void a() {
        f4880a = Locale.getDefault();
    }

    public static String b() {
        return f4880a.getLanguage() + "-" + f4880a.getCountry();
    }
}
