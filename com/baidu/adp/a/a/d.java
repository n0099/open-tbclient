package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String vB = null;
    private static String vC = null;
    private static int vD = 0;
    private static int vE = 0;
    private static String vF = null;
    private static e.a vG = null;
    private static e.a vH = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int vI = 0;
    public static boolean vJ = false;
    public static boolean vK = false;
    public static boolean vL = false;

    public static void a(e.a aVar) {
        vG = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a gj() {
        return vH;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
