package com.baidu.ar.arrender;

import android.view.Surface;
import com.baidu.ar.DuMixOutput;
/* loaded from: classes11.dex */
class o {
    private DuMixOutput aa;
    private Surface gk;
    private String hZ;

    public o(DuMixOutput duMixOutput) {
        this.aa = duMixOutput;
    }

    public void N(String str) {
        this.hZ = str;
    }

    public String cb() {
        return this.hZ;
    }

    public Surface getSurface() {
        return this.gk;
    }

    public void setSurface(Surface surface) {
        this.gk = surface;
    }
}
