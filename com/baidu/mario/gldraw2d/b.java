package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a acV;
    private c acW;
    private com.baidu.mario.gldraw2d.params.c acX;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.acX = cVar;
        this.acV = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        sd();
    }

    public void sb() {
        this.acW = this.acX.sC();
        b(this.acW);
    }

    public com.baidu.mario.gldraw2d.b.a sc() {
        return this.acV;
    }

    public void u(long j) {
        if (this.acW != null && this.acX != null) {
            if (this.acX.sB()) {
                sd();
            }
            if (j != 0) {
                this.acX.sD().setTimestamp(j);
            }
            this.acW.c(this.acX.sz(), this.acX.sD());
        }
    }

    public void a(c cVar) {
        if (this.acX != null) {
            this.acX.c(cVar);
        }
        this.acW.release();
        b(cVar);
    }

    public void release() {
        if (this.acW != null) {
            this.acW.release();
            this.acW = null;
        }
        if (this.acV != null) {
            this.acV.release();
            this.acV = null;
        }
    }

    private void sd() {
        float[] ss = this.acX.sD().ss();
        com.baidu.mario.gldraw2d.e.b.g(ss);
        com.baidu.mario.gldraw2d.params.a sA = this.acX.sA();
        com.baidu.mario.gldraw2d.e.b.a(ss, sA.getTranslateX(), sA.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(ss, sA.sm());
        com.baidu.mario.gldraw2d.e.b.c(ss, sA.sp());
        if ((sA.sq() + 360) % SubsamplingScaleImageView.ORIENTATION_180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(ss, this.acX.sx(), this.acX.sy(), sA.sn(), sA.so());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.acX.sy().clone();
        clone.setWidth(this.acX.sy().getHeight());
        clone.setHeight(this.acX.sy().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(ss, this.acX.sx(), clone, sA.sn(), sA.so());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.acW = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.acW = cVar;
        }
        this.acW.a(this.acX.sx(), this.acX.sy());
    }
}
