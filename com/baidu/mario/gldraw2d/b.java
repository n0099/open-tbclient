package com.baidu.mario.gldraw2d;

import com.baidu.mario.gldraw2d.c.c;
/* loaded from: classes9.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.b.a aEe;
    private c aEf;
    private com.baidu.mario.gldraw2d.params.c aEg;

    public b(com.baidu.mario.gldraw2d.params.c cVar) {
        this.aEg = cVar;
        this.aEe = new com.baidu.mario.gldraw2d.b.a(cVar.getEGLContext(), 1);
        zm();
    }

    public void setupFilter() {
        this.aEf = this.aEg.zL();
        b(this.aEf);
    }

    public com.baidu.mario.gldraw2d.b.a zl() {
        return this.aEe;
    }

    public void N(long j) {
        if (this.aEf != null && this.aEg != null) {
            if (this.aEg.zK()) {
                zm();
            }
            if (j != 0) {
                this.aEg.zM().setTimestamp(j);
            }
            this.aEf.c(this.aEg.zI(), this.aEg.zM());
        }
    }

    public void a(c cVar) {
        if (this.aEg != null) {
            this.aEg.c(cVar);
        }
        this.aEf.release();
        b(cVar);
    }

    public void release() {
        if (this.aEf != null) {
            this.aEf.release();
            this.aEf = null;
        }
        if (this.aEe != null) {
            this.aEe.release();
            this.aEe = null;
        }
    }

    private void zm() {
        float[] zB = this.aEg.zM().zB();
        com.baidu.mario.gldraw2d.e.b.g(zB);
        com.baidu.mario.gldraw2d.params.a zJ = this.aEg.zJ();
        com.baidu.mario.gldraw2d.e.b.b(zB, zJ.getTranslateX(), zJ.getTranslateY());
        com.baidu.mario.gldraw2d.e.b.a(zB, zJ.zv());
        com.baidu.mario.gldraw2d.e.b.c(zB, zJ.zy());
        if ((zJ.zz() + 360) % 180 == 0) {
            com.baidu.mario.gldraw2d.e.b.a(zB, this.aEg.zG(), this.aEg.zH(), zJ.zw(), zJ.zx());
            return;
        }
        com.baidu.mario.gldraw2d.d.c clone = this.aEg.zH().clone();
        clone.setWidth(this.aEg.zH().getHeight());
        clone.setHeight(this.aEg.zH().getWidth());
        com.baidu.mario.gldraw2d.e.b.a(zB, this.aEg.zG(), clone, zJ.zw(), zJ.zx());
    }

    private void b(c cVar) {
        if (cVar == null) {
            this.aEf = new com.baidu.mario.gldraw2d.c.b();
        } else {
            this.aEf = cVar;
        }
        this.aEf.a(this.aEg.zG(), this.aEg.zH());
    }
}
