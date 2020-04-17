package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int mFps = 0;
    private static String Gm = null;
    private static String Gn = null;
    private static int Go = 0;
    private static int Gp = 0;
    private static String Gq = null;
    private static e.a Gr = null;
    private static e.a Gs = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int Gt = 0;
    public static boolean Gu = false;
    public static boolean Gv = false;
    public static boolean Gw = false;

    public static void a(e.a aVar) {
        Gr = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a jr() {
        return Gs;
    }

    public static double g(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
