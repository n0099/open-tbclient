package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes2.dex */
public class c implements Cloneable, Comparable<c> {
    private int awV;
    private boolean awW;
    private EGLContext mEGLContext;
    private d awE = new d();
    private com.baidu.mario.gldraw2d.d.c awF = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a awR = new com.baidu.mario.gldraw2d.d.b();
    private a awS = new a();
    private boolean awT = false;
    private com.baidu.mario.gldraw2d.c.c awA = null;
    private b awU = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.awV = i;
        this.awW = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void b(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d xR() {
        return this.awE;
    }

    public void c(d dVar) {
        this.awE = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c xS() {
        return this.awF;
    }

    public com.baidu.mario.gldraw2d.d.a xT() {
        return this.awR;
    }

    public a xU() {
        return this.awS;
    }

    public void a(a aVar) {
        this.awS = aVar;
    }

    public boolean xV() {
        return this.awT;
    }

    public com.baidu.mario.gldraw2d.c.c xW() {
        return this.awA;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.awA = cVar;
    }

    public b xX() {
        return this.awU;
    }

    public void a(b bVar) {
        this.awU = bVar;
    }

    public int xY() {
        return this.awV;
    }

    public boolean xZ() {
        return this.awW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.awV < cVar.xY() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ya */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.awS.clone());
            cVar.a(this.awU.clone());
        }
        return cVar;
    }
}
