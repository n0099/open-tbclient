package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String sv = null;
    private static String sw = null;
    private static int sx = 0;
    private static int sy = 0;
    private static String sz = null;
    private static e.a sA = null;
    private static e.a sB = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int sC = 0;
    public static boolean sD = false;
    public static boolean sE = false;
    public static boolean sF = false;

    public static void a(e.a aVar) {
        sA = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a eJ() {
        return sB;
    }

    public static double e(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
