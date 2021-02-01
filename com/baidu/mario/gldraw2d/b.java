package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes15.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a cfS;
    private c cfT;
    private com.baidu.mario.gldraw2d.params.c cfU;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.cfU = cVar;
        this.cfS = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        aag();
    }

    public void aae() {
        this.cfT = this.cfU.aaB();
        b(this.cfT);
    }

    public com.baidu.mario.gldraw2d.b.a aaf() {
        return this.cfS;
    }

    public void bI(long j) {
        if (this.cfT != null && this.cfU != null) {
            if (this.cfU.aaA()) {
                aag();
            }
            if (j != 0) {
                this.cfU.aaC().setTimestamp(j);
            }
            this.cfT.c(this.cfU.aay(), this.cfU.aaC());
        }
    }

    public void a(c cVar) {
        if (this.cfU != null) {
            this.cfU.c(cVar);
        }
        this.cfT.release();
        b(cVar);
    }

    public void release() {
        if (this.cfT != null) {
            this.cfT.release();
            this.cfT = null;
        }
        if (this.cfS != null) {
            this.cfS.release();
            this.cfS = null;
        }
    }

    private void aag() {
        float[] mVPMatrix = this.cfU.aaC().getMVPMatrix();
        com.baidu.mario.gldraw2d.e.b.u(mVPMatrix);
        com.baidu.mario.gldraw2d.params.a aaz = this.cfU.aaz();
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, aaz.getTranslateX(), aaz.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, aaz.aam());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, aaz.aap());
        if ((aaz.aaq() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.cfU.aaw(), this.cfU.aax(), aaz.aan(), aaz.aao());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.cfU.aax().clone();
        clone.setWidth(this.cfU.aax().getHeight());
        clone.setHeight(this.cfU.aax().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.cfU.aaw(), clone, aaz.aan(), aaz.aao());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.cfT = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.cfT = cVar;
        }
        this.cfT.a(this.cfU.aaw(), this.cfU.aax());
    }
}
