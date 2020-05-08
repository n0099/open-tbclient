package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bfp;
    private c bfq;
    private com.baidu.mario.gldraw2d.params.c bfr;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bfr = cVar;
        this.bfp = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Il();
    }

    public void Ij() {
        this.bfq = this.bfr.IK();
        b(this.bfq);
    }

    public com.baidu.mario.gldraw2d.b.a Ik() {
        return this.bfp;
    }

    public void aA(long j) {
        if (this.bfq != null && this.bfr != null) {
            if (this.bfr.IJ()) {
                Il();
            }
            if (j != 0) {
                this.bfr.IL().setTimestamp(j);
            }
            this.bfq.c(this.bfr.IH(), this.bfr.IL());
        }
    }

    public void a(c cVar) {
        if (this.bfr != null) {
            this.bfr.c(cVar);
        }
        this.bfq.release();
        b(cVar);
    }

    public void release() {
        if (this.bfq != null) {
            this.bfq.release();
            this.bfq = null;
        }
        if (this.bfp != null) {
            this.bfp.release();
            this.bfp = null;
        }
    }

    private void Il() {
        float[] IA = this.bfr.IL().IA();
        com.baidu.mario.gldraw2d.e.b.u(IA);
        com.baidu.mario.gldraw2d.params.a II = this.bfr.II();
        com.baidu.mario.gldraw2d.e.b.a(IA, II.getTranslateX(), II.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(IA, II.Iu());
        com.baidu.mario.gldraw2d.e.b.a(IA, II.Ix());
        if ((II.Iy() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(IA, this.bfr.IF(), this.bfr.IG(), II.Iv(), II.Iw());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bfr.IG().clone();
        clone.setWidth(this.bfr.IG().getHeight());
        clone.setHeight(this.bfr.IG().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(IA, this.bfr.IF(), clone, II.Iv(), II.Iw());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bfq = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bfq = cVar;
        }
        this.bfq.a(this.bfr.IF(), this.bfr.IG());
    }
}
