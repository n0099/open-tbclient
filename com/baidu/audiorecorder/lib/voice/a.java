package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c JT;
    private static String JU;
    private static com.baidu.adp.lib.voice.k JV;
    private static int JS = 0;
    private static long JW = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - JW < 1000) {
            return false;
        }
        JW = System.currentTimeMillis();
        if (JS == 0) {
            if (JT == null) {
                JT = new c(mHandler);
            }
            JU = str;
            JV = kVar;
            if (JT.k(str, i)) {
                JS = 3;
                new Thread(JT).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (JT != null) {
            JT.stop();
        }
        JS = 0;
    }

    public static void cancel() {
        if (JT != null) {
            JT.cancel();
        }
        JS = 0;
    }
}
