package com.baidu.ar.speech;

import android.util.Log;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class SpeechDataFactory {
    private static final String a = SpeechDataFactory.class.getSimpleName();
    private static InputStream b;

    public static InputStream create8kInputStream() {
        Log.e(a, " create8kInputStream ");
        if (b == null) {
            Log.e(a, " create8kInputStream mAudioInputStream is null !!!");
        }
        return b;
    }

    public static void release() {
        b = null;
    }

    public static void setAudioInputStream(InputStream inputStream) {
        Log.e(a, " setAudioInputStream ");
        b = inputStream;
    }
}
