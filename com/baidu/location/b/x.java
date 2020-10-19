package com.baidu.location.b;

import android.location.Location;
/* loaded from: classes7.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static long f1914a;
    private static com.baidu.location.c.a b;
    private static Location c;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        f1914a = j;
    }

    public static void a(Location location) {
        c = location;
    }

    public static void a(com.baidu.location.c.a aVar) {
        b = aVar;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return f1914a;
    }

    public static com.baidu.location.c.a c() {
        return b;
    }

    public static Location d() {
        return c;
    }
}
