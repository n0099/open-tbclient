package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c yW;
    private static f yX;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (mPlayingState == 0) {
            if (yW == null) {
                yW = new c(mHandler, i);
            } else {
                yW.ah(i);
            }
            mFileName = str;
            yX = fVar;
            yW.aW(str);
            mPlayingState = 2;
            new Thread(yW).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (yW != null) {
            yW.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
