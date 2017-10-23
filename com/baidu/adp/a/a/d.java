package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String nh = null;
    private static String ni = null;
    private static int nj = 0;
    private static int nk = 0;
    private static String nl = null;
    private static e.a nm = null;
    private static e.a nn = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int np = 0;
    public static boolean nq = false;
    public static boolean nr = false;
    public static boolean ns = false;

    public static void F(int i) {
        mFps = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(e.a aVar) {
        nm = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a cm() {
        return nn;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
