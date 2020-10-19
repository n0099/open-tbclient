package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String HX = null;
    private static String HY = null;
    private static int HZ = 0;
    private static int Ia = 0;
    private static String Ib = null;
    private static e.a Ic = null;
    private static e.a Id = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int Ie = 0;
    public static boolean If = false;
    public static boolean Ig = false;
    public static boolean Ih = false;

    public static void a(e.a aVar) {
        Ic = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a ll() {
        return Id;
    }

    public static double g(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
