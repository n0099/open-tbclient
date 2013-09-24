package com.baidu.adp.lib.debug;

import android.os.Handler;
import com.baidu.adp.lib.debug.a.q;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class b {
    private static int e = 0;
    private static String f = null;
    private static String g = null;
    private static int h = 0;
    private static int i = 0;
    private static String j = null;
    private static q k = null;
    private static q l = null;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f411a = null;
    public static int b = 0;
    public static boolean c = false;
    public static boolean d = false;

    public static void a(int i2) {
        e = i2;
        try {
            if (f411a != null) {
                f411a.sendEmptyMessage(0);
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
            if (f411a != null) {
                f411a.sendEmptyMessage(1);
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
            if (f411a != null) {
                f411a.sendEmptyMessage(2);
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
            if (f411a != null) {
                f411a.sendEmptyMessage(3);
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
            if (f411a != null) {
                f411a.sendEmptyMessage(4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int e() {
        return i;
    }

    public static void a(q qVar) {
        k = qVar;
        try {
            if (f411a != null) {
                f411a.sendEmptyMessage(6);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static q f() {
        return k;
    }

    public static void b(q qVar) {
        l = qVar;
    }

    public static void g() {
        l.a(a(k.a() + l.a()));
        l.b(a(k.b() + l.b()));
        l.c(a(k.c() + l.c()));
    }

    public static q h() {
        return l;
    }

    public static double a(double d2) {
        return new BigDecimal(d2).setScale(2, 4).doubleValue();
    }

    public static void c(String str) {
        j = str;
        try {
            if (f411a != null) {
                f411a.sendEmptyMessage(5);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String i() {
        return j;
    }
}
