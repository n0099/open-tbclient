package com.baidu.ar.vo.c;
/* loaded from: classes14.dex */
public class f extends a implements c {
    private com.baidu.ar.vo.a.b ym;
    private com.baidu.ar.vo.b.a yn;

    public f(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.ym = bVar;
    }

    private int b(float[] fArr, int i) {
        return 90.0f - ((float) (((Math.acos((double) (-fArr[10])) * 180.0d) * 1.0d) / 3.141592653589793d)) > ((float) i) ? 0 : 1;
    }

    public void a(com.baidu.ar.vo.b.a aVar) {
        this.yn = aVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean r(float[] fArr) {
        float[] a2 = this.yn.a(this.ym.hg(), fArr);
        if (a2 != null) {
            String a3 = this.xH.a(this.ym);
            int i = (int) a2[0];
            if (i == 0) {
                int b = b(fArr, this.ym.hg());
                if (b == 0) {
                    this.xH.hl();
                } else if (b == 1) {
                    this.xH.hm();
                }
                this.xH.s(new float[16]);
                return false;
            } else if (i == 1) {
                this.xH.a(a3, (int) a2[1], (int) a2[2], yj, this.ym.hf());
                this.xH.hn();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
