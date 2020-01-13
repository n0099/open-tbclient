package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes10.dex */
public class c implements Cloneable, Comparable<c> {
    private int aFr;
    private boolean aFs;
    private EGLContext mEGLContext;
    private d aFb = new d();
    private com.baidu.mario.gldraw2d.d.c aFc = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a aFn = new com.baidu.mario.gldraw2d.d.b();
    private a aFo = new a();
    private boolean aFp = false;
    private com.baidu.mario.gldraw2d.c.c aEX = null;
    private b aFq = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.aFr = i;
        this.aFs = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void b(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d Ac() {
        return this.aFb;
    }

    public void c(d dVar) {
        this.aFb = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c Ad() {
        return this.aFc;
    }

    public com.baidu.mario.gldraw2d.d.a Ae() {
        return this.aFn;
    }

    public a Af() {
        return this.aFo;
    }

    public void a(a aVar) {
        this.aFo = aVar;
    }

    public boolean Ag() {
        return this.aFp;
    }

    public com.baidu.mario.gldraw2d.c.c Ah() {
        return this.aEX;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.aEX = cVar;
    }

    public b Ai() {
        return this.aFq;
    }

    public void a(b bVar) {
        this.aFq = bVar;
    }

    public int Aj() {
        return this.aFr;
    }

    public boolean Ak() {
        return this.aFs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.aFr < cVar.Aj() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Al */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.aFo.clone());
            cVar.a(this.aFq.clone());
        }
        return cVar;
    }
}
