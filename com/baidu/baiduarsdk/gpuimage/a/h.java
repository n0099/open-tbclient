package com.baidu.baiduarsdk.gpuimage.a;

import android.opengl.GLES20;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends g {
    private static final String l = h.class.getSimpleName();
    protected List<g> a;
    protected List<g> k;
    private int m;
    private int[] n;
    private boolean o;

    public h() {
        this(null);
    }

    public h(List<g> list) {
        this.o = false;
        a(list);
    }

    private void c(int i, int i2) {
        m();
        if (this.a.size() <= 1) {
            return;
        }
        this.n = new int[2];
        for (int i3 = 0; i3 < 2; i3++) {
            this.n[i3] = com.baidu.baiduarsdk.gpuimage.graphics.a.a(3553, i, i2);
        }
    }

    private void m() {
        if (this.n != null) {
            GLES20.glDeleteTextures(this.n.length, this.n, 0);
            this.n = null;
        }
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        if (!this.o) {
            this.m = com.baidu.baiduarsdk.gpuimage.graphics.a.b();
        }
        for (g gVar : this.a) {
            gVar.c();
        }
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a(int i) {
        b(i, 0);
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a(int i, int i2) {
        if (i == this.i && i2 == this.j) {
            return;
        }
        super.a(i, i2);
        int size = this.a.size();
        Log.i(l, String.format("There are %d filters in this filter-chain.", Integer.valueOf(size)));
        for (int i3 = 0; i3 < size; i3++) {
            this.a.get(i3).a(i, i2);
        }
        if (this.o) {
            return;
        }
        c(i, i2);
    }

    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        this.a.add(gVar);
        l();
    }

    public void a(List<g> list) {
        if (this.a != null) {
            this.a.clear();
        } else {
            this.a = new ArrayList();
        }
        if (list != null) {
            this.a.addAll(list);
        }
        l();
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void a(int[] iArr, int i) {
        this.m = i;
        this.n = iArr;
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void b(int i, int i2) {
        if (g() && this.a != null && this.a.size() > 0) {
            try {
                int size = this.a.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size - 1; i4++) {
                    com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.n[i3], 3553, this.m);
                    this.a.get(i4).b(i, this.m);
                    i = this.n[i3];
                    i3 = 1 - i3;
                }
                this.a.get(size - 1).b(i, i2);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void e() {
        if (this.o) {
            this.n = null;
            this.m = -1;
        } else {
            m();
            com.baidu.baiduarsdk.gpuimage.graphics.a.c(this.m);
        }
        for (g gVar : this.a) {
            gVar.d();
        }
        super.e();
    }

    public List<g> k() {
        return this.k;
    }

    public void l() {
        if (this.a == null) {
            return;
        }
        if (this.k == null) {
            this.k = new ArrayList();
        } else {
            this.k.clear();
        }
        for (g gVar : this.a) {
            if (gVar instanceof h) {
                ((h) gVar).l();
                List<g> k = ((h) gVar).k();
                if (k != null && !k.isEmpty()) {
                    this.k.addAll(k);
                }
            } else {
                this.k.add(gVar);
            }
        }
    }
}
