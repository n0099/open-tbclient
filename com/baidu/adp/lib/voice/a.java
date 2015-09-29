package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c yV;
    private static f yW;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (mPlayingState == 0) {
            if (yV == null) {
                yV = new c(mHandler, i);
            } else {
                yV.ah(i);
            }
            mFileName = str;
            yW = fVar;
            yV.aX(str);
            mPlayingState = 2;
            new Thread(yV).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (yV != null) {
            yV.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
