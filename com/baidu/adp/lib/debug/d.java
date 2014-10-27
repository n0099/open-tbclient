package com.baidu.adp.lib.debug;

import android.os.Handler;
import com.baidu.adp.lib.debug.a.r;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    public static e gk;
    private static int fY = 0;
    private static String fZ = null;
    private static String ga = null;
    private static int gb = 0;
    private static int gc = 0;
    private static String gd = null;
    private static r ge = null;
    private static r gf = null;
    public static Handler mHandler = null;
    public static int gg = 0;
    public static boolean gh = false;
    public static boolean gi = false;
    public static boolean gj = false;

    public static void o(int i) {
        fY = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int cA() {
        return fY;
    }

    public static void L(String str) {
        fZ = str;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String cB() {
        return fZ;
    }

    public static void M(String str) {
        ga = str;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String cC() {
        return ga;
    }

    public static void p(int i) {
        gb = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int cD() {
        return gb;
    }

    public static void q(int i) {
        gc = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int cE() {
        return gc;
    }

    public static void a(r rVar) {
        ge = rVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static r cF() {
        return ge;
    }

    public static void b(r rVar) {
        gf = rVar;
    }

    public static void cG() {
        gf.b(a(ge.cP() + gf.cP()));
        gf.c(a(ge.cQ() + gf.cQ()));
        gf.d(a(ge.cR() + gf.cR()));
    }

    public static r cH() {
        return gf;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }

    public static void N(String str) {
        gd = str;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String cI() {
        return gd;
    }
}
