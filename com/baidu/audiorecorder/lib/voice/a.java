package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static c DW;
    private static String DX;
    private static com.baidu.adp.lib.voice.k DY;
    private static int DV = 0;
    private static long DZ = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.k kVar) {
        if (System.currentTimeMillis() - DZ < 1000) {
            return false;
        }
        DZ = System.currentTimeMillis();
        if (DV == 0) {
            if (DW == null) {
                DW = new c(mHandler);
            }
            DX = str;
            DY = kVar;
            if (DW.o(str, i)) {
                DV = 3;
                new Thread(DW).start();
                return true;
            }
            DW = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (DW != null) {
            DW.stop();
        }
        DV = 0;
    }

    public static void cancel() {
        if (DW != null) {
            DW.cancel();
        }
        DV = 0;
    }
}
