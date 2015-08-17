package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int nI = 0;
    private static String nJ = null;
    private static String nK = null;
    private static int nL = 0;
    private static int nM = 0;
    private static String nN = null;
    private static e.a nO = null;
    private static e.a nP = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int nQ = 0;
    public static boolean nR = false;
    public static boolean nS = false;
    public static boolean nT = false;

    public static void r(int i) {
        nI = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(e.a aVar) {
        nO = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a dQ() {
        return nP;
    }

    public static double b(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
