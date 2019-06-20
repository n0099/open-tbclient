package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String tc = null;
    private static String td = null;
    private static int te = 0;
    private static int tf = 0;
    private static String tg = null;
    private static e.a th = null;
    private static e.a ti = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int tj = 0;
    public static boolean tk = false;
    public static boolean tl = false;
    public static boolean tm = false;

    public static void a(e.a aVar) {
        th = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a eY() {
        return ti;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
