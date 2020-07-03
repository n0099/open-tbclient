package com.baidu.ar.vo.c;
/* loaded from: classes3.dex */
public class a implements c {
    protected static final float[] xK = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    protected int mPreviewHeight;
    protected int mPreviewWidth;
    protected d xi;

    public a(d dVar, int i, int i2) {
        this.xi = dVar;
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    @Override // com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        this.xi.a(this.xi.a((com.baidu.ar.vo.a.b) null), this.mPreviewWidth / 2, this.mPreviewHeight / 2, xK, 1000.0f);
        return true;
    }
}
