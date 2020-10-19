package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes5.dex */
public class c implements Cloneable, Comparable<c> {
    private int bIt;
    private boolean bIu;
    private EGLContext mEGLContext;
    private d bIf = new d();
    private com.baidu.mario.gldraw2d.d.c bIg = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bIp = new com.baidu.mario.gldraw2d.d.b();
    private a bIq = new a();
    private boolean bIr = false;
    private com.baidu.mario.gldraw2d.c.c bId = null;
    private b bIs = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bIt = i;
        this.bIu = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d Ux() {
        return this.bIf;
    }

    public void c(d dVar) {
        this.bIf = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c Uy() {
        return this.bIg;
    }

    public com.baidu.mario.gldraw2d.d.a Uz() {
        return this.bIp;
    }

    public a UA() {
        return this.bIq;
    }

    public void a(a aVar) {
        this.bIq = aVar;
    }

    public boolean UB() {
        return this.bIr;
    }

    public com.baidu.mario.gldraw2d.c.c UC() {
        return this.bId;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bId = cVar;
    }

    public b UD() {
        return this.bIs;
    }

    public void a(b bVar) {
        this.bIs = bVar;
    }

    public int UE() {
        return this.bIt;
    }

    public boolean UF() {
        return this.bIu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bIt < cVar.UE() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: UG */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bIq.clone());
            cVar.a(this.bIs.clone());
        }
        return cVar;
    }
}
