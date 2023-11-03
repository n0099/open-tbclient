package com.baidu.ar.vo.c;
/* loaded from: classes3.dex */
public class f extends a implements c {
    public com.baidu.ar.vo.a.b zb;
    public com.baidu.ar.vo.b.a zc;

    public f(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.zb = bVar;
    }

    private int b(float[] fArr, int i) {
        return 90.0f - ((float) (((Math.acos((double) (-fArr[10])) * 180.0d) * 1.0d) / 3.141592653589793d)) > ((float) i) ? 0 : 1;
    }

    public void a(com.baidu.ar.vo.b.a aVar) {
        this.zc = aVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        float[] a = this.zc.a(this.zb.hg(), fArr);
        if (a != null) {
            String a2 = this.yw.a(this.zb);
            int i = (int) a[0];
            if (i == 0) {
                int b = b(fArr, this.zb.hg());
                if (b == 0) {
                    this.yw.hl();
                } else if (b == 1) {
                    this.yw.hm();
                }
                this.yw.r(new float[16]);
            } else if (i == 1) {
                this.yw.a(a2, (int) a[1], (int) a[2], a.yY, this.zb.hf());
                this.yw.hn();
                return true;
            }
        }
        return false;
    }
}
