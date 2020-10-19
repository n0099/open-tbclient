package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes5.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bIc;
    private c bId;
    private com.baidu.mario.gldraw2d.params.c bIe;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bIe = cVar;
        this.bIc = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ue();
    }

    public void Uc() {
        this.bId = this.bIe.UC();
        b(this.bId);
    }

    public com.baidu.mario.gldraw2d.b.a Ud() {
        return this.bIc;
    }

    public void aI(long j) {
        if (this.bId != null && this.bIe != null) {
            if (this.bIe.UB()) {
                Ue();
            }
            if (j != 0) {
                this.bIe.UD().setTimestamp(j);
            }
            this.bId.c(this.bIe.Uz(), this.bIe.UD());
        }
    }

    public void a(c cVar) {
        if (this.bIe != null) {
            this.bIe.c(cVar);
        }
        this.bId.release();
        b(cVar);
    }

    public void release() {
        if (this.bId != null) {
            this.bId.release();
            this.bId = null;
        }
        if (this.bIc != null) {
            this.bIc.release();
            this.bIc = null;
        }
    }

    private void Ue() {
        float[] Us = this.bIe.UD().Us();
        com.baidu.mario.gldraw2d.e.b.v(Us);
        com.baidu.mario.gldraw2d.params.a UA = this.bIe.UA();
        com.baidu.mario.gldraw2d.e.b.a(Us, UA.getTranslateX(), UA.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Us, UA.Um());
        com.baidu.mario.gldraw2d.e.b.a(Us, UA.Up());
        if ((UA.Uq() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Us, this.bIe.Ux(), this.bIe.Uy(), UA.Un(), UA.Uo());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bIe.Uy().clone();
        clone.setWidth(this.bIe.Uy().getHeight());
        clone.setHeight(this.bIe.Uy().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Us, this.bIe.Ux(), clone, UA.Un(), UA.Uo());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bId = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bId = cVar;
        }
        this.bId.a(this.bIe.Ux(), this.bIe.Uy());
    }
}
