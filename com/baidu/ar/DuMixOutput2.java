package com.baidu.ar;

import android.graphics.SurfaceTexture;
import com.baidu.ar.arrender.Texture;
/* loaded from: classes3.dex */
public class DuMixOutput2 extends DuMixOutput {
    private Texture bo;

    public DuMixOutput2(int i, int i2) {
        super((SurfaceTexture) null, i, i2);
    }

    public DuMixOutput2(Texture texture, int i, int i2) {
        this(i, i2);
        this.bo = texture;
    }

    public Texture getOutputTexture() {
        return this.bo;
    }

    public void setOutputTexture(Texture texture) {
        this.bo = texture;
    }
}
