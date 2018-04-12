package com.baidu.ar.recorder.drawer;

import android.opengl.EGLContext;
import android.support.annotation.NonNull;
import com.baidu.ar.recorder.filter.FilterManager;
/* loaded from: classes3.dex */
public class b implements Cloneable, Comparable<b> {
    private EGLContext a;
    private int d;
    private boolean e;
    private boolean f;
    private RectDrawableParams g;
    private int b = -1;
    private com.baidu.ar.recorder.c.a c = new com.baidu.ar.recorder.b.a();
    private FilterManager.FilterType h = FilterManager.FilterType.Normal;
    private int i = 0;
    private int j = 0;
    private boolean k = false;

    public b(EGLContext eGLContext, int i, boolean z, boolean z2) {
        this.a = eGLContext;
        this.d = i;
        this.e = z;
        this.f = z2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return this.d < bVar.d() ? -1 : 1;
    }

    public EGLContext a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(EGLContext eGLContext) {
        this.a = eGLContext;
    }

    public void a(RectDrawableParams rectDrawableParams) {
        this.g = rectDrawableParams;
    }

    public void a(FilterManager.FilterType filterType) {
        this.h = filterType;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.j = i;
    }

    public com.baidu.ar.recorder.c.a c() {
        return this.c;
    }

    public Object clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        bVar.a((RectDrawableParams) this.g.clone());
        bVar.a(true);
        return bVar;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public RectDrawableParams g() {
        return this.g;
    }

    public FilterManager.FilterType h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public boolean k() {
        return this.k;
    }
}
