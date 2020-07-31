package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes10.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bsk;
    private c bsl;
    private com.baidu.mario.gldraw2d.params.c bsm;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bsm = cVar;
        this.bsk = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Lu();
    }

    public void Ls() {
        this.bsl = this.bsm.LT();
        b(this.bsl);
    }

    public com.baidu.mario.gldraw2d.b.a Lt() {
        return this.bsk;
    }

    public void aF(long j) {
        if (this.bsl != null && this.bsm != null) {
            if (this.bsm.LS()) {
                Lu();
            }
            if (j != 0) {
                this.bsm.LU().setTimestamp(j);
            }
            this.bsl.c(this.bsm.LQ(), this.bsm.LU());
        }
    }

    public void a(c cVar) {
        if (this.bsm != null) {
            this.bsm.c(cVar);
        }
        this.bsl.release();
        b(cVar);
    }

    public void release() {
        if (this.bsl != null) {
            this.bsl.release();
            this.bsl = null;
        }
        if (this.bsk != null) {
            this.bsk.release();
            this.bsk = null;
        }
    }

    private void Lu() {
        float[] LJ = this.bsm.LU().LJ();
        com.baidu.mario.gldraw2d.e.b.v(LJ);
        com.baidu.mario.gldraw2d.params.a LR = this.bsm.LR();
        com.baidu.mario.gldraw2d.e.b.a(LJ, LR.getTranslateX(), LR.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(LJ, LR.LD());
        com.baidu.mario.gldraw2d.e.b.a(LJ, LR.LG());
        if ((LR.LH() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(LJ, this.bsm.LO(), this.bsm.LP(), LR.LE(), LR.LF());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bsm.LP().clone();
        clone.setWidth(this.bsm.LP().getHeight());
        clone.setHeight(this.bsm.LP().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(LJ, this.bsm.LO(), clone, LR.LE(), LR.LF());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bsl = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bsl = cVar;
        }
        this.bsl.a(this.bsm.LO(), this.bsm.LP());
    }
}
