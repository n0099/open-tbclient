package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String vz = null;
    private static String vA = null;
    private static int vB = 0;
    private static int vC = 0;
    private static String vD = null;
    private static e.a vE = null;
    private static e.a vF = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int vG = 0;
    public static boolean vH = false;
    public static boolean vI = false;
    public static boolean vJ = false;

    public static void a(e.a aVar) {
        vE = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a gg() {
        return vF;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
