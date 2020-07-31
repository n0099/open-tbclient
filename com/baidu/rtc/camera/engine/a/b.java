package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes7.dex */
public final class b {
    private static final b bIj = new b();
    public boolean bHY;
    public AspectRatio bHZ;
    public float bIa;
    public int bIb;
    public int bIc;
    public int bId;
    public int bIe;
    public boolean bIf;
    public boolean bIg;
    public com.baidu.rtc.camera.engine.b.a bIh;
    public com.baidu.rtc.camera.engine.b.b bIi;
    public int cameraId;
    public int orientation;
    public int previewHeight;
    public int previewWidth;

    private b() {
        reset();
    }

    private void reset() {
        this.bHY = false;
        this.bHZ = AspectRatio.Ratio_16_9;
        this.bIa = 0.5625f;
        this.bIb = 30;
        this.bIc = 0;
        this.bId = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.bIe = 720;
        this.previewWidth = 0;
        this.previewHeight = 0;
        this.orientation = 0;
        this.bIf = false;
        this.cameraId = 1;
        this.bIg = false;
        this.bIh = null;
        this.bIi = null;
    }

    public static b QL() {
        return bIj;
    }

    public void dg(boolean z) {
        this.bIf = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
