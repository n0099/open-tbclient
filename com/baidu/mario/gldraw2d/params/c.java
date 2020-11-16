package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes6.dex */
public class c implements Cloneable, Comparable<c> {
    private int bUO;
    private boolean bUP;
    private EGLContext mEGLContext;
    private d bUA = new d();
    private com.baidu.mario.gldraw2d.d.c bUB = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bUK = new com.baidu.mario.gldraw2d.d.b();
    private a bUL = new a();
    private boolean bUM = false;
    private com.baidu.mario.gldraw2d.c.c bUy = null;
    private b bUN = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bUO = i;
        this.bUP = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d Yh() {
        return this.bUA;
    }

    public void c(d dVar) {
        this.bUA = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c Yi() {
        return this.bUB;
    }

    public com.baidu.mario.gldraw2d.d.a Yj() {
        return this.bUK;
    }

    public a Yk() {
        return this.bUL;
    }

    public void a(a aVar) {
        this.bUL = aVar;
    }

    public boolean Yl() {
        return this.bUM;
    }

    public com.baidu.mario.gldraw2d.c.c Ym() {
        return this.bUy;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bUy = cVar;
    }

    public b Yn() {
        return this.bUN;
    }

    public void a(b bVar) {
        this.bUN = bVar;
    }

    public int Yo() {
        return this.bUO;
    }

    public boolean Yp() {
        return this.bUP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bUO < cVar.Yo() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Yq */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bUL.clone());
            cVar.a(this.bUN.clone());
        }
        return cVar;
    }
}
