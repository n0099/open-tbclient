package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int nK = 0;
    private static String nL = null;
    private static String nM = null;
    private static int nN = 0;
    private static int nO = 0;
    private static String nP = null;
    private static e.a nQ = null;
    private static e.a nR = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int nS = 0;
    public static boolean nT = false;
    public static boolean nU = false;
    public static boolean nV = false;

    public static void A(int i) {
        nK = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(e.a aVar) {
        nQ = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a dT() {
        return nR;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
