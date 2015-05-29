package com.baidu.adp.a.a;

import android.os.Handler;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int nI = 0;
    private static String nJ = null;
    private static String nK = null;
    private static int nL = 0;
    private static int nM = 0;
    private static String nN = null;
    private static f nO = null;
    private static f nP = null;
    public static Handler mHandler = null;
    public static int nQ = 0;
    public static boolean nR = false;
    public static boolean nS = false;
    public static boolean nT = false;

    public static void p(int i) {
        nI = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(f fVar) {
        nO = fVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static f dP() {
        return nP;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
