package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes2.dex */
public class a {
    private static c Jg;
    private static String Jh;
    private static com.baidu.adp.lib.voice.k Ji;
    private static int Jf = 0;
    private static long Jj = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Jj < 1000) {
            return false;
        }
        Jj = System.currentTimeMillis();
        if (Jf == 0) {
            if (Jg == null) {
                Jg = new c(mHandler);
            }
            Jh = str;
            Ji = kVar;
            if (Jg.o(str, i)) {
                Jf = 3;
                new Thread(Jg).start();
                return true;
            }
            Jg = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Jg != null) {
            Jg.stop();
        }
        Jf = 0;
    }

    public static void cancel() {
        if (Jg != null) {
            Jg.cancel();
        }
        Jf = 0;
    }
}
