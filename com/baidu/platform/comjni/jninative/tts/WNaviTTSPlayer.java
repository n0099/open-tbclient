package com.baidu.platform.comjni.jninative.tts;

import com.baidu.platform.comapi.wnplatform.m.b;
/* loaded from: classes5.dex */
public class WNaviTTSPlayer {
    private static b mTtsPlayerListener = null;
    private static boolean bStopVoiceOutput = false;

    public static int getTTSState() {
        if (mTtsPlayerListener == null) {
            return 0;
        }
        return mTtsPlayerListener.a();
    }

    public static void setTTSPlayerListener(b bVar) {
        mTtsPlayerListener = bVar;
    }

    public static int playTTSText(String str, int i, int i2) {
        if (mTtsPlayerListener == null || bStopVoiceOutput) {
            return 0;
        }
        return mTtsPlayerListener.a(str, i, i2);
    }

    public static void pauseVoiceTTSOutput() {
        bStopVoiceOutput = true;
    }

    public static void resumeVoiceTTSOutput() {
        bStopVoiceOutput = false;
    }
}
