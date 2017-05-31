package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes2.dex */
public class a {
    private static c Jh;
    private static String Ji;
    private static com.baidu.adp.lib.voice.k Jj;
    private static int Jg = 0;
    private static long Jk = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Jk < 1000) {
            return false;
        }
        Jk = System.currentTimeMillis();
        if (Jg == 0) {
            if (Jh == null) {
                Jh = new c(mHandler);
            }
            Ji = str;
            Jj = kVar;
            if (Jh.o(str, i)) {
                Jg = 3;
                new Thread(Jh).start();
                return true;
            }
            Jh = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Jh != null) {
            Jh.stop();
        }
        Jg = 0;
    }

    public static void cancel() {
        if (Jh != null) {
            Jh.cancel();
        }
        Jg = 0;
    }
}
