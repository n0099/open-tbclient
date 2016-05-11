package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int dG = 0;
    private static String dH = null;
    private static String dI = null;
    private static int dJ = 0;
    private static int dK = 0;
    private static String dL = null;
    private static e.a dM = null;
    private static e.a dN = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int dO = 0;
    public static boolean dP = false;
    public static boolean dQ = false;
    public static boolean dR = false;

    public static void q(int i) {
        dG = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(e.a aVar) {
        dM = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a aj() {
        return dN;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
