package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c JR;
    private static String JS;
    private static com.baidu.adp.lib.voice.k JT;
    private static int JQ = 0;
    private static long JU = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - JU < 1000) {
            return false;
        }
        JU = System.currentTimeMillis();
        if (JQ == 0) {
            if (JR == null) {
                JR = new c(mHandler);
            }
            JS = str;
            JT = kVar;
            if (JR.k(str, i)) {
                JQ = 3;
                new Thread(JR).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (JR != null) {
            JR.stop();
        }
        JQ = 0;
    }

    public static void cancel() {
        if (JR != null) {
            JR.cancel();
        }
        JQ = 0;
    }
}
