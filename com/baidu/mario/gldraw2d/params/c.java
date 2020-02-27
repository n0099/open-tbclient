package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable, Comparable<c> {
    private int aJx;
    private boolean aJy;
    private EGLContext mEGLContext;
    private d aJh = new d();
    private com.baidu.mario.gldraw2d.d.c aJi = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a aJt = new com.baidu.mario.gldraw2d.d.b();
    private a aJu = new a();
    private boolean aJv = false;
    private com.baidu.mario.gldraw2d.c.c aJd = null;
    private b aJw = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.aJx = i;
        this.aJy = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void b(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d Cs() {
        return this.aJh;
    }

    public void c(d dVar) {
        this.aJh = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c Ct() {
        return this.aJi;
    }

    public com.baidu.mario.gldraw2d.d.a Cu() {
        return this.aJt;
    }

    public a Cv() {
        return this.aJu;
    }

    public void a(a aVar) {
        this.aJu = aVar;
    }

    public boolean Cw() {
        return this.aJv;
    }

    public com.baidu.mario.gldraw2d.c.c Cx() {
        return this.aJd;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.aJd = cVar;
    }

    public b Cy() {
        return this.aJw;
    }

    public void a(b bVar) {
        this.aJw = bVar;
    }

    public int Cz() {
        return this.aJx;
    }

    public boolean CA() {
        return this.aJy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.aJx < cVar.Cz() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: CB */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.aJu.clone());
            cVar.a(this.aJw.clone());
        }
        return cVar;
    }
}
