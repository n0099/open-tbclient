package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static long a;
    private static Location aAo;
    private static com.baidu.location.f.a azR;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        a = j;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static void c(Location location) {
        aAo = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        azR = aVar;
    }

    public static com.baidu.location.f.a tI() {
        return azR;
    }

    public static Location tJ() {
        return aAo;
    }
}
