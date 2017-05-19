package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static Location MN;
    private static com.baidu.location.f.a Mo;
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
        MN = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        Mo = aVar;
    }

    public static com.baidu.location.f.a mD() {
        return Mo;
    }

    public static Location mE() {
        return MN;
    }
}
