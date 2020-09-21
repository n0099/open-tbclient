package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes4.dex */
public class c implements Cloneable, Comparable<c> {
    private int bBR;
    private boolean bBS;
    private EGLContext mEGLContext;
    private d bBD = new d();
    private com.baidu.mario.gldraw2d.d.c bBE = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bBN = new com.baidu.mario.gldraw2d.d.b();
    private a bBO = new a();
    private boolean bBP = false;
    private com.baidu.mario.gldraw2d.c.c bBB = null;
    private b bBQ = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bBR = i;
        this.bBS = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d SE() {
        return this.bBD;
    }

    public void c(d dVar) {
        this.bBD = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c SF() {
        return this.bBE;
    }

    public com.baidu.mario.gldraw2d.d.a SG() {
        return this.bBN;
    }

    public a SH() {
        return this.bBO;
    }

    public void a(a aVar) {
        this.bBO = aVar;
    }

    public boolean SI() {
        return this.bBP;
    }

    public com.baidu.mario.gldraw2d.c.c SJ() {
        return this.bBB;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bBB = cVar;
    }

    public b SK() {
        return this.bBQ;
    }

    public void a(b bVar) {
        this.bBQ = bVar;
    }

    public int SL() {
        return this.bBR;
    }

    public boolean SM() {
        return this.bBS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bBR < cVar.SL() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: SN */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bBO.clone());
            cVar.a(this.bBQ.clone());
        }
        return cVar;
    }
}
