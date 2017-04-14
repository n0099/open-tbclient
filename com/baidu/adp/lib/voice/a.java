package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zt;
    private static f zu;
    private static int zs = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (zs == 0) {
            if (zt == null) {
                zt = new c(mHandler, i);
            } else {
                zt.aw(i);
            }
            mFileName = str;
            zu = fVar;
            zt.aK(str);
            zs = 2;
            new Thread(zt).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zt != null) {
            zt.stop();
        } else {
            zs = 0;
        }
    }
}
