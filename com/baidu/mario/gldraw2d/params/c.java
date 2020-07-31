package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes10.dex */
public class c implements Cloneable, Comparable<c> {
    private int bsE;
    private boolean bsF;
    private EGLContext mEGLContext;
    private d bsp = new d();
    private com.baidu.mario.gldraw2d.d.c bsq = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bsA = new com.baidu.mario.gldraw2d.d.b();
    private a bsB = new a();
    private boolean bsC = false;
    private com.baidu.mario.gldraw2d.c.c bsl = null;
    private b bsD = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bsE = i;
        this.bsF = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d LO() {
        return this.bsp;
    }

    public void c(d dVar) {
        this.bsp = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c LP() {
        return this.bsq;
    }

    public com.baidu.mario.gldraw2d.d.a LQ() {
        return this.bsA;
    }

    public a LR() {
        return this.bsB;
    }

    public void a(a aVar) {
        this.bsB = aVar;
    }

    public boolean LS() {
        return this.bsC;
    }

    public com.baidu.mario.gldraw2d.c.c LT() {
        return this.bsl;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bsl = cVar;
    }

    public b LU() {
        return this.bsD;
    }

    public void a(b bVar) {
        this.bsD = bVar;
    }

    public int LV() {
        return this.bsE;
    }

    public boolean LW() {
        return this.bsF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bsE < cVar.LV() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: LX */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bsB.clone());
            cVar.a(this.bsD.clone());
        }
        return cVar;
    }
}
