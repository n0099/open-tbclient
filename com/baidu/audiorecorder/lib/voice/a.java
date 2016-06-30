package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c Bj;
    private static String Bk;
    private static com.baidu.adp.lib.voice.k Bl;
    private static int Bi = 0;
    private static long Bm = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Bm < 1000) {
            return false;
        }
        Bm = System.currentTimeMillis();
        if (Bi == 0) {
            if (Bj == null) {
                Bj = new c(mHandler);
            }
            Bk = str;
            Bl = kVar;
            if (Bj.o(str, i)) {
                Bi = 3;
                new Thread(Bj).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Bj != null) {
            Bj.stop();
        }
        Bi = 0;
    }

    public static void cancel() {
        if (Bj != null) {
            Bj.cancel();
        }
        Bi = 0;
    }
}
