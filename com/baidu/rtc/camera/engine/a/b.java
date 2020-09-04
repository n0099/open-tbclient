package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public final class b {
    private static final b bNO = new b();
    public boolean bNB;
    public AspectRatio bNC;
    public float bND;
    public int bNE;
    public int bNF;
    public int bNG;
    public int bNH;
    public int bNI;
    public int bNJ;
    public boolean bNK;
    public boolean bNL;
    public com.baidu.rtc.camera.engine.b.a bNM;
    public com.baidu.rtc.camera.engine.b.b bNN;
    public int cameraId;
    public int orientation;

    private b() {
        reset();
    }

    private void reset() {
        this.bNB = false;
        this.bNC = AspectRatio.Ratio_16_9;
        this.bND = 0.5625f;
        this.bNE = 30;
        this.bNF = 0;
        this.bNG = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.bNH = 720;
        this.bNI = 0;
        this.bNJ = 0;
        this.orientation = 0;
        this.bNK = false;
        this.cameraId = 1;
        this.bNL = false;
        this.bNM = null;
        this.bNN = null;
    }

    public static b WH() {
        return bNO;
    }

    public void dp(boolean z) {
        this.bNK = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
