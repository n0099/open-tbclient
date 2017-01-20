package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c sB;
    private static f sC;
    private static int sA = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (sA == 0) {
            if (sB == null) {
                sB = new c(mHandler, i);
            } else {
                sB.ax(i);
            }
            mFileName = str;
            sC = fVar;
            sB.aV(str);
            sA = 2;
            new Thread(sB).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (sB != null) {
            sB.stop();
        } else {
            sA = 0;
        }
    }
}
