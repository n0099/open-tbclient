package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c pQ;
    private static f pR;
    private static int pP = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (pP == 0) {
            if (pQ == null) {
                pQ = new c(mHandler, i);
            } else {
                pQ.ag(i);
            }
            mFileName = str;
            pR = fVar;
            pQ.aU(str);
            pP = 2;
            new Thread(pQ).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (pQ != null) {
            pQ.stop();
        } else {
            pP = 0;
        }
    }
}
