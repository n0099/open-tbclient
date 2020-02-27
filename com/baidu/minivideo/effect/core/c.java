package com.baidu.minivideo.effect.core;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c extends d {
    private List<b> d;
    private List<b> e;
    private int[] f;
    private int[] g;
    private final FloatBuffer h;
    private final FloatBuffer i;

    public c() {
        this(null);
    }

    public c(List<b> list) {
        this.d = list;
        if (this.d == null) {
            this.d = new ArrayList();
        } else {
            s();
        }
        this.h = ByteBuffer.allocateDirect(g.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.h.put(g.a).position(0);
        float[] b = g.b(Rotation.NORMAL, false, true);
        this.i = ByteBuffer.allocateDirect(b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i.put(b).position(0);
    }

    private void t() {
        if (this.g != null) {
            GLES20.glDeleteTextures(this.g.length, this.g, 0);
            this.g = null;
        }
        if (this.f != null) {
            GLES20.glDeleteFramebuffers(this.f.length, this.f, 0);
            this.f = null;
        }
    }

    @Override // com.baidu.minivideo.effect.core.b
    public int a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.f != null && this.g != null && this.e != null) {
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.e.get(i2);
                bVar.h();
                GLES20.glBindFramebuffer(36160, this.f[i2]);
                GLES20.glViewport(0, 0, l(), m());
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
                if (i2 == 0) {
                    bVar.b(i, floatBuffer, floatBuffer2);
                } else if (i2 == size - 1) {
                    bVar.b(i, floatBuffer, size % 2 == 0 ? this.i : this.h);
                } else {
                    bVar.b(i, floatBuffer, this.h);
                }
                GLES20.glBindFramebuffer(36160, 0);
                i = this.g[i2];
            }
            floatBuffer2.clear();
            floatBuffer2.put(g.b(Rotation.NORMAL, false, true)).position(0);
        }
        return i;
    }

    @Override // com.baidu.minivideo.effect.core.b
    public void a(int i, int i2) {
        super.a(i, i2);
        if (this.f != null) {
            t();
        }
        if (this.e == null || this.e.size() <= 0) {
            return;
        }
        int size = this.e.size();
        this.f = new int[size];
        this.g = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            this.e.get(i3).a(i, i2);
            GLES20.glGenFramebuffers(1, this.f, i3);
            GLES20.glGenTextures(1, this.g, i3);
            GLES20.glBindTexture(3553, this.g[i3]);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.f[i3]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.g[i3], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    @Override // com.baidu.minivideo.effect.core.b
    public void a(int i, long j) {
        super.a(i, j);
        if (this.e != null) {
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.e.get(i2).a(i, j);
            }
        }
    }

    @Override // com.baidu.minivideo.effect.core.d, com.baidu.minivideo.effect.core.b
    public void b() {
        super.b();
        for (b bVar : this.d) {
            bVar.d();
        }
    }

    @Override // com.baidu.minivideo.effect.core.b
    public void f() {
        t();
        for (b bVar : this.d) {
            bVar.e();
        }
        super.f();
    }

    public List<b> r() {
        return this.e;
    }

    public void s() {
        if (this.d == null) {
            return;
        }
        if (this.e == null) {
            this.e = new ArrayList();
        } else {
            this.e.clear();
        }
        for (b bVar : this.d) {
            if (bVar instanceof c) {
                ((c) bVar).s();
                List<b> r = ((c) bVar).r();
                if (r != null && !r.isEmpty()) {
                    this.e.addAll(r);
                }
            } else {
                this.e.add(bVar);
            }
        }
    }
}
