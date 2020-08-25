package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String Hy = null;
    private static String Hz = null;
    private static int HA = 0;
    private static int HB = 0;
    private static String HC = null;
    private static e.a HD = null;
    private static e.a HE = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int HF = 0;
    public static boolean HG = false;
    public static boolean HH = false;
    public static boolean HI = false;

    public static void a(e.a aVar) {
        HD = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a lg() {
        return HE;
    }

    public static double g(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
