package com.baidu.ar;

import android.graphics.SurfaceTexture;
import com.baidu.ar.arrender.Texture;
/* loaded from: classes3.dex */
public class DuMixOutput2 extends DuMixOutput {
    private Texture bA;

    public DuMixOutput2(int i, int i2) {
        super((SurfaceTexture) null, i, i2);
    }

    public DuMixOutput2(Texture texture, int i, int i2) {
        this(i, i2);
        this.bA = texture;
    }

    public Texture getOutputTexture() {
        return this.bA;
    }

    public void setOutputTexture(Texture texture) {
        this.bA = texture;
    }
}
