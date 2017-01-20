package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int gs = 0;
    private static String gt = null;
    private static String gu = null;
    private static int gv = 0;
    private static int gw = 0;
    private static String gx = null;
    private static e.a gy = null;
    private static e.a gz = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int gA = 0;
    public static boolean gB = false;
    public static boolean gC = false;
    public static boolean gD = false;

    public static void H(int i) {
        gs = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(e.a aVar) {
        gy = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a be() {
        return gz;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
