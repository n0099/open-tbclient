package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c Kw;
    private static String Kx;
    private static com.baidu.adp.lib.voice.k Ky;
    private static int Kv = 0;
    private static long Kz = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Kz < 1000) {
            return false;
        }
        Kz = System.currentTimeMillis();
        if (Kv == 0) {
            if (Kw == null) {
                Kw = new c(mHandler);
            }
            Kx = str;
            Ky = kVar;
            if (Kw.m(str, i)) {
                Kv = 3;
                new Thread(Kw).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Kw != null) {
            Kw.stop();
        }
        Kv = 0;
    }

    public static void cancel() {
        if (Kw != null) {
            Kw.cancel();
        }
        Kv = 0;
    }
}
