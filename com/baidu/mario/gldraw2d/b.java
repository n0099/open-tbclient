package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a aJs;
    private c aJt;
    private com.baidu.mario.gldraw2d.params.c aJu;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.aJu = cVar;
        this.aJs = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ch();
    }

    public void setupFilter() {
        this.aJt = this.aJu.CG();
        b(this.aJt);
    }

    public com.baidu.mario.gldraw2d.b.a Cg() {
        return this.aJs;
    }

    public void U(long j) {
        if (this.aJt != null && this.aJu != null) {
            if (this.aJu.CF()) {
                Ch();
            }
            if (j != 0) {
                this.aJu.CH().setTimestamp(j);
            }
            this.aJt.c(this.aJu.CD(), this.aJu.CH());
        }
    }

    public void a(c cVar) {
        if (this.aJu != null) {
            this.aJu.c(cVar);
        }
        this.aJt.release();
        b(cVar);
    }

    public void release() {
        if (this.aJt != null) {
            this.aJt.release();
            this.aJt = null;
        }
        if (this.aJs != null) {
            this.aJs.release();
            this.aJs = null;
        }
    }

    private void Ch() {
        float[] Cw = this.aJu.CH().Cw();
        com.baidu.mario.gldraw2d.e.b.g(Cw);
        com.baidu.mario.gldraw2d.params.a CE = this.aJu.CE();
        com.baidu.mario.gldraw2d.e.b.b(Cw, CE.getTranslateX(), CE.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Cw, CE.Cq());
        com.baidu.mario.gldraw2d.e.b.c(Cw, CE.Ct());
        if ((CE.Cu() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Cw, this.aJu.CB(), this.aJu.CC(), CE.Cr(), CE.Cs());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.aJu.CC().clone();
        clone.setWidth(this.aJu.CC().getHeight());
        clone.setHeight(this.aJu.CC().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Cw, this.aJu.CB(), clone, CE.Cr(), CE.Cs());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.aJt = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.aJt = cVar;
        }
        this.aJt.a(this.aJu.CB(), this.aJu.CC());
    }
}
