package com.baidu.location.a;

import android.location.Location;
/* loaded from: classes6.dex */
public class n {
    private static long a;
    private static com.baidu.location.e.a adA;
    private static Location adj;
    private static String d;

    public static String a() {
        return d;
    }

    public static void a(long j) {
        a = j;
    }

    public static void a(Location location) {
        adj = location;
    }

    public static void a(String str) {
        d = str;
    }

    public static long b() {
        return a;
    }

    public static void c(com.baidu.location.e.a aVar) {
        adA = aVar;
    }

    public static com.baidu.location.e.a tn() {
        return adA;
    }

    public static Location tp() {
        return adj;
    }
}
