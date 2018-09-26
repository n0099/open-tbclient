package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String uO = null;
    private static String uP = null;
    private static int uQ = 0;
    private static int uR = 0;
    private static String uS = null;
    private static e.a uT = null;
    private static e.a uU = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int uV = 0;
    public static boolean uW = false;
    public static boolean uX = false;
    public static boolean uY = false;

    public static void a(e.a aVar) {
        uT = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a fQ() {
        return uU;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
