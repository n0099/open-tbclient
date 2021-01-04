package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes5.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a cgw;
    private c cgx;
    private com.baidu.mario.gldraw2d.params.c cgy;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.cgy = cVar;
        this.cgw = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        ace();
    }

    public void acc() {
        this.cgx = this.cgy.acA();
        b(this.cgx);
    }

    public com.baidu.mario.gldraw2d.b.a acd() {
        return this.cgw;
    }

    public void bE(long j) {
        if (this.cgx != null && this.cgy != null) {
            if (this.cgy.acz()) {
                ace();
            }
            if (j != 0) {
                this.cgy.acB().setTimestamp(j);
            }
            this.cgx.c(this.cgy.acx(), this.cgy.acB());
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

    private void ace() {
        float[] mVPMatrix = this.cgy.acB().getMVPMatrix();
        com.baidu.mario.gldraw2d.e.b.u(mVPMatrix);
        com.baidu.mario.gldraw2d.params.a acy = this.cgy.acy();
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, acy.getTranslateX(), acy.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, acy.acl());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, acy.aco());
        if ((acy.acp() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.cgy.acv(), this.cgy.acw(), acy.acm(), acy.acn());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.cgy.acw().clone();
        clone.setWidth(this.cgy.acw().getHeight());
        clone.setHeight(this.cgy.acw().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.cgy.acv(), clone, acy.acm(), acy.acn());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.cgx = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.cgx = cVar;
        }
        this.cgx.a(this.cgy.acv(), this.cgy.acw());
    }
}
