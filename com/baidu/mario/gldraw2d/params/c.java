package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes9.dex */
public class c implements Cloneable, Comparable<c> {
    private boolean aEA;
    private int aEz;
    private EGLContext mEGLContext;
    private d aEj = new d();
    private com.baidu.mario.gldraw2d.d.c aEk = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a aEv = new com.baidu.mario.gldraw2d.d.b();
    private a aEw = new a();
    private boolean aEx = false;
    private com.baidu.mario.gldraw2d.c.c aEf = null;
    private b aEy = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.aEz = i;
        this.aEA = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void b(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d zG() {
        return this.aEj;
    }

    public void c(d dVar) {
        this.aEj = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c zH() {
        return this.aEk;
    }

    public com.baidu.mario.gldraw2d.d.a zI() {
        return this.aEv;
    }

    public a zJ() {
        return this.aEw;
    }

    public void a(a aVar) {
        this.aEw = aVar;
    }

    public boolean zK() {
        return this.aEx;
    }

    public com.baidu.mario.gldraw2d.c.c zL() {
        return this.aEf;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.aEf = cVar;
    }

    public b zM() {
        return this.aEy;
    }

    public void a(b bVar) {
        this.aEy = bVar;
    }

    public int zN() {
        return this.aEz;
    }

    public boolean zO() {
        return this.aEA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.aEz < cVar.zN() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: zP */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.aEw.clone());
            cVar.a(this.aEy.clone());
        }
        return cVar;
    }
}
