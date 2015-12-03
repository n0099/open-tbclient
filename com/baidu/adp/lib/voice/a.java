package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static c zb;
    private static f zc;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new b());

    public static boolean a(String str, f fVar, int i) {
        if (mPlayingState == 0) {
            if (zb == null) {
                zb = new c(mHandler, i);
            } else {
                zb.ai(i);
            }
            mFileName = str;
            zc = fVar;
            zb.aZ(str);
            mPlayingState = 2;
            new Thread(zb).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zb != null) {
            zb.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
