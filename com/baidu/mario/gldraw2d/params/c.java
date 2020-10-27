package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes5.dex */
public class c implements Cloneable, Comparable<c> {
    private int bQO;
    private boolean bQP;
    private EGLContext mEGLContext;
    private d bQA = new d();
    private com.baidu.mario.gldraw2d.d.c bQB = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bQK = new com.baidu.mario.gldraw2d.d.b();
    private a bQL = new a();
    private boolean bQM = false;
    private com.baidu.mario.gldraw2d.c.c bQy = null;
    private b bQN = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bQO = i;
        this.bQP = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d Wr() {
        return this.bQA;
    }

    public void c(d dVar) {
        this.bQA = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c Ws() {
        return this.bQB;
    }

    public com.baidu.mario.gldraw2d.d.a Wt() {
        return this.bQK;
    }

    public a Wu() {
        return this.bQL;
    }

    public void a(a aVar) {
        this.bQL = aVar;
    }

    public boolean Wv() {
        return this.bQM;
    }

    public com.baidu.mario.gldraw2d.c.c Ww() {
        return this.bQy;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bQy = cVar;
    }

    public b Wx() {
        return this.bQN;
    }

    public void a(b bVar) {
        this.bQN = bVar;
    }

    public int Wy() {
        return this.bQO;
    }

    public boolean Wz() {
        return this.bQP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bQO < cVar.Wy() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: WA */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bQL.clone());
            cVar.a(this.bQN.clone());
        }
        return cVar;
    }
}
