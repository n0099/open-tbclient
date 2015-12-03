package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c Kg;
    private static String Kh;
    private static com.baidu.adp.lib.voice.k Ki;
    private static int Kf = 0;
    private static long Kj = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Kj < 1000) {
            return false;
        }
        Kj = System.currentTimeMillis();
        if (Kf == 0) {
            if (Kg == null) {
                Kg = new c(mHandler);
            }
            Kh = str;
            Ki = kVar;
            if (Kg.m(str, i)) {
                Kf = 3;
                new Thread(Kg).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Kg != null) {
            Kg.stop();
        }
        Kf = 0;
    }

    public static void cancel() {
        if (Kg != null) {
            Kg.cancel();
        }
        Kf = 0;
    }
}
