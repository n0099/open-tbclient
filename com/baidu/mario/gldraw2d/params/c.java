package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes2.dex */
public class c implements Cloneable, Comparable<c> {
    private int ads;
    private boolean adt;
    private EGLContext mEGLContext;
    private d ada = new d();
    private com.baidu.mario.gldraw2d.d.c adb = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a ado = new com.baidu.mario.gldraw2d.d.b();
    private a adp = new a();
    private boolean adq = false;
    private com.baidu.mario.gldraw2d.c.c acW = null;
    private b adr = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.ads = i;
        this.adt = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void c(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d sx() {
        return this.ada;
    }

    public void c(d dVar) {
        this.ada = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c sy() {
        return this.adb;
    }

    public com.baidu.mario.gldraw2d.d.a sz() {
        return this.ado;
    }

    public a sA() {
        return this.adp;
    }

    public void a(a aVar) {
        this.adp = aVar;
    }

    public boolean sB() {
        return this.adq;
    }

    public com.baidu.mario.gldraw2d.c.c sC() {
        return this.acW;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.acW = cVar;
    }

    public b sD() {
        return this.adr;
    }

    public void a(b bVar) {
        this.adr = bVar;
    }

    public int sE() {
        return this.ads;
    }

    public boolean sF() {
        return this.adt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.ads < cVar.sE() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: sG */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.adp.clone());
            cVar.a(this.adr.clone());
        }
        return cVar;
    }
}
