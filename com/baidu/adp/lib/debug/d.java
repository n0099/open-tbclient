package com.baidu.adp.lib.debug;

import android.os.Handler;
import com.baidu.adp.lib.debug.a.q;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    public static e f;
    private static int g = 0;
    private static String h = null;
    private static String i = null;
    private static int j = 0;
    private static int k = 0;
    private static String l = null;
    private static q m = null;
    private static q n = null;
    public static Handler a = null;
    public static int b = 0;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;

    public static void a(int i2) {
        g = i2;
        try {
            if (a != null) {
                a.sendEmptyMessage(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a() {
        return g;
    }

    public static void a(String str) {
        h = str;
        try {
            if (a != null) {
                a.sendEmptyMessage(1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String b() {
        return h;
    }

    public static void b(String str) {
        i = str;
        try {
            if (a != null) {
                a.sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String c() {
        return i;
    }

    public static void b(int i2) {
        j = i2;
        try {
            if (a != null) {
                a.sendEmptyMessage(3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int d() {
        return j;
    }

    public static void c(int i2) {
        k = i2;
        try {
            if (a != null) {
                a.sendEmptyMessage(4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int e() {
        return k;
    }

    public static void a(q qVar) {
        m = qVar;
        try {
            if (a != null) {
                a.sendEmptyMessage(6);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static q f() {
        return m;
    }

    public static void b(q qVar) {
        n = qVar;
    }

    public static void g() {
        n.a(a(m.a() + n.a()));
        n.b(a(m.b() + n.b()));
        n.c(a(m.c() + n.c()));
    }

    public static q h() {
        return n;
    }

    public static double a(double d2) {
        return new BigDecimal(d2).setScale(2, 4).doubleValue();
    }

    public static void c(String str) {
        l = str;
        try {
            if (a != null) {
                a.sendEmptyMessage(5);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String i() {
        return l;
    }
}
