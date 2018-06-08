package com.baidu.ar.recorder.filter;

import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class b extends a implements c {
    private static final String b = b.class.getSimpleName();
    protected int a;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public b(Context context) {
        this.a = a(context);
        if (this.a == 0) {
            throw new RuntimeException("Unable to create program");
        }
        a();
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected int a(Context context) {
        return com.baidu.ar.recorder.e.d.a("uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float; //指定默认精度\n\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected void a() {
        this.g = GLES20.glGetUniformLocation(this.a, "uTexture");
        this.c = GLES20.glGetAttribLocation(this.a, "aPosition");
        this.d = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
        this.e = GLES20.glGetUniformLocation(this.a, "uTexMatrix");
        this.f = GLES20.glGetAttribLocation(this.a, "aTextureCoord");
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected void a(int i) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(f(), i);
        GLES20.glUniform1i(this.g, 0);
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected void a(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        if (z2) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
        }
        GLES20.glDrawArrays(5, i, i2);
        if (z2) {
            GLES20.glDisable(3042);
        }
    }

    @Override // com.baidu.ar.recorder.filter.c
    public void a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6, boolean z, boolean z2) {
        com.baidu.ar.recorder.e.d.a("draw start");
        b();
        a(i5);
        a(fArr, floatBuffer, i3, i4, fArr2, floatBuffer2, i6);
        a(i, i2, z, z2);
        c();
        d();
        e();
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected void a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, float[] fArr2, FloatBuffer floatBuffer2, int i3) {
        GLES20.glUniformMatrix4fv(this.d, 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(this.e, 1, false, fArr2, 0);
        GLES20.glEnableVertexAttribArray(this.c);
        GLES20.glVertexAttribPointer(this.c, i, 5126, false, i2, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f);
        GLES20.glVertexAttribPointer(this.f, 2, 5126, false, i3, (Buffer) floatBuffer2);
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected void b() {
        GLES20.glUseProgram(this.a);
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected void c() {
        GLES20.glDisableVertexAttribArray(this.c);
        GLES20.glDisableVertexAttribArray(this.f);
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected void d() {
        GLES20.glBindTexture(f(), 0);
    }

    @Override // com.baidu.ar.recorder.filter.a
    protected void e() {
        GLES20.glUseProgram(0);
        GLES20.glFinish();
    }

    public int f() {
        return 36197;
    }

    @Override // com.baidu.ar.recorder.filter.c
    public void g() {
        Log.d(b, "releaseProgram");
        GLES20.glDeleteProgram(this.a);
        this.a = -1;
    }
}
