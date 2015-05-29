package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zm;
    private static f zn;
    private static int zl = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (zl == 0) {
            if (zm == null) {
                zm = new c(mHandler, i);
            } else {
                zm.af(i);
            }
            mFileName = str;
            zn = fVar;
            zm.bd(str);
            zl = 2;
            new Thread(zm).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zm != null) {
            zm.stop();
        } else {
            zl = 0;
        }
    }
}
