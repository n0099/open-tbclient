package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String sx = null;
    private static String sy = null;
    private static int sz = 0;
    private static int sA = 0;
    private static String sB = null;
    private static e.a sC = null;
    private static e.a sD = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int sE = 0;
    public static boolean sF = false;
    public static boolean sG = false;
    public static boolean sH = false;

    public static void a(e.a aVar) {
        sC = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a eJ() {
        return sD;
    }

    public static double e(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
