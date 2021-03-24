package com.baidu.platform.comjni.jninative.tts;

import com.baidu.platform.comapi.wnplatform.m.b;
/* loaded from: classes2.dex */
public class WNaviTTSPlayer {
    public static boolean bStopVoiceOutput = false;
    public static b mTtsPlayerListener;

    public static int getTTSState() {
        b bVar = mTtsPlayerListener;
        if (bVar == null) {
            return 0;
        }
        return bVar.a();
    }

    public static void pauseVoiceTTSOutput() {
        bStopVoiceOutput = true;
    }

    public static int playTTSText(String str, int i, int i2) {
        b bVar = mTtsPlayerListener;
        if (bVar == null || bStopVoiceOutput) {
            return 0;
        }
        return bVar.a(str, i, i2);
    }

    public static void resumeVoiceTTSOutput() {
        bStopVoiceOutput = false;
    }

    public static void setTTSPlayerListener(b bVar) {
        mTtsPlayerListener = bVar;
    }
}
