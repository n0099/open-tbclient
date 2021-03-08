package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes14.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a chs;
    private c cht;
    private com.baidu.mario.gldraw2d.params.c chu;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.chu = cVar;
        this.chs = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        aaj();
    }

    public void aah() {
        this.cht = this.chu.aaE();
        b(this.cht);
    }

    public com.baidu.mario.gldraw2d.b.a aai() {
        return this.chs;
    }

    public void bI(long j) {
        if (this.cht != null && this.chu != null) {
            if (this.chu.aaD()) {
                aaj();
            }
            if (j != 0) {
                this.chu.aaF().setTimestamp(j);
            }
            this.cht.c(this.chu.aaB(), this.chu.aaF());
        }
    }

    public void a(c cVar) {
        if (this.chu != null) {
            this.chu.c(cVar);
        }
        this.cht.release();
        b(cVar);
    }

    public void release() {
        if (this.cht != null) {
            this.cht.release();
            this.cht = null;
        }
        if (this.chs != null) {
            this.chs.release();
            this.chs = null;
        }
    }

    private void aaj() {
        float[] mVPMatrix = this.chu.aaF().getMVPMatrix();
        com.baidu.mario.gldraw2d.e.b.u(mVPMatrix);
        com.baidu.mario.gldraw2d.params.a aaC = this.chu.aaC();
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, aaC.getTranslateX(), aaC.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, aaC.aap());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, aaC.aas());
        if ((aaC.aat() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.chu.aaz(), this.chu.aaA(), aaC.aaq(), aaC.aar());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.chu.aaA().clone();
        clone.setWidth(this.chu.aaA().getHeight());
        clone.setHeight(this.chu.aaA().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.chu.aaz(), clone, aaC.aaq(), aaC.aar());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.cht = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.cht = cVar;
        }
        this.cht.a(this.chu.aaz(), this.chu.aaA());
    }
}
