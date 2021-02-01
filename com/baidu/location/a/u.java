package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes4.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static long f2582a;

    /* renamed from: b  reason: collision with root package name */
    private static com.baidu.location.b.a f2583b;
    private static Location c;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        f2582a = j;
    }

    public static void a(Location location) {
        c = location;
    }

    public static void a(com.baidu.location.b.a aVar) {
        f2583b = aVar;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return f2582a;
    }

    public static com.baidu.location.b.a c() {
        return f2583b;
    }

    public static Location d() {
        return c;
    }
}
