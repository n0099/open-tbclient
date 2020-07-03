package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable, Comparable<c> {
    private int bsj;
    private boolean bsk;
    private EGLContext mEGLContext;
    private d brU = new d();
    private com.baidu.mario.gldraw2d.d.c brV = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bsf = new com.baidu.mario.gldraw2d.d.b();
    private a bsg = new a();
    private boolean bsh = false;
    private com.baidu.mario.gldraw2d.c.c brQ = null;
    private b bsi = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bsj = i;
        this.bsk = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d LH() {
        return this.brU;
    }

    public void c(d dVar) {
        this.brU = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c LI() {
        return this.brV;
    }

    public com.baidu.mario.gldraw2d.d.a LJ() {
        return this.bsf;
    }

    public a LK() {
        return this.bsg;
    }

    public void a(a aVar) {
        this.bsg = aVar;
    }

    public boolean LL() {
        return this.bsh;
    }

    public com.baidu.mario.gldraw2d.c.c LM() {
        return this.brQ;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.brQ = cVar;
    }

    public b LN() {
        return this.bsi;
    }

    public void a(b bVar) {
        this.bsi = bVar;
    }

    public int LO() {
        return this.bsj;
    }

    public boolean LP() {
        return this.bsk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bsj < cVar.LO() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: LQ */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bsg.clone());
            cVar.a(this.bsi.clone());
        }
        return cVar;
    }
}
