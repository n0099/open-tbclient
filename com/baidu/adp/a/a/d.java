package com.baidu.adp.a.a;

import android.os.Handler;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int nF = 0;
    private static String nG = null;
    private static String nH = null;
    private static int nI = 0;
    private static int nJ = 0;
    private static String nK = null;
    private static f nL = null;
    private static f nM = null;
    public static Handler mHandler = null;
    public static int nN = 0;
    public static boolean nO = false;
    public static boolean nP = false;
    public static boolean nQ = false;

    public static void p(int i) {
        nF = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(f fVar) {
        nL = fVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static f dN() {
        return nM;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
