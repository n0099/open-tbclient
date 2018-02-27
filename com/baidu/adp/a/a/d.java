package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String abL = null;
    private static String abM = null;
    private static int abN = 0;
    private static int abO = 0;
    private static String abP = null;
    private static e.a abQ = null;
    private static e.a abR = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int abS = 0;
    public static boolean abT = false;
    public static boolean abU = false;
    public static boolean abV = false;

    public static void cy(int i) {
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
        abQ = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a jR() {
        return abR;
    }

    public static double d(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
