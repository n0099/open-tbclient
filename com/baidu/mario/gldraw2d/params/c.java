package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes3.dex */
public class c implements Cloneable, Comparable<c> {
    private int cgN;
    private boolean cgO;
    private EGLContext mEGLContext;
    private d cgz = new d();
    private com.baidu.mario.gldraw2d.d.c cgA = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a cgJ = new com.baidu.mario.gldraw2d.d.b();
    private a cgK = new a();
    private boolean cgL = false;
    private com.baidu.mario.gldraw2d.c.c cgx = null;
    private b cgM = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.cgN = i;
        this.cgO = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d acw() {
        return this.cgz;
    }

    public void c(d dVar) {
        this.cgz = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c acx() {
        return this.cgA;
    }

    public com.baidu.mario.gldraw2d.d.a acy() {
        return this.cgJ;
    }

    public a acz() {
        return this.cgK;
    }

    public void a(a aVar) {
        this.cgK = aVar;
    }

    public boolean acA() {
        return this.cgL;
    }

    public com.baidu.mario.gldraw2d.c.c acB() {
        return this.cgx;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.cgx = cVar;
    }

    public b acC() {
        return this.cgM;
    }

    public void a(b bVar) {
        this.cgM = bVar;
    }

    public int acD() {
        return this.cgN;
    }

    public boolean acE() {
        return this.cgO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.cgN < cVar.acD() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: acF */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.cgK.clone());
            cVar.a(this.cgM.clone());
        }
        return cVar;
    }
}
