package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zx;
    private static f zy;
    private static int zw = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (zw == 0) {
            if (zx == null) {
                zx = new c(mHandler, i);
            } else {
                zx.av(i);
            }
            mFileName = str;
            zy = fVar;
            zx.aK(str);
            zw = 2;
            new Thread(zx).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zx != null) {
            zx.stop();
        } else {
            zw = 0;
        }
    }
}
