package com.baidu.ar.vo.c;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class e extends a implements c {
    private com.baidu.ar.vo.a.b xn;

    public e(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.xn = bVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean p(float[] fArr) {
        String[] split = this.xn.fz().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        String a = this.wI.a(this.xn);
        int i = this.mPreviewWidth / 2;
        int i2 = this.mPreviewHeight / 2;
        try {
            int[] b = this.wI.b(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
            i = b[0];
            i2 = b[1];
        } catch (NumberFormatException e) {
            com.baidu.ar.f.b.aK("model position is not number !!!");
        }
        this.wI.a(a, i, i2, xk, this.xn.fA());
        return true;
    }
}
