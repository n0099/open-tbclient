package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes20.dex */
public class c implements Cloneable, Comparable<c> {
    private int byu;
    private boolean byv;
    private EGLContext mEGLContext;
    private d byg = new d();
    private com.baidu.mario.gldraw2d.d.c byh = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a byq = new com.baidu.mario.gldraw2d.d.b();
    private a byr = new a();
    private boolean bys = false;
    private com.baidu.mario.gldraw2d.c.c bye = null;
    private b byt = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.byu = i;
        this.byv = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d RN() {
        return this.byg;
    }

    public void c(d dVar) {
        this.byg = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c RO() {
        return this.byh;
    }

    public com.baidu.mario.gldraw2d.d.a RP() {
        return this.byq;
    }

    public a RQ() {
        return this.byr;
    }

    public void a(a aVar) {
        this.byr = aVar;
    }

    public boolean RR() {
        return this.bys;
    }

    public com.baidu.mario.gldraw2d.c.c RS() {
        return this.bye;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bye = cVar;
    }

    public b RT() {
        return this.byt;
    }

    public void a(b bVar) {
        this.byt = bVar;
    }

    public int RU() {
        return this.byu;
    }

    public boolean RV() {
        return this.byv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.byu < cVar.RU() ? -1 : 1;
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
            cVar.a(this.byr.clone());
            cVar.a(this.byt.clone());
        }
        return cVar;
    }
}
