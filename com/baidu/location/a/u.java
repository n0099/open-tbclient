package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes10.dex */
public class u {
    private static long a;
    private static com.baidu.location.b.a b;
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

    public static void a(com.baidu.location.b.a aVar) {
        b = aVar;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static com.baidu.location.b.a c() {
        return b;
    }

    public static Location d() {
        return c;
    }
}
