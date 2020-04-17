package com.baidu.ar.arrender;

import android.view.Surface;
import com.baidu.ar.DuMixOutput;
/* loaded from: classes3.dex */
class n {
    private DuMixOutput ab;
    private Surface gJ;
    private String im;

    public n(DuMixOutput duMixOutput) {
        this.ab = duMixOutput;
    }

    public void N(String str) {
        this.im = str;
    }

    public String bz() {
        return this.im;
    }

    public Surface getSurface() {
        return this.gJ;
    }

    public void setSurface(Surface surface) {
        this.gJ = surface;
    }
}
