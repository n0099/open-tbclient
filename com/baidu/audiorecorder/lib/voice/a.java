package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c JK;
    private static String JL;
    private static com.baidu.adp.lib.voice.k JM;
    private static int JJ = 0;
    private static long JN = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - JN < 1000) {
            return false;
        }
        JN = System.currentTimeMillis();
        if (JJ == 0) {
            if (JK == null) {
                JK = new c(mHandler);
            }
            JL = str;
            JM = kVar;
            if (JK.k(str, i)) {
                JJ = 3;
                new Thread(JK).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (JK != null) {
            JK.stop();
        }
        JJ = 0;
    }

    public static void cancel() {
        if (JK != null) {
            JK.cancel();
        }
        JJ = 0;
    }
}
