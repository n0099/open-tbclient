package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static com.baidu.location.f.a MU;
    private static Location Nt;
    private static long a;
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

    public static void b(Location location) {
        Nt = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        MU = aVar;
    }

    public static com.baidu.location.f.a mW() {
        return MU;
    }

    public static Location mX() {
        return Nt;
    }
}
