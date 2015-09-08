package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c yU;
    private static f yV;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (mPlayingState == 0) {
            if (yU == null) {
                yU = new c(mHandler, i);
            } else {
                yU.ah(i);
            }
            mFileName = str;
            yV = fVar;
            yU.aW(str);
            mPlayingState = 2;
            new Thread(yU).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (yU != null) {
            yU.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
