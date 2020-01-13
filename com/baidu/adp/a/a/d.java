package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String nc = null;
    private static String nd = null;
    private static int ne = 0;
    private static int nf = 0;
    private static String ng = null;
    private static e.a nh = null;
    private static e.a ni = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int nj = 0;
    public static boolean nk = false;
    public static boolean nl = false;
    public static boolean nm = false;

    public static void a(e.a aVar) {
        nh = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a eL() {
        return ni;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
