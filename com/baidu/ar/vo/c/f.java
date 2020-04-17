package com.baidu.ar.vo.c;
/* loaded from: classes3.dex */
public class f extends a implements c {
    private com.baidu.ar.vo.a.b xn;
    private com.baidu.ar.vo.b.a xo;

    public f(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.xn = bVar;
    }

    private int b(float[] fArr, int i) {
        return 90.0f - ((float) (((Math.acos((double) (-fArr[10])) * 180.0d) * 1.0d) / 3.141592653589793d)) > ((float) i) ? 0 : 1;
    }

    public void a(com.baidu.ar.vo.b.a aVar) {
        this.xo = aVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean p(float[] fArr) {
        float[] a = this.xo.a(this.xn.fB(), fArr);
        if (a != null) {
            String a2 = this.wI.a(this.xn);
            int i = (int) a[0];
            if (i == 0) {
                int b = b(fArr, this.xn.fB());
                if (b == 0) {
                    this.wI.fG();
                } else if (b == 1) {
                    this.wI.fH();
                }
                this.wI.q(new float[16]);
                return false;
            } else if (i == 1) {
                this.wI.a(a2, (int) a[1], (int) a[2], xk, this.xn.fA());
                this.wI.fI();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
