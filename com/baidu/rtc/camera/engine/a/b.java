package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public final class b {
    private static final b csO = new b();
    public int cameraId;
    public boolean csD;
    public AspectRatio csE;
    public float csF;
    public int csG;
    public int csH;
    public int csI;
    public int csJ;
    public boolean csK;
    public boolean csL;
    public com.baidu.rtc.camera.engine.b.a csM;
    public com.baidu.rtc.camera.engine.b.b csN;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.csD = false;
        this.csE = AspectRatio.Ratio_16_9;
        this.csF = 0.5625f;
        this.csG = 30;
        this.csH = 0;
        this.csI = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.csJ = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.csK = false;
        this.cameraId = 1;
        this.csL = false;
        this.csM = null;
        this.csN = null;
    }

    public static b agC() {
        return csO;
    }

    public void ex(boolean z) {
        this.csK = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
