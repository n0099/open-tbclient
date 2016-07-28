package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c BJ;
    private static String BK;
    private static com.baidu.adp.lib.voice.k BL;
    private static int BI = 0;
    private static long BM = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - BM < 1000) {
            return false;
        }
        BM = System.currentTimeMillis();
        if (BI == 0) {
            if (BJ == null) {
                BJ = new c(mHandler);
            }
            BK = str;
            BL = kVar;
            if (BJ.o(str, i)) {
                BI = 3;
                new Thread(BJ).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (BJ != null) {
            BJ.stop();
        }
        BI = 0;
    }

    public static void cancel() {
        if (BJ != null) {
            BJ.cancel();
        }
        BI = 0;
    }
}
