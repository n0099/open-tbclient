package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes6.dex */
public final class b {
    private static final b bvo = new b();
    public boolean bvd;
    public AspectRatio bve;
    public float bvf;
    public int bvg;
    public int bvh;
    public int bvi;
    public int bvj;
    public boolean bvk;
    public boolean bvl;
    public com.baidu.rtc.camera.engine.b.a bvm;
    public com.baidu.rtc.camera.engine.b.b bvn;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.bvd = false;
        this.bve = AspectRatio.Ratio_16_9;
        this.bvf = 0.5625f;
        this.bvg = 30;
        this.bvh = 0;
        this.bvi = 1280;
        this.bvj = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.bvk = false;
        this.cameraId = 1;
        this.bvl = false;
        this.bvm = null;
        this.bvn = null;
    }

    public static b Ne() {
        return bvo;
    }

    public void cN(boolean z) {
        this.bvk = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
