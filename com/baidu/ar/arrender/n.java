package com.baidu.ar.arrender;

import android.view.Surface;
import com.baidu.ar.DuMixOutput;
/* loaded from: classes3.dex */
class n {
    private DuMixOutput aa;
    private Surface gV;
    private String iB;

    public n(DuMixOutput duMixOutput) {
        this.aa = duMixOutput;
    }

    public void N(String str) {
        this.iB = str;
    }

    public String bN() {
        return this.iB;
    }

    public Surface getSurface() {
        return this.gV;
    }

    public void setSurface(Surface surface) {
        this.gV = surface;
    }
}
