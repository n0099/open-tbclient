package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zd;
    private static f ze;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (mPlayingState == 0) {
            if (zd == null) {
                zd = new c(mHandler, i);
            } else {
                zd.ai(i);
            }
            mFileName = str;
            ze = fVar;
            zd.aZ(str);
            mPlayingState = 2;
            new Thread(zd).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zd != null) {
            zd.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
