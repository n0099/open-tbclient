package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes6.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bUx;
    private c bUy;
    private com.baidu.mario.gldraw2d.params.c bUz;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bUz = cVar;
        this.bUx = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        XO();
    }

    public void XM() {
        this.bUy = this.bUz.Ym();
        b(this.bUy);
    }

    public com.baidu.mario.gldraw2d.b.a XN() {
        return this.bUx;
    }

    public void bg(long j) {
        if (this.bUy != null && this.bUz != null) {
            if (this.bUz.Yl()) {
                XO();
            }
            if (j != 0) {
                this.bUz.Yn().setTimestamp(j);
            }
            this.bUy.c(this.bUz.Yj(), this.bUz.Yn());
        }
    }

    public void a(c cVar) {
        if (this.bUz != null) {
            this.bUz.c(cVar);
        }
        this.bUy.release();
        b(cVar);
    }

    public void release() {
        if (this.bUy != null) {
            this.bUy.release();
            this.bUy = null;
        }
        if (this.bUx != null) {
            this.bUx.release();
            this.bUx = null;
        }
    }

    private void XO() {
        float[] Yc = this.bUz.Yn().Yc();
        com.baidu.mario.gldraw2d.e.b.v(Yc);
        com.baidu.mario.gldraw2d.params.a Yk = this.bUz.Yk();
        com.baidu.mario.gldraw2d.e.b.a(Yc, Yk.getTranslateX(), Yk.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Yc, Yk.XW());
        com.baidu.mario.gldraw2d.e.b.a(Yc, Yk.XZ());
        if ((Yk.Ya() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Yc, this.bUz.Yh(), this.bUz.Yi(), Yk.XX(), Yk.XY());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bUz.Yi().clone();
        clone.setWidth(this.bUz.Yi().getHeight());
        clone.setHeight(this.bUz.Yi().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Yc, this.bUz.Yh(), clone, Yk.XX(), Yk.XY());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bUy = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bUy = cVar;
        }
        this.bUy.a(this.bUz.Yh(), this.bUz.Yi());
    }
}
