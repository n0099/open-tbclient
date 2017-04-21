package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c Kb;
    private static String Kc;
    private static com.baidu.adp.lib.voice.k Kd;
    private static int Ka = 0;
    private static long Ke = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Ke < 1000) {
            return false;
        }
        Ke = System.currentTimeMillis();
        if (Ka == 0) {
            if (Kb == null) {
                Kb = new c(mHandler);
            }
            Kc = str;
            Kd = kVar;
            if (Kb.o(str, i)) {
                Ka = 3;
                new Thread(Kb).start();
                return true;
            }
            Kb = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Kb != null) {
            Kb.stop();
        }
        Ka = 0;
    }

    public static void cancel() {
        if (Kb != null) {
            Kb.cancel();
        }
        Ka = 0;
    }
}
