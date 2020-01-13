package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes10.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a aEW;
    private c aEX;
    private com.baidu.mario.gldraw2d.params.c aEY;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.aEY = cVar;
        this.aEW = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        zI();
    }

    public void setupFilter() {
        this.aEX = this.aEY.Ah();
        b(this.aEX);
    }

    public com.baidu.mario.gldraw2d.b.a zH() {
        return this.aEW;
    }

    public void Q(long j) {
        if (this.aEX != null && this.aEY != null) {
            if (this.aEY.Ag()) {
                zI();
            }
            if (j != 0) {
                this.aEY.Ai().setTimestamp(j);
            }
            this.aEX.c(this.aEY.Ae(), this.aEY.Ai());
        }
    }

    public void a(c cVar) {
        if (this.aEY != null) {
            this.aEY.c(cVar);
        }
        this.aEX.release();
        b(cVar);
    }

    public void release() {
        if (this.aEX != null) {
            this.aEX.release();
            this.aEX = null;
        }
        if (this.aEW != null) {
            this.aEW.release();
            this.aEW = null;
        }
    }

    private void zI() {
        float[] zX = this.aEY.Ai().zX();
        com.baidu.mario.gldraw2d.e.b.g(zX);
        com.baidu.mario.gldraw2d.params.a Af = this.aEY.Af();
        com.baidu.mario.gldraw2d.e.b.b(zX, Af.getTranslateX(), Af.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(zX, Af.zR());
        com.baidu.mario.gldraw2d.e.b.c(zX, Af.zU());
        if ((Af.zV() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(zX, this.aEY.Ac(), this.aEY.Ad(), Af.zS(), Af.zT());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.aEY.Ad().clone();
        clone.setWidth(this.aEY.Ad().getHeight());
        clone.setHeight(this.aEY.Ad().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(zX, this.aEY.Ac(), clone, Af.zS(), Af.zT());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.aEX = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.aEX = cVar;
        }
        this.aEX.a(this.aEY.Ac(), this.aEY.Ad());
    }
}
