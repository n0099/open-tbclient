package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String lY = null;
    private static String lZ = null;
    private static int ma = 0;
    private static int mb = 0;
    private static String mc = null;
    private static e.a md = null;
    private static e.a mf = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int mg = 0;
    public static boolean mh = false;
    public static boolean mi = false;
    public static boolean mj = false;

    public static void y(int i) {
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
        md = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a bV() {
        return mf;
    }

    public static double e(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
