package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes3.dex */
public class n {
    private static long a;
    private static com.baidu.location.e.a b;
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

    public static void a(com.baidu.location.e.a aVar) {
        b = aVar;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static com.baidu.location.e.a c() {
        return b;
    }

    public static Location d() {
        return c;
    }
}
