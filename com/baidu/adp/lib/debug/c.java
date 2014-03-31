package com.baidu.adp.lib.debug;

import android.os.Handler;
import com.baidu.adp.lib.debug.a.q;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public final class c {
    private static int f = 0;
    private static String g = null;
    private static String h = null;
    private static int i = 0;
    private static int j = 0;
    private static String k = null;
    private static q l = null;
    private static q m = null;
    public static Handler a = null;
    public static int b = 0;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;

    public static void a(int i2) {
        f = i2;
        try {
            if (a != null) {
                a.sendEmptyMessage(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a() {
        return f;
    }

    public static void a(String str) {
        g = str;
        try {
            if (a != null) {
                a.sendEmptyMessage(1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String b() {
        return g;
    }

    public static void b(String str) {
        h = str;
        try {
            if (a != null) {
                a.sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String c() {
        return h;
    }

    public static void b(int i2) {
        i = i2;
        try {
            if (a != null) {
                a.sendEmptyMessage(3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int d() {
        return i;
    }

    public static void c(int i2) {
        j = i2;
        try {
            if (a != null) {
                a.sendEmptyMessage(4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int e() {
        return j;
    }

    public static void a(q qVar) {
        l = qVar;
        try {
            if (a != null) {
                a.sendEmptyMessage(6);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static q f() {
        return l;
    }

    public static void b(q qVar) {
        m = qVar;
    }

    public static void g() {
        m.a(a(l.a() + m.a()));
        m.b(a(l.b() + m.b()));
        m.c(a(l.c() + m.c()));
    }

    public static q h() {
        return m;
    }

    public static double a(double d2) {
        return new BigDecimal(d2).setScale(2, 4).doubleValue();
    }

    public static void c(String str) {
        k = str;
        try {
            if (a != null) {
                a.sendEmptyMessage(5);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String i() {
        return k;
    }
}
