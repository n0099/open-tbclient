package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a adt;
    private c adu;
    private com.baidu.mario.gldraw2d.params.c adv;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.adv = cVar;
        this.adt = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        sB();
    }

    public void sz() {
        this.adu = this.adv.ta();
        b(this.adu);
    }

    public com.baidu.mario.gldraw2d.b.a sA() {
        return this.adt;
    }

    public void u(long j) {
        if (this.adu != null && this.adv != null) {
            if (this.adv.sZ()) {
                sB();
            }
            if (j != 0) {
                this.adv.tb().setTimestamp(j);
            }
            this.adu.c(this.adv.sX(), this.adv.tb());
        }
    }

    public void a(c cVar) {
        if (this.adv != null) {
            this.adv.c(cVar);
        }
        this.adu.release();
        b(cVar);
    }

    public void release() {
        if (this.adu != null) {
            this.adu.release();
            this.adu = null;
        }
        if (this.adt != null) {
            this.adt.release();
            this.adt = null;
        }
    }

    private void sB() {
        float[] sQ = this.adv.tb().sQ();
        com.baidu.mario.gldraw2d.e.b.g(sQ);
        com.baidu.mario.gldraw2d.params.a sY = this.adv.sY();
        com.baidu.mario.gldraw2d.e.b.a(sQ, sY.getTranslateX(), sY.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(sQ, sY.sK());
        com.baidu.mario.gldraw2d.e.b.c(sQ, sY.sN());
        if ((sY.sO() + 360) % SubsamplingScaleImageView.ORIENTATION_180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(sQ, this.adv.sV(), this.adv.sW(), sY.sL(), sY.sM());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.adv.sW().clone();
        clone.setWidth(this.adv.sW().getHeight());
        clone.setHeight(this.adv.sW().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(sQ, this.adv.sV(), clone, sY.sL(), sY.sM());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.adu = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.adu = cVar;
        }
        this.adu.a(this.adv.sV(), this.adv.sW());
    }
}
