package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a bmP;
    private c bmQ;
    private com.baidu.mario.gldraw2d.params.c bmR;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.bmR = cVar;
        this.bmP = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ke();
    }

    public void Kc() {
        this.bmQ = this.bmR.KD();
        b(this.bmQ);
    }

    public com.baidu.mario.gldraw2d.b.a Kd() {
        return this.bmP;
    }

    public void aF(long j) {
        if (this.bmQ != null && this.bmR != null) {
            if (this.bmR.KC()) {
                Ke();
            }
            if (j != 0) {
                this.bmR.KE().setTimestamp(j);
            }
            this.bmQ.c(this.bmR.KA(), this.bmR.KE());
        }
    }

    public void a(c cVar) {
        if (this.bmR != null) {
            this.bmR.c(cVar);
        }
        this.bmQ.release();
        b(cVar);
    }

    public void release() {
        if (this.bmQ != null) {
            this.bmQ.release();
            this.bmQ = null;
        }
        if (this.bmP != null) {
            this.bmP.release();
            this.bmP = null;
        }
    }

    private void Ke() {
        float[] Kt = this.bmR.KE().Kt();
        com.baidu.mario.gldraw2d.e.b.u(Kt);
        com.baidu.mario.gldraw2d.params.a KB = this.bmR.KB();
        com.baidu.mario.gldraw2d.e.b.a(Kt, KB.getTranslateX(), KB.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(Kt, KB.Kn());
        com.baidu.mario.gldraw2d.e.b.a(Kt, KB.Kq());
        if ((KB.Kr() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(Kt, this.bmR.Ky(), this.bmR.Kz(), KB.Ko(), KB.Kp());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.bmR.Kz().clone();
        clone.setWidth(this.bmR.Kz().getHeight());
        clone.setHeight(this.bmR.Kz().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(Kt, this.bmR.Ky(), clone, KB.Ko(), KB.Kp());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.bmQ = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.bmQ = cVar;
        }
        this.bmQ.a(this.bmR.Ky(), this.bmR.Kz());
    }
}
