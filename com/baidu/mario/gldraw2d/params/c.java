package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes11.dex */
public class c implements Cloneable, Comparable<c> {
    private int bnj;
    private boolean bnk;
    private EGLContext mEGLContext;
    private d bmU = new d();
    private com.baidu.mario.gldraw2d.d.c bmV = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a bnf = new com.baidu.mario.gldraw2d.d.b();
    private a bng = new a();
    private boolean bnh = false;
    private com.baidu.mario.gldraw2d.c.c bmQ = null;
    private b bni = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.bnj = i;
        this.bnk = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d Ky() {
        return this.bmU;
    }

    public void c(d dVar) {
        this.bmU = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c Kz() {
        return this.bmV;
    }

    public com.baidu.mario.gldraw2d.d.a KA() {
        return this.bnf;
    }

    public a KB() {
        return this.bng;
    }

    public void a(a aVar) {
        this.bng = aVar;
    }

    public boolean KC() {
        return this.bnh;
    }

    public com.baidu.mario.gldraw2d.c.c KD() {
        return this.bmQ;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.bmQ = cVar;
    }

    public b KE() {
        return this.bni;
    }

    public void a(b bVar) {
        this.bni = bVar;
    }

    public int KF() {
        return this.bnj;
    }

    public boolean KG() {
        return this.bnk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.bnj < cVar.KF() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: KH */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.bng.clone());
            cVar.a(this.bni.clone());
        }
        return cVar;
    }
}
