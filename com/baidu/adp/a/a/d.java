package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String ol = null;
    private static String om = null;
    private static int oo = 0;
    private static int oq = 0;
    private static String or = null;
    private static e.a ot = null;
    private static e.a ou = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int ov = 0;
    public static boolean ow = false;
    public static boolean ox = false;
    public static boolean oy = false;

    public static void H(int i) {
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
        ot = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a cn() {
        return ou;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
