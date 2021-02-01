package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String Io = null;
    private static String Ip = null;
    private static int Iq = 0;
    private static int Ir = 0;
    private static String Is = null;
    private static e.a It = null;
    private static e.a Iu = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int Iv = 0;
    public static boolean Iw = false;
    public static boolean Ix = false;
    public static boolean Iy = false;

    public static void a(e.a aVar) {
        It = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a kG() {
        return Iu;
    }

    public static double g(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
