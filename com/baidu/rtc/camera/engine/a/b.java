package com.baidu.rtc.camera.engine.a;

import com.baidu.rtc.camera.engine.model.AspectRatio;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public final class b {
    private static final b cnE = new b();
    public int cameraId;
    public boolean cnA;
    public boolean cnB;
    public com.baidu.rtc.camera.engine.b.a cnC;
    public com.baidu.rtc.camera.engine.b.b cnD;
    public boolean cnq;
    public AspectRatio cnr;
    public float cns;
    public int cnu;
    public int cnv;
    public int cnw;
    public int cnx;
    public int cny;
    public int cnz;
    public int orientation;

    private b() {
        reset();
    }

    private void reset() {
        this.cnq = false;
        this.cnr = AspectRatio.Ratio_16_9;
        this.cns = 0.5625f;
        this.cnu = 30;
        this.cnv = 0;
        this.cnw = PlatformPlugin.DEFAULT_SYSTEM_UI;
        this.cnx = 720;
        this.cny = 0;
        this.cnz = 0;
        this.orientation = 0;
        this.cnA = false;
        this.cameraId = 1;
        this.cnB = false;
        this.cnC = null;
        this.cnD = null;
    }

    public static b aec() {
        return cnE;
    }

    public void ef(boolean z) {
        this.cnA = z;
        if (z) {
            this.cameraId = 0;
        } else {
            this.cameraId = 1;
        }
    }
}
