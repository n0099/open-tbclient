package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c qs;
    private static f qt;
    private static int qr = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (qr == 0) {
            if (qs == null) {
                qs = new c(mHandler, i);
            } else {
                qs.aj(i);
            }
            mFileName = str;
            qt = fVar;
            qs.aV(str);
            qr = 2;
            new Thread(qs).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (qs != null) {
            qs.stop();
        } else {
            qr = 0;
        }
    }
}
