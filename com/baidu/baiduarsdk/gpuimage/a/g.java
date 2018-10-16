package com.baidu.baiduarsdk.gpuimage.a;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.baiduarsdk.gpuimage.graphics.Drawable2d;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class g {
    private final LinkedList<Runnable> a;
    protected final Drawable2d b;
    protected boolean c;
    protected int d;
    protected int e;
    protected int f;
    protected float[] g;
    protected float[] h;
    protected int i;
    protected int j;
    private String k;
    private String l;
    private int m;
    private int n;
    private int o;
    private int p;

    public g() {
        this("uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}", "precision mediump float;varying vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main() {    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);}");
    }

    public g(String str, String str2) {
        this.b = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.k = null;
        this.l = null;
        this.g = null;
        this.h = null;
        this.a = new LinkedList<>();
        this.f = 3553;
        if (TextUtils.isEmpty(str)) {
            this.k = "uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}";
        } else {
            this.k = str;
        }
        if (TextUtils.isEmpty(str2)) {
            this.l = "precision mediump float;varying vec2 textureCoordinate;uniform sampler2D inputImageTexture;void main() {    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);}";
        } else {
            this.l = str2;
        }
    }

    private void k() {
        synchronized (this.a) {
            while (!this.a.isEmpty()) {
                this.a.removeFirst().run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.m = com.baidu.baiduarsdk.gpuimage.graphics.a.a(this.k, this.l);
        if (this.m == 0) {
            throw new RuntimeException("Unable to create program");
        }
        this.n = GLES20.glGetAttribLocation(this.m, AiAppsNaViewModel.KEY_POSITION);
        com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.n, AiAppsNaViewModel.KEY_POSITION);
        this.o = GLES20.glGetAttribLocation(this.m, "inputTextureCoordinate");
        com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.o, "inputTextureCoordinate");
        this.d = GLES20.glGetUniformLocation(this.m, "uMVPMatrix");
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("getting location of uMVPMatrix");
        this.e = GLES20.glGetUniformLocation(this.m, "uTexMatrix");
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("getting location of uTexMatrix");
        this.p = GLES20.glGetUniformLocation(this.m, "inputImageTexture");
        com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.p, "inputImageTexture");
    }

    public void a(int i) {
        b(i, 0);
    }

    public void a(final int i, final float f) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.7
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1f(i, f);
            }
        });
    }

    public void a(int i, int i2) {
        this.i = i;
        this.j = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.9
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.a) {
            this.a.addLast(runnable);
        }
    }

    public void a(final String str, final float f) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.8
            @Override // java.lang.Runnable
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(g.this.h(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform1f(glGetUniformLocation, f);
                }
            }
        });
    }

    public void a(final String str, final int i) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.6
            @Override // java.lang.Runnable
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(g.this.h(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform1i(glGetUniformLocation, i);
                }
            }
        });
    }

    public void a(final String str, final PointF pointF) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.2
            @Override // java.lang.Runnable
            public void run() {
                float[] fArr = {pointF.x, pointF.y};
                int glGetUniformLocation = GLES20.glGetUniformLocation(g.this.h(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform2fv(glGetUniformLocation, 1, fArr, 0);
                }
            }
        });
    }

    public void a(final String str, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.10
            @Override // java.lang.Runnable
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(g.this.h(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform3fv(glGetUniformLocation, 1, FloatBuffer.wrap(fArr));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.i = 0;
        this.j = 0;
    }

    public void b(int i, int i2) {
        if (this.g == null) {
            this.g = (float[]) com.baidu.baiduarsdk.gpuimage.graphics.a.a.clone();
        }
        if (this.h == null) {
            this.h = (float[]) com.baidu.baiduarsdk.gpuimage.graphics.a.a.clone();
        }
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("draw start");
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glViewport(0, 0, this.i, this.j);
        GLES20.glUseProgram(this.m);
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glUseProgram");
        k();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f, i);
        GLES20.glUniform1i(this.p, 0);
        if (this.d >= 0) {
            GLES20.glUniformMatrix4fv(this.d, 1, false, this.g, 0);
            com.baidu.baiduarsdk.gpuimage.graphics.a.a("glUniformMatrix4fv for mMvpMatrix");
        }
        if (this.e >= 0) {
            GLES20.glUniformMatrix4fv(this.e, 1, false, this.h, 0);
            com.baidu.baiduarsdk.gpuimage.graphics.a.a("glUniformMatrix4fv for mTexMatrix");
        }
        GLES20.glEnableVertexAttribArray(this.n);
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.n, 2, 5126, false, 0, (Buffer) this.b.a());
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.o);
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 0, (Buffer) this.b.b());
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glVertexAttribPointer");
        f();
        GLES20.glDrawArrays(5, 0, 4);
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.n);
        GLES20.glDisableVertexAttribArray(this.o);
        GLES20.glBindTexture(this.f, 0);
        GLES20.glUseProgram(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.11
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    public void b(final String str, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(g.this.h(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniform4fv(glGetUniformLocation, 1, FloatBuffer.wrap(fArr));
                }
            }
        });
    }

    public void b(float[] fArr) {
        this.g = fArr;
    }

    public final void c() {
        if (this.c) {
            return;
        }
        a();
        this.c = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.4
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
            }
        });
    }

    public void c(final String str, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.3
            @Override // java.lang.Runnable
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(g.this.h(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniformMatrix3fv(glGetUniformLocation, 1, false, fArr, 0);
                }
            }
        });
    }

    public void c(float[] fArr) {
        this.h = fArr;
    }

    public void d() {
        Log.d("GlUtil", "deleting program " + this.m);
        GLES20.glDeleteProgram(this.m);
        this.c = false;
        this.m = -1;
        e();
    }

    public void d(final String str, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.g.5
            @Override // java.lang.Runnable
            public void run() {
                int glGetUniformLocation = GLES20.glGetUniformLocation(g.this.h(), str);
                if (glGetUniformLocation >= 0) {
                    GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr, 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.i = 0;
        this.j = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
    }

    public boolean g() {
        return this.c;
    }

    public int h() {
        return this.m;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.o;
    }
}
