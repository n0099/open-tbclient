package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes6.dex */
public final class b {
    private static final b aWF = new b();
    public int aWA;
    public boolean aWB;
    public boolean aWC;
    public com.baidu.rtc.camera.engine.b.a aWD;
    public com.baidu.rtc.camera.engine.b.b aWE;
    public boolean aWu;
    public AspectRatio aWv;
    public float aWw;
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
        this.aWu = false;
        this.aWv = AspectRatio.Ratio_16_9;
        this.aWw = 0.5625f;
        this.aWx = 30;
        this.aWy = 0;
        this.aWz = 1280;
        this.aWA = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.aWB = false;
        this.cameraId = 1;
        this.aWC = false;
        this.aWD = null;
        this.aWE = null;
    }

    public static b Fn() {
        return aWF;
    }

    public void bO(boolean z) {
        this.aWB = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
