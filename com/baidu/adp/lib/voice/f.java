package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class f {
    private static h om;
    private static String oo;
    private static p oq;
    private static int ol = 0;
    private static long or = 0;
    private static Handler mHandler = new Handler(new g());

    public static boolean a(String str, int i, p pVar) {
        if (System.currentTimeMillis() - or < 1000) {
            return false;
        }
        or = System.currentTimeMillis();
        if (ol == 0) {
            if (om == null) {
                om = new h(mHandler);
            }
            oo = str;
            oq = pVar;
            if (om.i(str, i)) {
                ol = 3;
                new Thread(om).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (om != null) {
            om.stop();
        }
        ol = 0;
    }

    public static void cancel() {
        if (om != null) {
            om.cancel();
        }
        ol = 0;
    }
}
