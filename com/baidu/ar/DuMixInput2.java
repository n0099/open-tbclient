package com.baidu.ar;

import com.baidu.ar.arrender.Texture;
/* loaded from: classes3.dex */
public class DuMixInput2 extends DuMixInput {
    private Texture aT;
    private boolean aU;

    public DuMixInput2(int i, int i2) {
        super(null, i, i2);
        this.aU = false;
        setCameraInput(false);
        setFrontCamera(false);
    }

    public DuMixInput2(Texture texture, int i, int i2) {
        this(i, i2);
        this.aT = texture;
    }

    public Texture getInputTexture() {
        return this.aT;
    }

    public boolean isSyncInputContent() {
        return this.aU;
    }

    public void setInputTexture(Texture texture) {
        this.aT = texture;
    }

    public void setSyncInputContent(boolean z) {
        this.aU = z;
    }
}
