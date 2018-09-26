package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes2.dex */
public class n {
    private static Location YH;
    private static com.baidu.location.b.a YZ;
    private static long a;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        a = j;
    }

    public static void a(Location location) {
        YH = location;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static void b(com.baidu.location.b.a aVar) {
        YZ = aVar;
    }

    public static com.baidu.location.b.a rC() {
        return YZ;
    }

    public static Location rD() {
        return YH;
    }
}
