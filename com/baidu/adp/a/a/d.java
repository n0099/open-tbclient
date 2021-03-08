package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String JL = null;
    private static String JM = null;
    private static int JN = 0;
    private static int JO = 0;
    private static String JP = null;
    private static e.a JQ = null;
    private static e.a JR = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int JS = 0;
    public static boolean JT = false;
    public static boolean JU = false;
    public static boolean JV = false;

    public static void a(e.a aVar) {
        JQ = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a kG() {
        return JR;
    }

    public static double g(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
