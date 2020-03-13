package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes6.dex */
public final class b {
    private static final b aWG = new b();
    public int aWA;
    public int aWB;
    public boolean aWC;
    public boolean aWD;
    public com.baidu.rtc.camera.engine.b.a aWE;
    public com.baidu.rtc.camera.engine.b.b aWF;
    public boolean aWv;
    public AspectRatio aWw;
    public float aWx;
    public int aWy;
    public int aWz;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.aWv = false;
        this.aWw = AspectRatio.Ratio_16_9;
        this.aWx = 0.5625f;
        this.aWy = 30;
        this.aWz = 0;
        this.aWA = 1280;
        this.aWB = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.aWC = false;
        this.cameraId = 1;
        this.aWD = false;
        this.aWE = null;
        this.aWF = null;
    }

    public static b Fn() {
        return aWG;
    }

    public void bO(boolean z) {
        this.aWC = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
