package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public final class b {
    private static final b bNK = new b();
    public int bNA;
    public int bNB;
    public int bNC;
    public int bND;
    public int bNE;
    public int bNF;
    public boolean bNG;
    public boolean bNH;
    public com.baidu.rtc.camera.engine.b.a bNI;
    public com.baidu.rtc.camera.engine.b.b bNJ;
    public boolean bNx;
    public AspectRatio bNy;
    public float bNz;
    public int cameraId;
    public int orientation;

    private b() {
        reset();
    }

    private void reset() {
        this.bNx = false;
        this.bNy = AspectRatio.Ratio_16_9;
        this.bNz = 0.5625f;
        this.bNA = 30;
        this.bNB = 0;
        this.bNC = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.bND = 720;
        this.bNE = 0;
        this.bNF = 0;
        this.orientation = 0;
        this.bNG = false;
        this.cameraId = 1;
        this.bNH = false;
        this.bNI = null;
        this.bNJ = null;
    }

    public static b WH() {
        return bNK;
    }

    /* renamed from: do  reason: not valid java name */
    public void m32do(boolean z) {
        this.bNG = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
