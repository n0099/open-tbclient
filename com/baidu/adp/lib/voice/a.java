package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c nV;
    private static j nW;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, j jVar, int i) {
        if (mPlayingState == 0) {
            if (nV == null) {
                nV = new c(mHandler, i);
            } else {
                nV.Y(i);
            }
            mFileName = str;
            nW = jVar;
            nV.aL(str);
            mPlayingState = 2;
            new Thread(nV).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (nV != null) {
            nV.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
