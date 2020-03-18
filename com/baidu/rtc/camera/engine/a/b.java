package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes6.dex */
public final class b {
    private static final b aWT = new b();
    public boolean aWI;
    public AspectRatio aWJ;
    public float aWK;
    public int aWL;
    public int aWM;
    public int aWN;
    public int aWO;
    public boolean aWP;
    public boolean aWQ;
    public com.baidu.rtc.camera.engine.b.a aWR;
    public com.baidu.rtc.camera.engine.b.b aWS;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.aWI = false;
        this.aWJ = AspectRatio.Ratio_16_9;
        this.aWK = 0.5625f;
        this.aWL = 30;
        this.aWM = 0;
        this.aWN = 1280;
        this.aWO = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.aWP = false;
        this.cameraId = 1;
        this.aWQ = false;
        this.aWR = null;
        this.aWS = null;
    }

    public static b Fs() {
        return aWT;
    }

    public void bP(boolean z) {
        this.aWP = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
