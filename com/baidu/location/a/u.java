package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes4.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static long f1937a;
    private static com.baidu.location.b.a b;
    private static Location c;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        f1937a = j;
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
        return f1937a;
    }

    public static com.baidu.location.b.a c() {
        return b;
    }

    public static Location d() {
        return c;
    }
}
