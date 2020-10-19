package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public final class b {
    private static final b bZk = new b();
    public boolean bYX;
    public AspectRatio bYY;
    public float bYZ;
    public int bZa;
    public int bZb;
    public int bZc;
    public int bZd;
    public int bZe;
    public int bZf;
    public boolean bZg;
    public boolean bZh;
    public com.baidu.rtc.camera.engine.b.a bZi;
    public com.baidu.rtc.camera.engine.b.b bZj;
    public int cameraId;
    public int orientation;

    private b() {
        reset();
    }

    private void reset() {
        this.bYX = false;
        this.bYY = AspectRatio.Ratio_16_9;
        this.bYZ = 0.5625f;
        this.bZa = 30;
        this.bZb = 0;
        this.bZc = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.bZd = 720;
        this.bZe = 0;
        this.bZf = 0;
        this.orientation = 0;
        this.bZg = false;
        this.cameraId = 1;
        this.bZh = false;
        this.bZi = null;
        this.bZj = null;
    }

    public static b ZI() {
        return bZk;
    }

    public void dI(boolean z) {
        this.bZg = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
