package com.baidu.mario.gldraw2d;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes14.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a cbH;
    private c cbI;
    private com.baidu.mario.gldraw2d.params.c cbJ;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.cbJ = cVar;
        this.cbH = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ym();
    }

    public void Yk() {
        this.cbI = this.cbJ.YI();
        b(this.cbI);
    }

    public com.baidu.mario.gldraw2d.b.a Yl() {
        return this.cbH;
    }

    public void bE(long j) {
        if (this.cbI != null && this.cbJ != null) {
            if (this.cbJ.YH()) {
                Ym();
            }
            if (j != 0) {
                this.cbJ.YJ().setTimestamp(j);
            }
            this.cbI.c(this.cbJ.YF(), this.cbJ.YJ());
        }
    }

    public void a(c cVar) {
        if (this.cbJ != null) {
            this.cbJ.c(cVar);
        }
        this.cbI.release();
        b(cVar);
    }

    public void release() {
        if (this.cbI != null) {
            this.cbI.release();
            this.cbI = null;
        }
        if (this.cbH != null) {
            this.cbH.release();
            this.cbH = null;
        }
    }

    private void Ym() {
        float[] mVPMatrix = this.cbJ.YJ().getMVPMatrix();
        com.baidu.mario.gldraw2d.e.b.u(mVPMatrix);
        com.baidu.mario.gldraw2d.params.a YG = this.cbJ.YG();
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, YG.getTranslateX(), YG.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, YG.Yt());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, YG.Yw());
        if ((YG.Yx() + EncoderTextureDrawer.X264_WIDTH) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.cbJ.YD(), this.cbJ.YE(), YG.Yu(), YG.Yv());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.cbJ.YE().clone();
        clone.setWidth(this.cbJ.YE().getHeight());
        clone.setHeight(this.cbJ.YE().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(mVPMatrix, this.cbJ.YD(), clone, YG.Yu(), YG.Yv());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.cbI = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.cbI = cVar;
        }
        this.cbI.a(this.cbJ.YD(), this.cbJ.YE());
    }
}
