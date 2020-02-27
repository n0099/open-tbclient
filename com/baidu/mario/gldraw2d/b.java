package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a aJc;
    private c aJd;
    private com.baidu.mario.gldraw2d.params.c aJe;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.aJe = cVar;
        this.aJc = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        BY();
    }

    public void setupFilter() {
        this.aJd = this.aJe.Cx();
        b(this.aJd);
    }

    public com.baidu.mario.gldraw2d.b.a BX() {
        return this.aJc;
    }

    public void U(long j) {
        if (this.aJd != null && this.aJe != null) {
            if (this.aJe.Cw()) {
                BY();
            }
            if (j != 0) {
                this.aJe.Cy().setTimestamp(j);
            }
            this.aJd.c(this.aJe.Cu(), this.aJe.Cy());
        }
    }

    public void a(c cVar) {
        if (this.aJe != null) {
            this.aJe.c(cVar);
        }
        this.aJd.release();
        b(cVar);
    }

    public void release() {
        if (this.aJd != null) {
            this.aJd.release();
            this.aJd = null;
        }
        if (this.aJc != null) {
            this.aJc.release();
            this.aJc = null;
        }
    }

    private void BY() {
        float[] Cn = this.aJe.Cy().Cn();
        com.baidu.mario.gldraw2d.e.b.g(Cn);
        com.baidu.mario.gldraw2d.params.a Cv = this.aJe.Cv();
        com.baidu.mario.gldraw2d.e.b.b(Cn, Cv.getTranslateX(), Cv.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Cn, Cv.Ch());
        com.baidu.mario.gldraw2d.e.b.c(Cn, Cv.Ck());
        if ((Cv.Cl() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Cn, this.aJe.Cs(), this.aJe.Ct(), Cv.Ci(), Cv.Cj());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.aJe.Ct().clone();
        clone.setWidth(this.aJe.Ct().getHeight());
        clone.setHeight(this.aJe.Ct().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Cn, this.aJe.Cs(), clone, Cv.Ci(), Cv.Cj());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.aJd = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.aJd = cVar;
        }
        this.aJd.a(this.aJe.Cs(), this.aJe.Ct());
    }
}
