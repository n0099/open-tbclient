package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable, Comparable<c> {
    private int aJN;
    private boolean aJO;
    private EGLContext mEGLContext;
    private d aJx = new d();
    private com.baidu.mario.gldraw2d.d.c aJy = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a aJJ = new com.baidu.mario.gldraw2d.d.b();
    private a aJK = new a();
    private boolean aJL = false;
    private com.baidu.mario.gldraw2d.c.c aJt = null;
    private b aJM = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.aJN = i;
        this.aJO = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void b(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d CB() {
        return this.aJx;
    }

    public void c(d dVar) {
        this.aJx = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c CC() {
        return this.aJy;
    }

    public com.baidu.mario.gldraw2d.d.a CD() {
        return this.aJJ;
    }

    public a CE() {
        return this.aJK;
    }

    public void a(a aVar) {
        this.aJK = aVar;
    }

    public boolean CF() {
        return this.aJL;
    }

    public com.baidu.mario.gldraw2d.c.c CG() {
        return this.aJt;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.aJt = cVar;
    }

    public b CH() {
        return this.aJM;
    }

    public void a(b bVar) {
        this.aJM = bVar;
    }

    public int CI() {
        return this.aJN;
    }

    public boolean CJ() {
        return this.aJO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.aJN < cVar.CI() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: CK */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.aJK.clone());
            cVar.a(this.aJM.clone());
        }
        return cVar;
    }
}
