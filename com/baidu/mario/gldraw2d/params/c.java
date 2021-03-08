package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes14.dex */
public class c implements Cloneable, Comparable<c> {
    private int chJ;
    private boolean chK;
    private EGLContext mEGLContext;
    private d chv = new d();
    private com.baidu.mario.gldraw2d.d.c chw = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a chF = new com.baidu.mario.gldraw2d.d.b();
    private a chG = new a();
    private boolean chH = false;
    private com.baidu.mario.gldraw2d.c.c cht = null;
    private b chI = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.chJ = i;
        this.chK = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d aaz() {
        return this.chv;
    }

    public void c(d dVar) {
        this.chv = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c aaA() {
        return this.chw;
    }

    public com.baidu.mario.gldraw2d.d.a aaB() {
        return this.chF;
    }

    public a aaC() {
        return this.chG;
    }

    public void a(a aVar) {
        this.chG = aVar;
    }

    public boolean aaD() {
        return this.chH;
    }

    public com.baidu.mario.gldraw2d.c.c aaE() {
        return this.cht;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.cht = cVar;
    }

    public b aaF() {
        return this.chI;
    }

    public void a(b bVar) {
        this.chI = bVar;
    }

    public int aaG() {
        return this.chJ;
    }

    public boolean aaH() {
        return this.chK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.chJ < cVar.aaG() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aaI */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.chG.clone());
            cVar.a(this.chI.clone());
        }
        return cVar;
    }
}
