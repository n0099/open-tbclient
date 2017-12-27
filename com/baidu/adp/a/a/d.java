package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String abT = null;
    private static String abU = null;
    private static int abV = 0;
    private static int abW = 0;
    private static String abX = null;
    private static e.a abY = null;
    private static e.a abZ = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int aca = 0;
    public static boolean acb = false;
    public static boolean acc = false;
    public static boolean acd = false;

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
        abY = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a jR() {
        return abZ;
    }

    public static double d(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
