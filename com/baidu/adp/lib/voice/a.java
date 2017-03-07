package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zS;
    private static f zT;
    private static int zR = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (zR == 0) {
            if (zS == null) {
                zS = new c(mHandler, i);
            } else {
                zS.ax(i);
            }
            mFileName = str;
            zT = fVar;
            zS.aP(str);
            zR = 2;
            new Thread(zS).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zS != null) {
            zS.stop();
        } else {
            zR = 0;
        }
    }
}
