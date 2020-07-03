package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes6.dex */
public final class b {
    private static final b bHK = new b();
    public AspectRatio bHA;
    public float bHB;
    public int bHC;
    public int bHD;
    public int bHE;
    public int bHF;
    public boolean bHG;
    public boolean bHH;
    public com.baidu.rtc.camera.engine.b.a bHI;
    public com.baidu.rtc.camera.engine.b.b bHJ;
    public boolean bHz;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.bHz = false;
        this.bHA = AspectRatio.Ratio_16_9;
        this.bHB = 0.5625f;
        this.bHC = 30;
        this.bHD = 0;
        this.bHE = 1280;
        this.bHF = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.bHG = false;
        this.cameraId = 1;
        this.bHH = false;
        this.bHI = null;
        this.bHJ = null;
    }

    public static b Qw() {
        return bHK;
    }

    public void de(boolean z) {
        this.bHG = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
