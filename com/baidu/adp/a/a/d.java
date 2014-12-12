package com.baidu.adp.a.a;

import android.os.Handler;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int cu = 0;
    private static String cv = null;
    private static String cw = null;
    private static int cx = 0;
    private static int cy = 0;
    private static String cz = null;
    private static f cA = null;
    private static f cB = null;
    public static Handler mHandler = null;
    public static int cC = 0;
    public static boolean cD = false;
    public static boolean cE = false;
    public static boolean cF = false;

    public static void o(int i) {
        cu = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(f fVar) {
        cA = fVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static f ap() {
        return cB;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
