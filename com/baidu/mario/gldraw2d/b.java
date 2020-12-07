package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes14.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bZM;
    private c bZN;
    private com.baidu.mario.gldraw2d.params.c bZO;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bZO = cVar;
        this.bZM = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        aar();
    }

    public void aap() {
        this.bZN = this.bZO.aaP();
        b(this.bZN);
    }

    public com.baidu.mario.gldraw2d.b.a aaq() {
        return this.bZM;
    }

    public void bE(long j) {
        if (this.bZN != null && this.bZO != null) {
            if (this.bZO.aaO()) {
                aar();
            }
            if (j != 0) {
                this.bZO.aaQ().setTimestamp(j);
            }
            this.bZN.c(this.bZO.aaM(), this.bZO.aaQ());
        }
    }

    public void a(c cVar) {
        if (this.bZO != null) {
            this.bZO.c(cVar);
        }
        this.bZN.release();
        b(cVar);
    }

    public void release() {
        if (this.bZN != null) {
            this.bZN.release();
            this.bZN = null;
        }
        if (this.bZM != null) {
            this.bZM.release();
            this.bZM = null;
        }
    }

    private void aar() {
        float[] aaF = this.bZO.aaQ().aaF();
        com.baidu.mario.gldraw2d.e.b.u(aaF);
        com.baidu.mario.gldraw2d.params.a aaN = this.bZO.aaN();
        com.baidu.mario.gldraw2d.e.b.a(aaF, aaN.getTranslateX(), aaN.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(aaF, aaN.aaz());
        com.baidu.mario.gldraw2d.e.b.a(aaF, aaN.aaC());
        if ((aaN.aaD() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(aaF, this.bZO.aaK(), this.bZO.aaL(), aaN.aaA(), aaN.aaB());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bZO.aaL().clone();
        clone.setWidth(this.bZO.aaL().getHeight());
        clone.setHeight(this.bZO.aaL().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(aaF, this.bZO.aaK(), clone, aaN.aaA(), aaN.aaB());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bZN = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bZN = cVar;
        }
        this.bZN.a(this.bZO.aaK(), this.bZO.aaL());
    }
}
