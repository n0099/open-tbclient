package com.baidu.ar.arrender;

import android.view.Surface;
import com.baidu.ar.DuMixOutput;
/* loaded from: classes3.dex */
class p {
    private DuMixOutput W;
    private Surface gx;
    private String ip;

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
