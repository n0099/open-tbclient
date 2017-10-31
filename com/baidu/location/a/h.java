package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static com.baidu.location.f.a KG;
    private static Location Ld;
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
        Ld = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        KG = aVar;
    }

    public static com.baidu.location.f.a mc() {
        return KG;
    }

    public static Location md() {
        return Ld;
    }
}
