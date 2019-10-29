package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes2.dex */
public class c implements Cloneable, Comparable<c> {
    private int axn;
    private boolean axo;
    private EGLContext mEGLContext;
    private d awW = new d();
    private com.baidu.mario.gldraw2d.d.c awX = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a axj = new com.baidu.mario.gldraw2d.d.b();
    private a axk = new a();
    private boolean axl = false;
    private com.baidu.mario.gldraw2d.c.c awS = null;
    private b axm = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.axn = i;
        this.axo = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void b(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d xQ() {
        return this.awW;
    }

    public void c(d dVar) {
        this.awW = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c xR() {
        return this.awX;
    }

    public com.baidu.mario.gldraw2d.d.a xS() {
        return this.axj;
    }

    public a xT() {
        return this.axk;
    }

    public void a(a aVar) {
        this.axk = aVar;
    }

    public boolean xU() {
        return this.axl;
    }

    public com.baidu.mario.gldraw2d.c.c xV() {
        return this.awS;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.awS = cVar;
    }

    public b xW() {
        return this.axm;
    }

    public void a(b bVar) {
        this.axm = bVar;
    }

    public int xX() {
        return this.axn;
    }

    public boolean xY() {
        return this.axo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.axn < cVar.xX() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xZ */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.axk.clone());
            cVar.a(this.axm.clone());
        }
        return cVar;
    }
}
