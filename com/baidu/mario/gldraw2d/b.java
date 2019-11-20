package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private c awA;
    private com.baidu.mario.gldraw2d.params.c awB;
    private com.baidu.mario.gldraw2d.b.a awz;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.awB = cVar;
        this.awz = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        xx();
    }

    public void xv() {
        this.awA = this.awB.xW();
        b(this.awA);
    }

    public com.baidu.mario.gldraw2d.b.a xw() {
        return this.awz;
    }

    public void M(long j) {
        if (this.awA != null && this.awB != null) {
            if (this.awB.xV()) {
                xx();
            }
            if (j != 0) {
                this.awB.xX().setTimestamp(j);
            }
            this.awA.c(this.awB.xT(), this.awB.xX());
        }
    }

    public void a(c cVar) {
        if (this.awB != null) {
            this.awB.c(cVar);
        }
        this.awA.release();
        b(cVar);
    }

    public void release() {
        if (this.awA != null) {
            this.awA.release();
            this.awA = null;
        }
        if (this.awz != null) {
            this.awz.release();
            this.awz = null;
        }
    }

    private void xx() {
        float[] xM = this.awB.xX().xM();
        com.baidu.mario.gldraw2d.e.b.g(xM);
        com.baidu.mario.gldraw2d.params.a xU = this.awB.xU();
        com.baidu.mario.gldraw2d.e.b.a(xM, xU.getTranslateX(), xU.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(xM, xU.xG());
        com.baidu.mario.gldraw2d.e.b.c(xM, xU.xJ());
        if ((xU.xK() + 360) % SubsamplingScaleImageView.ORIENTATION_180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(xM, this.awB.xR(), this.awB.xS(), xU.xH(), xU.xI());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.awB.xS().clone();
        clone.setWidth(this.awB.xS().getHeight());
        clone.setHeight(this.awB.xS().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(xM, this.awB.xR(), clone, xU.xH(), xU.xI());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.awA = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.awA = cVar;
        }
        this.awA.a(this.awB.xR(), this.awB.xS());
    }
}
