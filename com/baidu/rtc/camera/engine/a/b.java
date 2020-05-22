package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes6.dex */
public final class b {
    private static final b bCW = new b();
    public boolean bCL;
    public AspectRatio bCM;
    public float bCN;
    public int bCO;
    public int bCP;
    public int bCQ;
    public int bCR;
    public boolean bCS;
    public boolean bCT;
    public com.baidu.rtc.camera.engine.b.a bCU;
    public com.baidu.rtc.camera.engine.b.b bCV;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.bCL = false;
        this.bCM = AspectRatio.Ratio_16_9;
        this.bCN = 0.5625f;
        this.bCO = 30;
        this.bCP = 0;
        this.bCQ = 1280;
        this.bCR = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.bCS = false;
        this.cameraId = 1;
        this.bCT = false;
        this.bCU = null;
        this.bCV = null;
    }

    public static b Pq() {
        return bCW;
    }

    public void cZ(boolean z) {
        this.bCS = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
