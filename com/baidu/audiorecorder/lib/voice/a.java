package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c Dj;
    private static String Dk;
    private static com.baidu.adp.lib.voice.k Dl;
    private static int Di = 0;
    private static long Dm = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Dm < 1000) {
            return false;
        }
        Dm = System.currentTimeMillis();
        if (Di == 0) {
            if (Dj == null) {
                Dj = new c(mHandler);
            }
            Dk = str;
            Dl = kVar;
            if (Dj.o(str, i)) {
                Di = 3;
                new Thread(Dj).start();
                return true;
            }
            Dj = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Dj != null) {
            Dj.stop();
        }
        Di = 0;
    }

    public static void cancel() {
        if (Dj != null) {
            Dj.cancel();
        }
        Di = 0;
    }
}
