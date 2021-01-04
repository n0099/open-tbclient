package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String Ir = null;
    private static String Is = null;
    private static int It = 0;
    private static int Iu = 0;
    private static String Iv = null;
    private static e.a Iw = null;
    private static e.a Ix = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int Iy = 0;
    public static boolean Iz = false;
    public static boolean IB = false;
    public static boolean IC = false;

    public static void a(e.a aVar) {
        Iw = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a kH() {
        return Ix;
    }

    public static double g(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
