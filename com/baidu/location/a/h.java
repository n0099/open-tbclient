package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static com.baidu.location.f.a NF;
    private static Location Oc;
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
        Oc = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        NF = aVar;
    }

    public static com.baidu.location.f.a nb() {
        return NF;
    }

    public static Location nc() {
        return Oc;
    }
}
