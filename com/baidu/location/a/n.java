package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes6.dex */
public class n {
    private static long a;
    private static com.baidu.location.b.a adG;
    private static Location ado;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        a = j;
    }

    public static void a(Location location) {
        ado = location;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static void b(com.baidu.location.b.a aVar) {
        adG = aVar;
    }

    public static com.baidu.location.b.a tw() {
        return adG;
    }

    public static Location tx() {
        return ado;
    }
}
