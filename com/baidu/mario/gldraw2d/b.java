package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a aJd;
    private c aJe;
    private com.baidu.mario.gldraw2d.params.c aJf;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.aJf = cVar;
        this.aJd = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ca();
    }

    public void setupFilter() {
        this.aJe = this.aJf.Cz();
        b(this.aJe);
    }

    public com.baidu.mario.gldraw2d.b.a BZ() {
        return this.aJd;
    }

    public void U(long j) {
        if (this.aJe != null && this.aJf != null) {
            if (this.aJf.Cy()) {
                Ca();
            }
            if (j != 0) {
                this.aJf.CA().setTimestamp(j);
            }
            this.aJe.c(this.aJf.Cw(), this.aJf.CA());
        }
    }

    public void a(c cVar) {
        if (this.aJf != null) {
            this.aJf.c(cVar);
        }
        this.aJe.release();
        b(cVar);
    }

    public void release() {
        if (this.aJe != null) {
            this.aJe.release();
            this.aJe = null;
        }
        if (this.aJd != null) {
            this.aJd.release();
            this.aJd = null;
        }
    }

    private void Ca() {
        float[] Cp = this.aJf.CA().Cp();
        com.baidu.mario.gldraw2d.e.b.g(Cp);
        com.baidu.mario.gldraw2d.params.a Cx = this.aJf.Cx();
        com.baidu.mario.gldraw2d.e.b.b(Cp, Cx.getTranslateX(), Cx.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Cp, Cx.Cj());
        com.baidu.mario.gldraw2d.e.b.c(Cp, Cx.Cm());
        if ((Cx.Cn() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Cp, this.aJf.Cu(), this.aJf.Cv(), Cx.Ck(), Cx.Cl());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.aJf.Cv().clone();
        clone.setWidth(this.aJf.Cv().getHeight());
        clone.setHeight(this.aJf.Cv().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Cp, this.aJf.Cu(), clone, Cx.Ck(), Cx.Cl());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.aJe = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.aJe = cVar;
        }
        this.aJe.a(this.aJf.Cu(), this.aJf.Cv());
    }
}
