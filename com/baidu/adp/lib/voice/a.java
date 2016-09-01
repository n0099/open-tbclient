package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c sI;
    private static f sJ;
    private static int sH = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (sH == 0) {
            if (sI == null) {
                sI = new c(mHandler, i);
            } else {
                sI.aw(i);
            }
            mFileName = str;
            sJ = fVar;
            sI.aW(str);
            sH = 2;
            new Thread(sI).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (sI != null) {
            sI.stop();
        } else {
            sH = 0;
        }
    }
}
