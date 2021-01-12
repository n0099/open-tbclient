package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String Ip = null;
    private static String Iq = null;
    private static int Ir = 0;
    private static int Is = 0;
    private static String It = null;
    private static e.a Iu = null;
    private static e.a Iv = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int Iw = 0;
    public static boolean Ix = false;
    public static boolean Iy = false;
    public static boolean Iz = false;

    public static void a(e.a aVar) {
        Iu = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a kH() {
        return Iv;
    }

    public static double g(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
