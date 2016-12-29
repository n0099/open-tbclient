package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c DZ;
    private static String Ea;
    private static com.baidu.adp.lib.voice.k Eb;
    private static int DY = 0;
    private static long Ec = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Ec < 1000) {
            return false;
        }
        Ec = System.currentTimeMillis();
        if (DY == 0) {
            if (DZ == null) {
                DZ = new c(mHandler);
            }
            Ea = str;
            Eb = kVar;
            if (DZ.o(str, i)) {
                DY = 3;
                new Thread(DZ).start();
                return true;
            }
            DZ = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (DZ != null) {
            DZ.stop();
        }
        DY = 0;
    }

    public static void cancel() {
        if (DZ != null) {
            DZ.cancel();
        }
        DY = 0;
    }
}
