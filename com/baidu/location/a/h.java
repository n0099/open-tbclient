package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static long a;
    private static Location aBL;
    private static com.baidu.location.f.a aBq;
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
        aBL = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        aBq = aVar;
    }

    public static com.baidu.location.f.a uv() {
        return aBq;
    }

    public static Location uw() {
        return aBL;
    }
}
