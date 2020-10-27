package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes5.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bQx;
    private c bQy;
    private com.baidu.mario.gldraw2d.params.c bQz;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bQz = cVar;
        this.bQx = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        VY();
    }

    public void VW() {
        this.bQy = this.bQz.Ww();
        b(this.bQy);
    }

    public com.baidu.mario.gldraw2d.b.a VX() {
        return this.bQx;
    }

    public void aK(long j) {
        if (this.bQy != null && this.bQz != null) {
            if (this.bQz.Wv()) {
                VY();
            }
            if (j != 0) {
                this.bQz.Wx().setTimestamp(j);
            }
            this.bQy.c(this.bQz.Wt(), this.bQz.Wx());
        }
    }

    public void a(c cVar) {
        if (this.bQz != null) {
            this.bQz.c(cVar);
        }
        this.bQy.release();
        b(cVar);
    }

    public void release() {
        if (this.bQy != null) {
            this.bQy.release();
            this.bQy = null;
        }
        if (this.bQx != null) {
            this.bQx.release();
            this.bQx = null;
        }
    }

    private void VY() {
        float[] Wm = this.bQz.Wx().Wm();
        com.baidu.mario.gldraw2d.e.b.v(Wm);
        com.baidu.mario.gldraw2d.params.a Wu = this.bQz.Wu();
        com.baidu.mario.gldraw2d.e.b.a(Wm, Wu.getTranslateX(), Wu.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Wm, Wu.Wg());
        com.baidu.mario.gldraw2d.e.b.a(Wm, Wu.Wj());
        if ((Wu.Wk() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Wm, this.bQz.Wr(), this.bQz.Ws(), Wu.Wh(), Wu.Wi());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bQz.Ws().clone();
        clone.setWidth(this.bQz.Ws().getHeight());
        clone.setHeight(this.bQz.Ws().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Wm, this.bQz.Wr(), clone, Wu.Wh(), Wu.Wi());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bQy = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bQy = cVar;
        }
        this.bQy.a(this.bQz.Wr(), this.bQz.Ws());
    }
}
