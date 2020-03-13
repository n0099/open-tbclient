package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable, Comparable<c> {
    private boolean aJA;
    private int aJz;
    private EGLContext mEGLContext;
    private d aJj = new d();
    private com.baidu.mario.gldraw2d.d.c aJk = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a aJv = new com.baidu.mario.gldraw2d.d.b();
    private a aJw = new a();
    private boolean aJx = false;
    private com.baidu.mario.gldraw2d.c.c aJf = null;
    private b aJy = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.aJz = i;
        this.aJA = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void b(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d Cu() {
        return this.aJj;
    }

    public void c(d dVar) {
        this.aJj = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c Cv() {
        return this.aJk;
    }

    public com.baidu.mario.gldraw2d.d.a Cw() {
        return this.aJv;
    }

    public a Cx() {
        return this.aJw;
    }

    public void a(a aVar) {
        this.aJw = aVar;
    }

    public boolean Cy() {
        return this.aJx;
    }

    public com.baidu.mario.gldraw2d.c.c Cz() {
        return this.aJf;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.aJf = cVar;
    }

    public b CA() {
        return this.aJy;
    }

    public void a(b bVar) {
        this.aJy = bVar;
    }

    public int CB() {
        return this.aJz;
    }

    public boolean CC() {
        return this.aJA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.aJz < cVar.CB() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: CD */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.aJw.clone());
            cVar.a(this.aJy.clone());
        }
        return cVar;
    }
}
