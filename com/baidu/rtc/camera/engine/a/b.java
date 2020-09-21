package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes15.dex */
public final class b {
    private static final b bPO = new b();
    public boolean bPB;
    public AspectRatio bPC;
    public float bPD;
    public int bPE;
    public int bPF;
    public int bPG;
    public int bPH;
    public int bPI;
    public int bPJ;
    public boolean bPK;
    public boolean bPL;
    public com.baidu.rtc.camera.engine.b.a bPM;
    public com.baidu.rtc.camera.engine.b.b bPN;
    public int cameraId;
    public int orientation;

    private b() {
        reset();
    }

    private void reset() {
        this.bPB = false;
        this.bPC = AspectRatio.Ratio_16_9;
        this.bPD = 0.5625f;
        this.bPE = 30;
        this.bPF = 0;
        this.bPG = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.bPH = 720;
        this.bPI = 0;
        this.bPJ = 0;
        this.orientation = 0;
        this.bPK = false;
        this.cameraId = 1;
        this.bPL = false;
        this.bPM = null;
        this.bPN = null;
    }

    public static b Xq() {
        return bPO;
    }

    public void dn(boolean z) {
        this.bPK = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
