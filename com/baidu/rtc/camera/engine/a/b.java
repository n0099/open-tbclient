package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
/* loaded from: classes6.dex */
public final class b {
    private static final b bvt = new b();
    public boolean bvi;
    public AspectRatio bvj;
    public float bvk;
    public int bvl;
    public int bvm;
    public int bvn;
    public int bvo;
    public boolean bvp;
    public boolean bvq;
    public com.baidu.rtc.camera.engine.b.a bvr;
    public com.baidu.rtc.camera.engine.b.b bvs;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.bvi = false;
        this.bvj = AspectRatio.Ratio_16_9;
        this.bvk = 0.5625f;
        this.bvl = 30;
        this.bvm = 0;
        this.bvn = 1280;
        this.bvo = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.bvp = false;
        this.cameraId = 1;
        this.bvq = false;
        this.bvr = null;
        this.bvs = null;
    }

    public static b Nd() {
        return bvt;
    }

    public void cN(boolean z) {
        this.bvp = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
