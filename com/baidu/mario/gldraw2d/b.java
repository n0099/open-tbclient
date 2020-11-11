package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes5.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bWh;
    private c bWi;
    private com.baidu.mario.gldraw2d.params.c bWj;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bWj = cVar;
        this.bWh = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Yx();
    }

    public void Yv() {
        this.bWi = this.bWj.YV();
        b(this.bWi);
    }

    public com.baidu.mario.gldraw2d.b.a Yw() {
        return this.bWh;
    }

    public void bg(long j) {
        if (this.bWi != null && this.bWj != null) {
            if (this.bWj.YU()) {
                Yx();
            }
            if (j != 0) {
                this.bWj.YW().setTimestamp(j);
            }
            this.bWi.c(this.bWj.YS(), this.bWj.YW());
        }
    }

    public void a(c cVar) {
        if (this.bWj != null) {
            this.bWj.c(cVar);
        }
        this.bWi.release();
        b(cVar);
    }

    public void release() {
        if (this.bWi != null) {
            this.bWi.release();
            this.bWi = null;
        }
        if (this.bWh != null) {
            this.bWh.release();
            this.bWh = null;
        }
    }

    private void Yx() {
        float[] YL = this.bWj.YW().YL();
        com.baidu.mario.gldraw2d.e.b.v(YL);
        com.baidu.mario.gldraw2d.params.a YT = this.bWj.YT();
        com.baidu.mario.gldraw2d.e.b.a(YL, YT.getTranslateX(), YT.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(YL, YT.YF());
        com.baidu.mario.gldraw2d.e.b.a(YL, YT.YI());
        if ((YT.YJ() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(YL, this.bWj.YQ(), this.bWj.YR(), YT.YG(), YT.YH());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bWj.YR().clone();
        clone.setWidth(this.bWj.YR().getHeight());
        clone.setHeight(this.bWj.YR().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(YL, this.bWj.YQ(), clone, YT.YG(), YT.YH());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bWi = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bWi = cVar;
        }
        this.bWi.a(this.bWj.YQ(), this.bWj.YR());
    }
}
