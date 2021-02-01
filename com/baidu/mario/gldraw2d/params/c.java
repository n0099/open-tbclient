package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes15.dex */
public class c implements Cloneable, Comparable<c> {
    private int cgj;
    private boolean cgk;
    private EGLContext mEGLContext;
    private d cfV = new d();
    private com.baidu.mario.gldraw2d.d.c cfW = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a cgf = new com.baidu.mario.gldraw2d.d.b();
    private a cgg = new a();
    private boolean cgh = false;
    private com.baidu.mario.gldraw2d.c.c cfT = null;
    private b cgi = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.cgj = i;
        this.cgk = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d aaw() {
        return this.cfV;
    }

    public void c(d dVar) {
        this.cfV = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c aax() {
        return this.cfW;
    }

    public com.baidu.mario.gldraw2d.d.a aay() {
        return this.cgf;
    }

    public a aaz() {
        return this.cgg;
    }

    public void a(a aVar) {
        this.cgg = aVar;
    }

    public boolean aaA() {
        return this.cgh;
    }

    public com.baidu.mario.gldraw2d.c.c aaB() {
        return this.cfT;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.cfT = cVar;
    }

    public b aaC() {
        return this.cgi;
    }

    public void a(b bVar) {
        this.cgi = bVar;
    }

    public int aaD() {
        return this.cgj;
    }

    public boolean aaE() {
        return this.cgk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.cgj < cVar.aaD() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aaF */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.cgg.clone());
            cVar.a(this.cgi.clone());
        }
        return cVar;
    }
}
