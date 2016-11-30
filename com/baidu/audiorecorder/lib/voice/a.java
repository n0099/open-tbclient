package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c DY;
    private static String DZ;
    private static com.baidu.adp.lib.voice.k Ea;
    private static int DX = 0;
    private static long Eb = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Eb < 1000) {
            return false;
        }
        Eb = System.currentTimeMillis();
        if (DX == 0) {
            if (DY == null) {
                DY = new c(mHandler);
            }
            DZ = str;
            Ea = kVar;
            if (DY.o(str, i)) {
                DX = 3;
                new Thread(DY).start();
                return true;
            }
            DY = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (DY != null) {
            DY.stop();
        }
        DX = 0;
    }

    public static void cancel() {
        if (DY != null) {
            DY.cancel();
        }
        DX = 0;
    }
}
