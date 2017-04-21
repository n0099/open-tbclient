package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zw;
    private static f zx;
    private static int zv = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (zv == 0) {
            if (zw == null) {
                zw = new c(mHandler, i);
            } else {
                zw.aw(i);
            }
            mFileName = str;
            zx = fVar;
            zw.aK(str);
            zv = 2;
            new Thread(zw).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zw != null) {
            zw.stop();
        } else {
            zv = 0;
        }
    }
}
