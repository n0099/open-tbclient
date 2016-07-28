package com.baidu.adp.a.a;

import android.os.Handler;
import com.baidu.adp.a.a.e;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class d {
    private static int eh = 0;
    private static String ei = null;
    private static String ej = null;
    private static int ek = 0;
    private static int el = 0;
    private static String em = null;
    private static e.a en = null;
    private static e.a eo = null;
    public static Handler mHandler = null;
    @Deprecated
    public static int ep = 0;
    public static boolean eq = false;
    public static boolean er = false;
    public static boolean es = false;

    public static void t(int i) {
        eh = i;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(e.a aVar) {
        en = aVar;
        try {
            if (mHandler != null) {
                mHandler.sendEmptyMessage(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static e.a aj() {
        return eo;
    }

    public static double a(double d) {
        return new BigDecimal(d).setScale(2, 4).doubleValue();
    }
}
