package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes2.dex */
public class n {
    private static Location Wg;
    private static com.baidu.location.b.a Wy;
    private static long a;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        a = j;
    }

    public static void a(Location location) {
        Wg = location;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static void b(com.baidu.location.b.a aVar) {
        Wy = aVar;
    }

    public static com.baidu.location.b.a qx() {
        return Wy;
    }

    public static Location qy() {
        return Wg;
    }
}
