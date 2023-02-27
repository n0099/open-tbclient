package com.baidu.ar.arrender;

import android.view.Surface;
import com.baidu.ar.DuMixOutput;
/* loaded from: classes.dex */
public class p {
    public DuMixOutput W;
    public Surface gx;
    public String ip;

    public p(DuMixOutput duMixOutput) {
        this.W = duMixOutput;
    }

    public void Q(String str) {
        this.ip = str;
    }

    public String ca() {
        return this.ip;
    }

    public Surface getSurface() {
        return this.gx;
    }

    public void setSurface(Surface surface) {
        this.gx = surface;
    }
}
