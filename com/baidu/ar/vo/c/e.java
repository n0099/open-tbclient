package com.baidu.ar.vo.c;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class e extends a implements c {
    private com.baidu.ar.vo.a.b xN;

    public e(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.xN = bVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        String[] split = this.xN.fP().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        String a = this.xi.a(this.xN);
        int i = this.mPreviewWidth / 2;
        int i2 = this.mPreviewHeight / 2;
        try {
            int[] b = this.xi.b(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
            i = b[0];
            i2 = b[1];
        } catch (NumberFormatException e) {
            com.baidu.ar.f.b.aL("model position is not number !!!");
        }
        this.xi.a(a, i, i2, xK, this.xN.fQ());
        return true;
    }
}
