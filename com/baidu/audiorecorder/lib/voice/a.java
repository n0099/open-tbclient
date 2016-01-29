package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c KL;
    private static String KM;
    private static com.baidu.adp.lib.voice.k KN;
    private static int KK = 0;
    private static long KO = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - KO < 1000) {
            return false;
        }
        KO = System.currentTimeMillis();
        if (KK == 0) {
            if (KL == null) {
                KL = new c(mHandler);
            }
            KM = str;
            KN = kVar;
            if (KL.n(str, i)) {
                KK = 3;
                new Thread(KL).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (KL != null) {
            KL.stop();
        }
        KK = 0;
    }

    public static void cancel() {
        if (KL != null) {
            KL.cancel();
        }
        KK = 0;
    }
}
