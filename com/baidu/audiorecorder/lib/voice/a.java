package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c KR;
    private static String KS;
    private static com.baidu.adp.lib.voice.k KT;
    private static int KQ = 0;
    private static long KU = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - KU < 1000) {
            return false;
        }
        KU = System.currentTimeMillis();
        if (KQ == 0) {
            if (KR == null) {
                KR = new c(mHandler);
            }
            KS = str;
            KT = kVar;
            if (KR.n(str, i)) {
                KQ = 3;
                new Thread(KR).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (KR != null) {
            KR.stop();
        }
        KQ = 0;
    }

    public static void cancel() {
        if (KR != null) {
            KR.cancel();
        }
        KQ = 0;
    }
}
