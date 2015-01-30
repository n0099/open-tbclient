package com.baidu.adp.a.a;

import android.os.Handler;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int cv = 0;
    private static String cw = null;
    private static String cx = null;
    private static int cy = 0;
    private static int cz = 0;
    private static String cA = null;
    private static f cB = null;
    private static f cC = null;
    public static Handler mHandler = null;
    public static int cD = 0;
    public static boolean cE = false;
    public static boolean cF = false;
    public static boolean cG = false;

    public static void o(int i) {
        cv = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(f fVar) {
        cB = fVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static f ap() {
        return cC;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
