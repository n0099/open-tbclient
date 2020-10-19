package com.baidu.ar.vo.c;
/* loaded from: classes14.dex */
public class a implements c {
    protected static final float[] yj = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    protected int mPreviewHeight;
    protected int mPreviewWidth;
    protected d xH;

    public a(d dVar, int i, int i2) {
        this.xH = dVar;
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    @Override // com.baidu.ar.vo.c.c
    public boolean r(float[] fArr) {
        this.xH.a(this.xH.a((com.baidu.ar.vo.a.b) null), this.mPreviewWidth / 2, this.mPreviewHeight / 2, yj, 1000.0f);
        return true;
    }
}
