package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bfk;
    private c bfl;
    private com.baidu.mario.gldraw2d.params.c bfm;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bfm = cVar;
        this.bfk = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Im();
    }

    public void Ik() {
        this.bfl = this.bfm.IL();
        b(this.bfl);
    }

    public com.baidu.mario.gldraw2d.b.a Il() {
        return this.bfk;
    }

    public void aA(long j) {
        if (this.bfl != null && this.bfm != null) {
            if (this.bfm.IK()) {
                Im();
            }
            if (j != 0) {
                this.bfm.IM().setTimestamp(j);
            }
            this.bfl.c(this.bfm.II(), this.bfm.IM());
        }
    }

    public void a(c cVar) {
        if (this.bfm != null) {
            this.bfm.c(cVar);
        }
        this.bfl.release();
        b(cVar);
    }

    public void release() {
        if (this.bfl != null) {
            this.bfl.release();
            this.bfl = null;
        }
        if (this.bfk != null) {
            this.bfk.release();
            this.bfk = null;
        }
    }

    private void Im() {
        float[] IB = this.bfm.IM().IB();
        com.baidu.mario.gldraw2d.e.b.u(IB);
        com.baidu.mario.gldraw2d.params.a IJ = this.bfm.IJ();
        com.baidu.mario.gldraw2d.e.b.a(IB, IJ.getTranslateX(), IJ.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(IB, IJ.Iv());
        com.baidu.mario.gldraw2d.e.b.a(IB, IJ.Iy());
        if ((IJ.Iz() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(IB, this.bfm.IG(), this.bfm.IH(), IJ.Iw(), IJ.Ix());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bfm.IH().clone();
        clone.setWidth(this.bfm.IH().getHeight());
        clone.setHeight(this.bfm.IH().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(IB, this.bfm.IG(), clone, IJ.Iw(), IJ.Ix());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bfl = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bfl = cVar;
        }
        this.bfl.a(this.bfm.IG(), this.bfm.IH());
    }
}
