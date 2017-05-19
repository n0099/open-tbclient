package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String nK = null;
    private static String nL = null;
    private static int nM = 0;
    private static int nN = 0;
    private static String nO = null;
    private static e.a nP = null;
    private static e.a nQ = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int nR = 0;
    public static boolean nS = false;
    public static boolean nT = false;
    public static boolean nU = false;

    public static void F(int i) {
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
        nP = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a cm() {
        return nQ;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
