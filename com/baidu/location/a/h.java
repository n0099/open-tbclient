package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static com.baidu.location.f.a MW;
    private static Location Nv;
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
        Nv = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        MW = aVar;
    }

    public static com.baidu.location.f.a mW() {
        return MW;
    }

    public static Location mX() {
        return Nv;
    }
}
