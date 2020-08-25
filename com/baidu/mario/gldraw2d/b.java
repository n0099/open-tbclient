package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes20.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bya;
    private c byb;
    private com.baidu.mario.gldraw2d.params.c byc;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.byc = cVar;
        this.bya = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ru();
    }

    public void Rs() {
        this.byb = this.byc.RS();
        b(this.byb);
    }

    public com.baidu.mario.gldraw2d.b.a Rt() {
        return this.bya;
    }

    public void aG(long j) {
        if (this.byb != null && this.byc != null) {
            if (this.byc.RR()) {
                Ru();
            }
            if (j != 0) {
                this.byc.RT().setTimestamp(j);
            }
            this.byb.c(this.byc.RP(), this.byc.RT());
        }
    }

    public void a(c cVar) {
        if (this.byc != null) {
            this.byc.c(cVar);
        }
        this.byb.release();
        b(cVar);
    }

    public void release() {
        if (this.byb != null) {
            this.byb.release();
            this.byb = null;
        }
        if (this.bya != null) {
            this.bya.release();
            this.bya = null;
        }
    }

    private void Ru() {
        float[] RI = this.byc.RT().RI();
        com.baidu.mario.gldraw2d.e.b.v(RI);
        com.baidu.mario.gldraw2d.params.a RQ = this.byc.RQ();
        com.baidu.mario.gldraw2d.e.b.a(RI, RQ.getTranslateX(), RQ.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(RI, RQ.RC());
        com.baidu.mario.gldraw2d.e.b.a(RI, RQ.RF());
        if ((RQ.RG() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(RI, this.byc.RN(), this.byc.RO(), RQ.RD(), RQ.RE());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.byc.RO().clone();
        clone.setWidth(this.byc.RO().getHeight());
        clone.setHeight(this.byc.RO().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(RI, this.byc.RN(), clone, RQ.RD(), RQ.RE());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.byb = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.byb = cVar;
        }
        this.byb.a(this.byc.RN(), this.byc.RO());
    }
}
