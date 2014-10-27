package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c nU;
    private static j nV;
    private static int nT = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, j jVar, int i) {
        if (nT == 0) {
            if (nU == null) {
                nU = new c(mHandler, i);
            } else {
                nU.Q(i);
            }
            mFileName = str;
            nV = jVar;
            nU.aJ(str);
            nT = 2;
            new Thread(nU).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (nU != null) {
            nU.stop();
        } else {
            nT = 0;
        }
    }
}
