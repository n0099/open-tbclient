package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String li = null;
    private static String lj = null;
    private static int lk = 0;
    private static int ll = 0;
    private static String lm = null;
    private static e.a ln = null;
    private static e.a lo = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int lq = 0;
    public static boolean lr = false;
    public static boolean ls = false;
    public static boolean lt = false;

    public static void a(e.a aVar) {
        ln = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a er() {
        return lo;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
