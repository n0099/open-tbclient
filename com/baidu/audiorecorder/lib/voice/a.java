package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c Bi;
    private static String Bj;
    private static com.baidu.adp.lib.voice.k Bk;
    private static int Bh = 0;
    private static long Bl = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Bl < 1000) {
            return false;
        }
        Bl = System.currentTimeMillis();
        if (Bh == 0) {
            if (Bi == null) {
                Bi = new c(mHandler);
            }
            Bj = str;
            Bk = kVar;
            if (Bi.o(str, i)) {
                Bh = 3;
                new Thread(Bi).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Bi != null) {
            Bi.stop();
        }
        Bh = 0;
    }

    public static void cancel() {
        if (Bi != null) {
            Bi.cancel();
        }
        Bh = 0;
    }
}
