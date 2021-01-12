package com.baidu.mario.gldraw2d.params;

import android.opengl.EGLContext;
import com.baidu.mario.gldraw2d.d.d;
/* loaded from: classes14.dex */
public class c implements Cloneable, Comparable<c> {
    private int cbY;
    private boolean cbZ;
    private EGLContext mEGLContext;
    private d cbK = new d();
    private com.baidu.mario.gldraw2d.d.c cbL = new com.baidu.mario.gldraw2d.d.c();
    private com.baidu.mario.gldraw2d.d.a cbU = new com.baidu.mario.gldraw2d.d.b();
    private a cbV = new a();
    private boolean cbW = false;
    private com.baidu.mario.gldraw2d.c.c cbI = null;
    private b cbX = new b();

    public c(EGLContext eGLContext, int i, boolean z) {
        this.mEGLContext = eGLContext;
        this.cbY = i;
        this.cbZ = z;
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.mEGLContext = eGLContext;
    }

    public d YD() {
        return this.cbK;
    }

    public void c(d dVar) {
        this.cbK = dVar;
    }

    public com.baidu.mario.gldraw2d.d.c YE() {
        return this.cbL;
    }

    public com.baidu.mario.gldraw2d.d.a YF() {
        return this.cbU;
    }

    public a YG() {
        return this.cbV;
    }

    public void a(a aVar) {
        this.cbV = aVar;
    }

    public boolean YH() {
        return this.cbW;
    }

    public com.baidu.mario.gldraw2d.c.c YI() {
        return this.cbI;
    }

    public void c(com.baidu.mario.gldraw2d.c.c cVar) {
        this.cbI = cVar;
    }

    public b YJ() {
        return this.cbX;
    }

    public void a(b bVar) {
        this.cbX = bVar;
    }

    public int YK() {
        return this.cbY;
    }

    public boolean YL() {
        return this.cbZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return this.cbY < cVar.YK() ? -1 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: YM */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(this.cbV.clone());
            cVar.a(this.cbX.clone());
        }
        return cVar;
    }
}
