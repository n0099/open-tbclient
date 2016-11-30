package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c sJ;
    private static f sK;
    private static int sI = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (sI == 0) {
            if (sJ == null) {
                sJ = new c(mHandler, i);
            } else {
                sJ.aw(i);
            }
            mFileName = str;
            sK = fVar;
            sJ.aW(str);
            sI = 2;
            new Thread(sJ).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (sJ != null) {
            sJ.stop();
        } else {
            sI = 0;
        }
    }
}
