package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes6.dex */
public final class b {
    private static final b aWE = new b();
    public boolean aWA;
    public boolean aWB;
    public com.baidu.rtc.camera.engine.b.a aWC;
    public com.baidu.rtc.camera.engine.b.b aWD;
    public boolean aWt;
    public AspectRatio aWu;
    public float aWv;
    public int aWw;
    public int aWx;
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
        this.aWt = false;
        this.aWu = AspectRatio.Ratio_16_9;
        this.aWv = 0.5625f;
        this.aWw = 30;
        this.aWx = 0;
        this.aWy = 1280;
        this.aWz = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.aWA = false;
        this.cameraId = 1;
        this.aWB = false;
        this.aWC = null;
        this.aWD = null;
    }

    public static b Fl() {
        return aWE;
    }

    public void bO(boolean z) {
        this.aWA = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
