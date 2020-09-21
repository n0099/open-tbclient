package com.baidu.ar.vo.c;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes10.dex */
public class e extends a implements c {
    private com.baidu.ar.vo.a.b ym;

    public e(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.ym = bVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean r(float[] fArr) {
        String[] split = this.ym.he().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        String a = this.xH.a(this.ym);
        int i = this.mPreviewWidth / 2;
        int i2 = this.mPreviewHeight / 2;
        try {
            int[] b = this.xH.b(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
            i = b[0];
            i2 = b[1];
        } catch (NumberFormatException e) {
            com.baidu.ar.g.b.aP("model position is not number !!!");
        }
        this.xH.a(a, i, i2, yj, this.ym.hf());
        return true;
    }
}
