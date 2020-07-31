package com.baidu.ar.vo.c;
/* loaded from: classes11.dex */
public class f extends a implements c {
    private com.baidu.ar.vo.a.b xN;
    private com.baidu.ar.vo.b.a xO;

    public f(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        this.xN = bVar;
    }

    private int b(float[] fArr, int i) {
        return 90.0f - ((float) (((Math.acos((double) (-fArr[10])) * 180.0d) * 1.0d) / 3.141592653589793d)) > ((float) i) ? 0 : 1;
    }

    public void a(com.baidu.ar.vo.b.a aVar) {
        this.xO = aVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        float[] a = this.xO.a(this.xN.fR(), fArr);
        if (a != null) {
            String a2 = this.xi.a(this.xN);
            int i = (int) a[0];
            if (i == 0) {
                int b = b(fArr, this.xN.fR());
                if (b == 0) {
                    this.xi.fW();
                } else if (b == 1) {
                    this.xi.fX();
                }
                this.xi.r(new float[16]);
                return false;
            } else if (i == 1) {
                this.xi.a(a2, (int) a[1], (int) a[2], xK, this.xN.fQ());
                this.xi.fY();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
