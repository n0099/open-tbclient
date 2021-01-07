package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes3.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a cgw;
    private c cgx;
    private com.baidu.mario.gldraw2d.params.c cgy;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.cgy = cVar;
        this.cgw = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        acf();
    }

    public void acd() {
        this.cgx = this.cgy.acB();
        b(this.cgx);
    }

    public com.baidu.mario.gldraw2d.b.a ace() {
        return this.cgw;
    }

    public void bE(long j) {
        if (this.cgx != null && this.cgy != null) {
            if (this.cgy.acA()) {
                acf();
            }
            if (j != 0) {
                this.cgy.acC().setTimestamp(j);
            }
            this.cgx.c(this.cgy.acy(), this.cgy.acC());
        }
    }

    public void a(c cVar) {
        if (this.cgy != null) {
            this.cgy.c(cVar);
        }
        this.cgx.release();
        b(cVar);
    }

    public void release() {
        if (this.cgx != null) {
            this.cgx.release();
            this.cgx = null;
        }
        if (this.cgw != null) {
            this.cgw.release();
            this.cgw = null;
        }
    }

    private void acf() {
        float[] mVPMatrix = this.cgy.acC().getMVPMatrix();
        com.baidu.mario.gldraw2d.e.b.u(mVPMatrix);
        com.baidu.mario.gldraw2d.params.a acz = this.cgy.acz();
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, acz.getTranslateX(), acz.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, acz.acm());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, acz.acp());
        if ((acz.acq() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.cgy.acw(), this.cgy.acx(), acz.acn(), acz.aco());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.cgy.acx().clone();
        clone.setWidth(this.cgy.acx().getHeight());
        clone.setHeight(this.cgy.acx().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.cgy.acw(), clone, acz.acn(), acz.aco());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.cgx = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.cgx = cVar;
        }
        this.cgx.a(this.cgy.acw(), this.cgy.acx());
    }
}
