package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String td = null;
    private static String te = null;
    private static int tf = 0;
    private static int tg = 0;
    private static String th = null;
    private static e.a ti = null;
    private static e.a tj = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int tk = 0;
    public static boolean tl = false;
    public static boolean tm = false;
    public static boolean tp = false;

    public static void a(e.a aVar) {
        ti = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a eY() {
        return tj;
    }

    public static double c(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
