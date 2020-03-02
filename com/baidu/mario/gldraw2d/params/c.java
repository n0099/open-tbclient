package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable, Comparable<c> {
    private int aJy;
    private boolean aJz;
    private EGLContext mEGLContext;
    private d aJi = new d();
    private com.baidu.mario.gldraw2d.d.c aJj = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a aJu = new com.baidu.mario.gldraw2d.d.b();
    private a aJv = new a();
    private boolean aJw = false;
    private com.baidu.mario.gldraw2d.c.c aJe = null;
    private b aJx = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.aJy = i;
        this.aJz = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void b(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d Cu() {
        return this.aJi;
    }

    public void c(d dVar) {
        this.aJi = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c Cv() {
        return this.aJj;
    }

    public com.baidu.mario.gldraw2d.d.a Cw() {
        return this.aJu;
    }

    public a Cx() {
        return this.aJv;
    }

    public void a(a aVar) {
        this.aJv = aVar;
    }

    public boolean Cy() {
        return this.aJw;
    }

    public com.baidu.mario.gldraw2d.c.c Cz() {
        return this.aJe;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.aJe = cVar;
    }

    public b CA() {
        return this.aJx;
    }

    public void a(b bVar) {
        this.aJx = bVar;
    }

    public int CB() {
        return this.aJy;
    }

    public boolean CC() {
        return this.aJz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.aJy < cVar.CB() ? -1 : 1;
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
            cVar.a(this.aJv.clone());
            cVar.a(this.aJx.clone());
        }
        return cVar;
    }
}
