package com.baidu.location.b;

import android.location.Location;
/* loaded from: classes15.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static long f2665a;

    /* renamed from: b  reason: collision with root package name */
    private static com.baidu.location.c.a f2666b;
    private static Location c;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        f2665a = j;
    }

    public static void a(Location location) {
        c = location;
    }

    public static void a(com.baidu.location.c.a aVar) {
        f2666b = aVar;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return f2665a;
    }

    public static com.baidu.location.c.a c() {
        return f2666b;
    }

    public static Location d() {
        return c;
    }
}
