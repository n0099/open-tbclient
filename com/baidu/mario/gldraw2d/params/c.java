package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable, Comparable<c> {
    private int bfF;
    private boolean bfG;
    private EGLContext mEGLContext;
    private d bfp = new d();
    private com.baidu.mario.gldraw2d.d.c bfq = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bfB = new com.baidu.mario.gldraw2d.d.b();
    private a bfC = new a();
    private boolean bfD = false;
    private com.baidu.mario.gldraw2d.c.c bfl = null;
    private b bfE = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bfF = i;
        this.bfG = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d IG() {
        return this.bfp;
    }

    public void c(d dVar) {
        this.bfp = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c IH() {
        return this.bfq;
    }

    public com.baidu.mario.gldraw2d.d.a II() {
        return this.bfB;
    }

    public a IJ() {
        return this.bfC;
    }

    public void a(a aVar) {
        this.bfC = aVar;
    }

    public boolean IK() {
        return this.bfD;
    }

    public com.baidu.mario.gldraw2d.c.c IL() {
        return this.bfl;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bfl = cVar;
    }

    public b IM() {
        return this.bfE;
    }

    public void a(b bVar) {
        this.bfE = bVar;
    }

    public int IN() {
        return this.bfF;
    }

    public boolean IO() {
        return this.bfG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bfF < cVar.IN() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: IP */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bfC.clone());
            cVar.a(this.bfE.clone());
        }
        return cVar;
    }
}
