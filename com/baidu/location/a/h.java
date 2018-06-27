package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes2.dex */
public class h {
    private static com.baidu.location.f.a VN;
    private static Location Wh;
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
        Wh = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        VN = aVar;
    }

    public static com.baidu.location.f.a qn() {
        return VN;
    }

    public static Location qo() {
        return Wh;
    }
}
