package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes.dex */
public class h {
    private static com.baidu.location.f.a VL;
    private static Location Wf;
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
        Wf = location;
    }

    public static void c(com.baidu.location.f.a aVar) {
        VL = aVar;
    }

    public static com.baidu.location.f.a qn() {
        return VL;
    }

    public static Location qo() {
        return Wf;
    }
}
