package com.baidu.rtc;

import android.util.Log;
/* loaded from: classes2.dex */
public class RTCOpglesRender {
    public static final String TAG = "RTCOpglesRender";

    static {
        System.loadLibrary("rtc_gl_render");
    }

    public void destroyRender() {
    }

    public void drawFrame(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3) {
    }

    public void pauseRender() {
    }

    public void resumeRender() {
    }

    public void setupRender() {
        Log.d(TAG, "testing " + stringFromJNI());
    }

    public native String stringFromJNI();
}
