package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes4.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bBA;
    private c bBB;
    private com.baidu.mario.gldraw2d.params.c bBC;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bBC = cVar;
        this.bBA = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Sl();
    }

    public void Sj() {
        this.bBB = this.bBC.SJ();
        b(this.bBB);
    }

    public com.baidu.mario.gldraw2d.b.a Sk() {
        return this.bBA;
    }

    public void aG(long j) {
        if (this.bBB != null && this.bBC != null) {
            if (this.bBC.SI()) {
                Sl();
            }
            if (j != 0) {
                this.bBC.SK().setTimestamp(j);
            }
            this.bBB.c(this.bBC.SG(), this.bBC.SK());
        }
    }

    public void a(c cVar) {
        if (this.bBC != null) {
            this.bBC.c(cVar);
        }
        this.bBB.release();
        b(cVar);
    }

    public void release() {
        if (this.bBB != null) {
            this.bBB.release();
            this.bBB = null;
        }
        if (this.bBA != null) {
            this.bBA.release();
            this.bBA = null;
        }
    }

    private void Sl() {
        float[] Sz = this.bBC.SK().Sz();
        com.baidu.mario.gldraw2d.e.b.v(Sz);
        com.baidu.mario.gldraw2d.params.a SH = this.bBC.SH();
        com.baidu.mario.gldraw2d.e.b.a(Sz, SH.getTranslateX(), SH.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Sz, SH.St());
        com.baidu.mario.gldraw2d.e.b.a(Sz, SH.Sw());
        if ((SH.Sx() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Sz, this.bBC.SE(), this.bBC.SF(), SH.Su(), SH.Sv());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bBC.SF().clone();
        clone.setWidth(this.bBC.SF().getHeight());
        clone.setHeight(this.bBC.SF().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Sz, this.bBC.SE(), clone, SH.Su(), SH.Sv());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bBB = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bBB = cVar;
        }
        this.bBB.a(this.bBC.SE(), this.bBC.SF());
    }
}
