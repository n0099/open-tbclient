package com.baidu.ar;

import com.baidu.ar.arrender.Texture;
/* loaded from: classes11.dex */
public class DuMixInput2 extends DuMixInput {
    private Texture bf;
    private boolean bg;

    public DuMixInput2(int i, int i2) {
        super(null, i, i2);
        this.bg = false;
        setCameraInput(false);
        setFrontCamera(false);
    }

    public DuMixInput2(Texture texture, int i, int i2) {
        this(i, i2);
        this.bf = texture;
    }

    public Texture getInputTexture() {
        return this.bf;
    }

    public boolean isSyncInputContent() {
        return this.bg;
    }

    public void setInputTexture(Texture texture) {
        this.bf = texture;
    }

    public void setSyncInputContent(boolean z) {
        this.bg = z;
    }
}
