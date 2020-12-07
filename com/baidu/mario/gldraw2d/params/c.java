package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes14.dex */
public class c implements Cloneable, Comparable<c> {
    private int cad;
    private boolean cae;
    private EGLContext mEGLContext;
    private d bZP = new d();
    private com.baidu.mario.gldraw2d.d.c bZQ = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bZZ = new com.baidu.mario.gldraw2d.d.b();
    private a caa = new a();
    private boolean cab = false;
    private com.baidu.mario.gldraw2d.c.c bZN = null;
    private b cac = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.cad = i;
        this.cae = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d aaK() {
        return this.bZP;
    }

    public void c(d dVar) {
        this.bZP = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c aaL() {
        return this.bZQ;
    }

    public com.baidu.mario.gldraw2d.d.a aaM() {
        return this.bZZ;
    }

    public a aaN() {
        return this.caa;
    }

    public void a(a aVar) {
        this.caa = aVar;
    }

    public boolean aaO() {
        return this.cab;
    }

    public com.baidu.mario.gldraw2d.c.c aaP() {
        return this.bZN;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bZN = cVar;
    }

    public b aaQ() {
        return this.cac;
    }

    public void a(b bVar) {
        this.cac = bVar;
    }

    public int aaR() {
        return this.cad;
    }

    public boolean aaS() {
        return this.cae;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.cad < cVar.aaR() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aaT */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.caa.clone());
            cVar.a(this.cac.clone());
        }
        return cVar;
    }
}
