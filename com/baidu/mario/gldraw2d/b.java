package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a brP;
    private c brQ;
    private com.baidu.mario.gldraw2d.params.c brR;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.brR = cVar;
        this.brP = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        Ln();
    }

    public void Ll() {
        this.brQ = this.brR.LM();
        b(this.brQ);
    }

    public com.baidu.mario.gldraw2d.b.a Lm() {
        return this.brP;
    }

    public void aF(long j) {
        if (this.brQ != null && this.brR != null) {
            if (this.brR.LL()) {
                Ln();
            }
            if (j != 0) {
                this.brR.LN().setTimestamp(j);
            }
            this.brQ.c(this.brR.LJ(), this.brR.LN());
        }
    }

    public void a(c cVar) {
        if (this.brR != null) {
            this.brR.c(cVar);
        }
        this.brQ.release();
        b(cVar);
    }

    public void release() {
        if (this.brQ != null) {
            this.brQ.release();
            this.brQ = null;
        }
        if (this.brP != null) {
            this.brP.release();
            this.brP = null;
        }
    }

    private void Ln() {
        float[] LC = this.brR.LN().LC();
        com.baidu.mario.gldraw2d.e.b.v(LC);
        com.baidu.mario.gldraw2d.params.a LK = this.brR.LK();
        com.baidu.mario.gldraw2d.e.b.a(LC, LK.getTranslateX(), LK.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(LC, LK.Lw());
        com.baidu.mario.gldraw2d.e.b.a(LC, LK.Lz());
        if ((LK.LA() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(LC, this.brR.LH(), this.brR.LI(), LK.Lx(), LK.Ly());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.brR.LI().clone();
        clone.setWidth(this.brR.LI().getHeight());
        clone.setHeight(this.brR.LI().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(LC, this.brR.LH(), clone, LK.Lx(), LK.Ly());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.brQ = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.brQ = cVar;
        }
        this.brQ.a(this.brR.LH(), this.brR.LI());
    }
}
