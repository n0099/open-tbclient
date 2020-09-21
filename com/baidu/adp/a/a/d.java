package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String HG = null;
    private static String HH = null;
    private static int HI = 0;
    private static int HJ = 0;
    private static String HK = null;
    private static e.a HL = null;
    private static e.a HM = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int HN = 0;
    public static boolean HO = false;
    public static boolean HP = false;
    public static boolean HQ = false;

    public static void a(e.a aVar) {
        HL = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a lk() {
        return HM;
    }

    public static double g(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
