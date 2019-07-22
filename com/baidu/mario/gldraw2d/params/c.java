package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes2.dex */
public class c implements Cloneable, Comparable<c> {
    private int adP;
    private boolean adQ;
    private EGLContext mEGLContext;
    private d ady = new d();
    private com.baidu.mario.gldraw2d.d.c adz = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a adL = new com.baidu.mario.gldraw2d.d.b();
    private a adM = new a();
    private boolean adN = false;
    private com.baidu.mario.gldraw2d.c.c adu = null;
    private b adO = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.adP = i;
        this.adQ = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void c(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d sV() {
        return this.ady;
    }

    public void c(d dVar) {
        this.ady = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c sW() {
        return this.adz;
    }

    public com.baidu.mario.gldraw2d.d.a sX() {
        return this.adL;
    }

    public a sY() {
        return this.adM;
    }

    public void a(a aVar) {
        this.adM = aVar;
    }

    public boolean sZ() {
        return this.adN;
    }

    public com.baidu.mario.gldraw2d.c.c ta() {
        return this.adu;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.adu = cVar;
    }

    public b tb() {
        return this.adO;
    }

    public void a(b bVar) {
        this.adO = bVar;
    }

    public int tc() {
        return this.adP;
    }

    public boolean td() {
        return this.adQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.adP < cVar.tc() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: te */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.adM.clone());
            cVar.a(this.adO.clone());
        }
        return cVar;
    }
}
