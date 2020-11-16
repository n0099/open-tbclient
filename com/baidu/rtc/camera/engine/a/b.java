package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes16.dex */
public final class b {
    private static final b clS = new b();
    public int cameraId;
    public boolean clF;
    public AspectRatio clG;
    public float clH;
    public int clI;
    public int clJ;
    public int clK;
    public int clL;
    public int clM;
    public int clN;
    public boolean clO;
    public boolean clP;
    public com.baidu.rtc.camera.engine.b.a clQ;
    public com.baidu.rtc.camera.engine.b.b clR;
    public int orientation;

    private b() {
        reset();
    }

    private void reset() {
        this.clF = false;
        this.clG = AspectRatio.Ratio_16_9;
        this.clH = 0.5625f;
        this.clI = 30;
        this.clJ = 0;
        this.clK = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.clL = 720;
        this.clM = 0;
        this.clN = 0;
        this.orientation = 0;
        this.clO = false;
        this.cameraId = 1;
        this.clP = false;
        this.clQ = null;
        this.clR = null;
    }

    public static b adu() {
        return clS;
    }

    public void eh(boolean z) {
        this.clO = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
