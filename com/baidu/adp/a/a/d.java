package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String pz = null;
    private static String pA = null;
    private static int pB = 0;
    private static int pC = 0;
    private static String pD = null;
    private static e.a pE = null;
    private static e.a pF = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int pG = 0;
    public static boolean pH = false;
    public static boolean pI = false;
    public static boolean pJ = false;

    public static void I(int i) {
        mFps = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(e.a aVar) {
        pE = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a cx() {
        return pF;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
