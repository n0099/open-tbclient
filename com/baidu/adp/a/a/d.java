package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String abR = null;
    private static String abS = null;
    private static int abT = 0;
    private static int abU = 0;
    private static String abV = null;
    private static e.a abW = null;
    private static e.a abX = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int abY = 0;
    public static boolean abZ = false;
    public static boolean aca = false;
    public static boolean acb = false;

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
        abW = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a jR() {
        return abX;
    }

    public static double d(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
