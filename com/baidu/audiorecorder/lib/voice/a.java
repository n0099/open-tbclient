package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes2.dex */
public class a {
    private static c Jt;
    private static String Ju;
    private static com.baidu.adp.lib.voice.k Jv;
    private static int Js = 0;
    private static long Jw = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - Jw < 1000) {
            return false;
        }
        Jw = System.currentTimeMillis();
        if (Js == 0) {
            if (Jt == null) {
                Jt = new c(mHandler);
            }
            Ju = str;
            Jv = kVar;
            if (Jt.o(str, i)) {
                Js = 3;
                new Thread(Jt).start();
                return true;
            }
            Jt = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Jt != null) {
            Jt.stop();
        }
        Js = 0;
    }

    public static void cancel() {
        if (Jt != null) {
            Jt.cancel();
        }
        Js = 0;
    }
}
