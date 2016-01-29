package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zl;
    private static f zm;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (mPlayingState == 0) {
            if (zl == null) {
                zl = new c(mHandler, i);
            } else {
                zl.at(i);
            }
            mFileName = str;
            zm = fVar;
            zl.aY(str);
            mPlayingState = 2;
            new Thread(zl).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zl != null) {
            zl.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
