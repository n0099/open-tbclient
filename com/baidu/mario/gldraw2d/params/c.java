package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable, Comparable<c> {
    private int bfK;
    private boolean bfL;
    private EGLContext mEGLContext;
    private d bfv = new d();
    private com.baidu.mario.gldraw2d.d.c bfw = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bfG = new com.baidu.mario.gldraw2d.d.b();
    private a bfH = new a();
    private boolean bfI = false;
    private com.baidu.mario.gldraw2d.c.c bfq = null;
    private b bfJ = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bfK = i;
        this.bfL = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d IF() {
        return this.bfv;
    }

    public void c(d dVar) {
        this.bfv = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c IG() {
        return this.bfw;
    }

    public com.baidu.mario.gldraw2d.d.a IH() {
        return this.bfG;
    }

    public a II() {
        return this.bfH;
    }

    public void a(a aVar) {
        this.bfH = aVar;
    }

    public boolean IJ() {
        return this.bfI;
    }

    public com.baidu.mario.gldraw2d.c.c IK() {
        return this.bfq;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bfq = cVar;
    }

    public b IL() {
        return this.bfJ;
    }

    public void a(b bVar) {
        this.bfJ = bVar;
    }

    public int IM() {
        return this.bfK;
    }

    public boolean IN() {
        return this.bfL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bfK < cVar.IM() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: IO */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bfH.clone());
            cVar.a(this.bfJ.clone());
        }
        return cVar;
    }
}
