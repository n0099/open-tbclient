package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int gv = 0;
    private static String gw = null;
    private static String gx = null;
    private static int gy = 0;
    private static int gz = 0;
    private static String gA = null;
    private static e.a gB = null;
    private static e.a gC = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int gD = 0;
    public static boolean gE = false;
    public static boolean gF = false;
    public static boolean gG = false;

    public static void G(int i) {
        gv = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(e.a aVar) {
        gB = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a be() {
        return gC;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
