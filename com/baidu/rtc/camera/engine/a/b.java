package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes4.dex */
public final class b {
    private static final b aRn = new b();
    public boolean aRc;
    public AspectRatio aRd;
    public float aRe;
    public int aRf;
    public int aRg;
    public int aRh;
    public int aRi;
    public boolean aRj;
    public boolean aRk;
    public com.baidu.rtc.camera.engine.b.a aRl;
    public com.baidu.rtc.camera.engine.b.b aRm;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.aRc = false;
        this.aRd = AspectRatio.Ratio_16_9;
        this.aRe = 0.5625f;
        this.aRf = 30;
        this.aRg = 0;
        this.aRh = 1280;
        this.aRi = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.aRj = false;
        this.cameraId = 1;
        this.aRk = false;
        this.aRl = null;
        this.aRm = null;
    }

    public static b Ct() {
        return aRn;
    }

    public void bB(boolean z) {
        this.aRj = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
