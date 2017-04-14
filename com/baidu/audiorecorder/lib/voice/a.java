package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c JZ;
    private static String Ka;
    private static com.baidu.adp.lib.voice.k Kb;
    private static int JY = 0;
    private static long Kc = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Kc < 1000) {
            return false;
        }
        Kc = System.currentTimeMillis();
        if (JY == 0) {
            if (JZ == null) {
                JZ = new c(mHandler);
            }
            Ka = str;
            Kb = kVar;
            if (JZ.o(str, i)) {
                JY = 3;
                new Thread(JZ).start();
                return true;
            }
            JZ = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (JZ != null) {
            JZ.stop();
        }
        JY = 0;
    }

    public static void cancel() {
        if (JZ != null) {
            JZ.cancel();
        }
        JY = 0;
    }
}
