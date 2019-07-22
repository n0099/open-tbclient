package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String tf = null;
    private static String tg = null;
    private static int th = 0;
    private static int ti = 0;
    private static String tj = null;
    private static e.a tk = null;
    private static e.a tl = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int tm = 0;
    public static boolean tp = false;
    public static boolean tq = false;
    public static boolean tr = false;

    public static void a(e.a aVar) {
        tk = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a ff() {
        return tl;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
