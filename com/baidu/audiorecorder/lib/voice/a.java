package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static com.baidu.adp.lib.voice.k KA;
    private static c Ky;
    private static String Kz;
    private static int Kx = 0;
    private static long KB = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - KB < 1000) {
            return false;
        }
        KB = System.currentTimeMillis();
        if (Kx == 0) {
            if (Ky == null) {
                Ky = new c(mHandler);
            }
            Kz = str;
            KA = kVar;
            if (Ky.o(str, i)) {
                Kx = 3;
                new Thread(Ky).start();
                return true;
            }
            Ky = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Ky != null) {
            Ky.stop();
        }
        Kx = 0;
    }

    public static void cancel() {
        if (Ky != null) {
            Ky.cancel();
        }
        Kx = 0;
    }
}
