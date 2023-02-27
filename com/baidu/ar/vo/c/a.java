package com.baidu.ar.vo.c;
/* loaded from: classes.dex */
public class a implements c {
    public static final float[] yY = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public int mPreviewHeight;
    public int mPreviewWidth;
    public d yw;

    public a(d dVar, int i, int i2) {
        this.yw = dVar;
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    @Override // com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        d dVar = this.yw;
        dVar.a(dVar.a((com.baidu.ar.vo.a.b) null), this.mPreviewWidth / 2, this.mPreviewHeight / 2, yY, 1000.0f);
        return true;
    }
}
