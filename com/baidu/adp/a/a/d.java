package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String kJ = null;
    private static String kK = null;
    private static int kL = 0;
    private static int kM = 0;
    private static String kN = null;
    private static e.a kO = null;
    private static e.a kP = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int kQ = 0;
    public static boolean kR = false;
    public static boolean kS = false;
    public static boolean kT = false;

    public static void a(e.a aVar) {
        kO = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a er() {
        return kP;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
