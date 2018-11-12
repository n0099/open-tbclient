package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String vD = null;
    private static String vE = null;
    private static int vF = 0;
    private static int vG = 0;
    private static String vH = null;
    private static e.a vI = null;
    private static e.a vJ = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int vK = 0;
    public static boolean vL = false;
    public static boolean vM = false;
    public static boolean vN = false;

    public static void a(e.a aVar) {
        vI = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a gj() {
        return vJ;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
