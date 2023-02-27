package com.baidu.ar.vo.c;
/* loaded from: classes.dex */
public class e extends a implements c {
    public com.baidu.ar.vo.a.b zb;

    public e(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.zb = bVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        int i;
        int i2;
        String[] split = this.zb.he().split(",");
        String a = this.yw.a(this.zb);
        int i3 = this.mPreviewWidth / 2;
        int i4 = this.mPreviewHeight / 2;
        try {
            int[] b = this.yw.b(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
            i3 = b[0];
            i2 = b[1];
            i = i3;
        } catch (NumberFormatException unused) {
            com.baidu.ar.h.b.aS("model position is not number !!!");
            i = i3;
            i2 = i4;
        }
        this.yw.a(a, i, i2, a.yY, this.zb.hf());
        return true;
    }
}
