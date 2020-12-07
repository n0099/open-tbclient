package com.baidu.ar.vo.c;
/* loaded from: classes10.dex */
public class e extends a implements c {
    private com.baidu.ar.vo.a.b zb;

    public e(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.zb = bVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        String[] split = this.zb.he().split(",");
        String a2 = this.yw.a(this.zb);
        int i = this.mPreviewWidth / 2;
        int i2 = this.mPreviewHeight / 2;
        try {
            int[] b = this.yw.b(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
            i = b[0];
            i2 = b[1];
        } catch (NumberFormatException e) {
            com.baidu.ar.h.b.aS("model position is not number !!!");
        }
        this.yw.a(a2, i, i2, yY, this.zb.hf());
        return true;
    }
}
