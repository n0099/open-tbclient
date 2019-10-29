package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a awR;
    private c awS;
    private com.baidu.mario.gldraw2d.params.c awT;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.awT = cVar;
        this.awR = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        xw();
    }

    public void xu() {
        this.awS = this.awT.xV();
        b(this.awS);
    }

    public com.baidu.mario.gldraw2d.b.a xv() {
        return this.awR;
    }

    public void N(long j) {
        if (this.awS != null && this.awT != null) {
            if (this.awT.xU()) {
                xw();
            }
            if (j != 0) {
                this.awT.xW().setTimestamp(j);
            }
            this.awS.c(this.awT.xS(), this.awT.xW());
        }
    }

    public void a(c cVar) {
        if (this.awT != null) {
            this.awT.c(cVar);
        }
        this.awS.release();
        b(cVar);
    }

    public void release() {
        if (this.awS != null) {
            this.awS.release();
            this.awS = null;
        }
        if (this.awR != null) {
            this.awR.release();
            this.awR = null;
        }
    }

    private void xw() {
        float[] xL = this.awT.xW().xL();
        com.baidu.mario.gldraw2d.e.b.g(xL);
        com.baidu.mario.gldraw2d.params.a xT = this.awT.xT();
        com.baidu.mario.gldraw2d.e.b.a(xL, xT.getTranslateX(), xT.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(xL, xT.xF());
        com.baidu.mario.gldraw2d.e.b.c(xL, xT.xI());
        if ((xT.xJ() + 360) % SubsamplingScaleImageView.ORIENTATION_180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(xL, this.awT.xQ(), this.awT.xR(), xT.xG(), xT.xH());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.awT.xR().clone();
        clone.setWidth(this.awT.xR().getHeight());
        clone.setHeight(this.awT.xR().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(xL, this.awT.xQ(), clone, xT.xG(), xT.xH());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.awS = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.awS = cVar;
        }
        this.awS.a(this.awT.xQ(), this.awT.xR());
    }
}
