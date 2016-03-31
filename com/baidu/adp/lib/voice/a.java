package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zD;
    private static f zE;
    private static int zC = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (zC == 0) {
            if (zD == null) {
                zD = new c(mHandler, i);
            } else {
                zD.as(i);
            }
            mFileName = str;
            zE = fVar;
            zD.bb(str);
            zC = 2;
            new Thread(zD).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zD != null) {
            zD.stop();
        } else {
            zC = 0;
        }
    }
}
