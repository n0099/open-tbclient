package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static com.baidu.location.f.a Ip;
    private static long a;
    private static Location c;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        a = j;
    }

    public static void a(Location location) {
        c = location;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static void c(com.baidu.location.f.a aVar) {
        Ip = aVar;
    }

    public static com.baidu.location.f.a mu() {
        return Ip;
    }

    public static Location mv() {
        return c;
    }
}
