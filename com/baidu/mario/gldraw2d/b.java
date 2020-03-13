package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a aJe;
    private c aJf;
    private com.baidu.mario.gldraw2d.params.c aJg;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.aJg = cVar;
        this.aJe = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ca();
    }

    public void setupFilter() {
        this.aJf = this.aJg.Cz();
        b(this.aJf);
    }

    public com.baidu.mario.gldraw2d.b.a BZ() {
        return this.aJe;
    }

    public void U(long j) {
        if (this.aJf != null && this.aJg != null) {
            if (this.aJg.Cy()) {
                Ca();
            }
            if (j != 0) {
                this.aJg.CA().setTimestamp(j);
            }
            this.aJf.c(this.aJg.Cw(), this.aJg.CA());
        }
    }

    public void a(c cVar) {
        if (this.aJg != null) {
            this.aJg.c(cVar);
        }
        this.aJf.release();
        b(cVar);
    }

    public void release() {
        if (this.aJf != null) {
            this.aJf.release();
            this.aJf = null;
        }
        if (this.aJe != null) {
            this.aJe.release();
            this.aJe = null;
        }
    }

    private void Ca() {
        float[] Cp = this.aJg.CA().Cp();
        com.baidu.mario.gldraw2d.e.b.g(Cp);
        com.baidu.mario.gldraw2d.params.a Cx = this.aJg.Cx();
        com.baidu.mario.gldraw2d.e.b.b(Cp, Cx.getTranslateX(), Cx.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Cp, Cx.Cj());
        com.baidu.mario.gldraw2d.e.b.c(Cp, Cx.Cm());
        if ((Cx.Cn() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Cp, this.aJg.Cu(), this.aJg.Cv(), Cx.Ck(), Cx.Cl());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.aJg.Cv().clone();
        clone.setWidth(this.aJg.Cv().getHeight());
        clone.setHeight(this.aJg.Cv().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Cp, this.aJg.Cu(), clone, Cx.Ck(), Cx.Cl());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.aJf = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.aJf = cVar;
        }
        this.aJf.a(this.aJg.Cu(), this.aJg.Cv());
    }
}
