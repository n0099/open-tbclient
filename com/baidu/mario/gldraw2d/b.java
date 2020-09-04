package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes20.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a byd;
    private c bye;
    private com.baidu.mario.gldraw2d.params.c byf;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.byf = cVar;
        this.byd = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ru();
    }

    public void Rs() {
        this.bye = this.byf.RS();
        b(this.bye);
    }

    public com.baidu.mario.gldraw2d.b.a Rt() {
        return this.byd;
    }

    public void aG(long j) {
        if (this.bye != null && this.byf != null) {
            if (this.byf.RR()) {
                Ru();
            }
            if (j != 0) {
                this.byf.RT().setTimestamp(j);
            }
            this.bye.c(this.byf.RP(), this.byf.RT());
        }
    }

    public void a(c cVar) {
        if (this.byf != null) {
            this.byf.c(cVar);
        }
        this.bye.release();
        b(cVar);
    }

    public void release() {
        if (this.bye != null) {
            this.bye.release();
            this.bye = null;
        }
        if (this.byd != null) {
            this.byd.release();
            this.byd = null;
        }
    }

    private void Ru() {
        float[] RI = this.byf.RT().RI();
        com.baidu.mario.gldraw2d.e.b.v(RI);
        com.baidu.mario.gldraw2d.params.a RQ = this.byf.RQ();
        com.baidu.mario.gldraw2d.e.b.a(RI, RQ.getTranslateX(), RQ.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(RI, RQ.RC());
        com.baidu.mario.gldraw2d.e.b.a(RI, RQ.RF());
        if ((RQ.RG() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(RI, this.byf.RN(), this.byf.RO(), RQ.RD(), RQ.RE());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.byf.RO().clone();
        clone.setWidth(this.byf.RO().getHeight());
        clone.setHeight(this.byf.RO().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(RI, this.byf.RN(), clone, RQ.RD(), RQ.RE());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bye = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bye = cVar;
        }
        this.bye.a(this.byf.RN(), this.byf.RO());
    }
}
