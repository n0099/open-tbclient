package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes5.dex */
public final class b {
    private static final b aSf = new b();
    public boolean aRU;
    public AspectRatio aRV;
    public float aRW;
    public int aRX;
    public int aRY;
    public int aRZ;
    public int aSa;
    public boolean aSb;
    public boolean aSc;
    public com.baidu.rtc.camera.engine.b.a aSd;
    public com.baidu.rtc.camera.engine.b.b aSe;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.aRU = false;
        this.aRV = AspectRatio.Ratio_16_9;
        this.aRW = 0.5625f;
        this.aRX = 30;
        this.aRY = 0;
        this.aRZ = 1280;
        this.aSa = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.aSb = false;
        this.cameraId = 1;
        this.aSc = false;
        this.aSd = null;
        this.aSe = null;
    }

    public static b CP() {
        return aSf;
    }

    public void bG(boolean z) {
        this.aSb = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
