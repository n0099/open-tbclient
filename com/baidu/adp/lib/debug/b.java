package com.baidu.adp.lib.debug;

import android.os.Handler;
/* loaded from: classes.dex */
public class b {
    private static int e = 0;
    private static String f = null;
    private static String g = null;
    private static int h = 0;
    private static int i = 0;
    private static String j = null;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f399a = null;
    public static int b = 0;
    public static boolean c = false;
    public static boolean d = false;

    public static void a(int i2) {
        e = i2;
        try {
            if (f399a != null) {
                f399a.sendEmptyMessage(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a() {
        return e;
    }

    public static void a(String str) {
        f = str;
        try {
            if (f399a != null) {
                f399a.sendEmptyMessage(1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String b() {
        return f;
    }

    public static void b(String str) {
        g = str;
        try {
            if (f399a != null) {
                f399a.sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String c() {
        return g;
    }

    public static void b(int i2) {
        h = i2;
        try {
            if (f399a != null) {
                f399a.sendEmptyMessage(3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int d() {
        return h;
    }

    public static void c(int i2) {
        i = i2;
        try {
            if (f399a != null) {
                f399a.sendEmptyMessage(4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int e() {
        return i;
    }

    public static void c(String str) {
        j = str;
        try {
            if (f399a != null) {
                f399a.sendEmptyMessage(5);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String f() {
        return j;
    }
}
