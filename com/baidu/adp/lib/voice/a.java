package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c oa;
    private static j ob;
    private static int nZ = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, j jVar, int i) {
        if (nZ == 0) {
            if (oa == null) {
                oa = new c(mHandler, i);
            } else {
                oa.ad(i);
            }
            mFileName = str;
            ob = jVar;
            oa.aL(str);
            nZ = 2;
            new Thread(oa).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (oa != null) {
            oa.stop();
        } else {
            nZ = 0;
        }
    }
}
