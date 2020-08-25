package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes20.dex */
public class c implements Cloneable, Comparable<c> {
    private int byr;
    private boolean bys;
    private EGLContext mEGLContext;
    private d byd = new d();
    private com.baidu.mario.gldraw2d.d.c bye = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a byn = new com.baidu.mario.gldraw2d.d.b();
    private a byo = new a();
    private boolean byp = false;
    private com.baidu.mario.gldraw2d.c.c byb = null;
    private b byq = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.byr = i;
        this.bys = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d RN() {
        return this.byd;
    }

    public void c(d dVar) {
        this.byd = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c RO() {
        return this.bye;
    }

    public com.baidu.mario.gldraw2d.d.a RP() {
        return this.byn;
    }

    public a RQ() {
        return this.byo;
    }

    public void a(a aVar) {
        this.byo = aVar;
    }

    public boolean RR() {
        return this.byp;
    }

    public com.baidu.mario.gldraw2d.c.c RS() {
        return this.byb;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.byb = cVar;
    }

    public b RT() {
        return this.byq;
    }

    public void a(b bVar) {
        this.byq = bVar;
    }

    public int RU() {
        return this.byr;
    }

    public boolean RV() {
        return this.bys;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.byr < cVar.RU() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: RW */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.byo.clone());
            cVar.a(this.byq.clone());
        }
        return cVar;
    }
}
