package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes5.dex */
public class c implements Cloneable, Comparable<c> {
    private int bWy;
    private boolean bWz;
    private EGLContext mEGLContext;
    private d bWk = new d();
    private com.baidu.mario.gldraw2d.d.c bWl = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bWu = new com.baidu.mario.gldraw2d.d.b();
    private a bWv = new a();
    private boolean bWw = false;
    private com.baidu.mario.gldraw2d.c.c bWi = null;
    private b bWx = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bWy = i;
        this.bWz = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d YQ() {
        return this.bWk;
    }

    public void c(d dVar) {
        this.bWk = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c YR() {
        return this.bWl;
    }

    public com.baidu.mario.gldraw2d.d.a YS() {
        return this.bWu;
    }

    public a YT() {
        return this.bWv;
    }

    public void a(a aVar) {
        this.bWv = aVar;
    }

    public boolean YU() {
        return this.bWw;
    }

    public com.baidu.mario.gldraw2d.c.c YV() {
        return this.bWi;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bWi = cVar;
    }

    public b YW() {
        return this.bWx;
    }

    public void a(b bVar) {
        this.bWx = bVar;
    }

    public int YX() {
        return this.bWy;
    }

    public boolean YY() {
        return this.bWz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bWy < cVar.YX() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: YZ */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bWv.clone());
            cVar.a(this.bWx.clone());
        }
        return cVar;
    }
}
