package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public final class b {
    private static final b chI = new b();
    public int cameraId;
    public int chA;
    public int chB;
    public int chC;
    public int chD;
    public boolean chE;
    public boolean chF;
    public com.baidu.rtc.camera.engine.b.a chG;
    public com.baidu.rtc.camera.engine.b.b chH;
    public boolean chv;
    public AspectRatio chw;
    public float chx;
    public int chy;
    public int chz;
    public int orientation;

    private b() {
        reset();
    }

    private void reset() {
        this.chv = false;
        this.chw = AspectRatio.Ratio_16_9;
        this.chx = 0.5625f;
        this.chy = 30;
        this.chz = 0;
        this.chA = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.chB = 720;
        this.chC = 0;
        this.chD = 0;
        this.orientation = 0;
        this.chE = false;
        this.cameraId = 1;
        this.chF = false;
        this.chG = null;
        this.chH = null;
    }

    public static b abC() {
        return chI;
    }

    public void dW(boolean z) {
        this.chE = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
