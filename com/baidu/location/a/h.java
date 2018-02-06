package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static long a;
    private static Location aBT;
    private static com.baidu.location.f.a aBy;
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
        aBT = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        aBy = aVar;
    }

    public static com.baidu.location.f.a uv() {
        return aBy;
    }

    public static Location uw() {
        return aBT;
    }
}
