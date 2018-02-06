package com.baidu.ar.opengl.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.baidu.baiduarsdk.RendererUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class b {
    private static final float[] j = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] k = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int l;
    private final int i = 8;
    private final float[] m = new float[16];
    private final float[] n = new float[16];
    private FloatBuffer a = RendererUtils.createFloatBuffer(j);
    private FloatBuffer b = RendererUtils.createFloatBuffer(k);

    public b() {
        Matrix.setIdentityM(this.m, 0);
        Matrix.setIdentityM(this.n, 0);
    }

    private void c() {
        this.d = GLES20.glGetAttribLocation(this.c, "aPosition");
        this.e = GLES20.glGetAttribLocation(this.c, "aTextureCoord");
        this.f = GLES20.glGetUniformLocation(this.c, "uTexture");
        this.g = GLES20.glGetUniformLocation(this.c, "uTexMatrix");
        this.h = GLES20.glGetUniformLocation(this.c, "uMVPMatrix");
    }

    public void a() {
        GLES20.glDeleteProgram(this.c);
    }

    public void a(int i) {
        this.l = i;
        this.c = RendererUtils.createProgram("uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES uTexture;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
        c();
    }

    public void a(int i, float f, float f2, float f3) {
        Matrix.setIdentityM(this.m, 0);
        if (i == 1) {
            Matrix.rotateM(this.m, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        } else if (i == 2) {
            Matrix.rotateM(this.m, 0, 180.0f, 1.0f, 0.0f, 0.0f);
        }
        Matrix.rotateM(this.m, 0, f, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(this.m, 0, f2, f3, 1.0f);
    }

    public void b() {
        GLES20.glUseProgram(this.c);
        GLES20.glUniformMatrix4fv(this.h, 1, false, this.m, 0);
        GLES20.glUniformMatrix4fv(this.g, 1, false, this.n, 0);
        GLES20.glEnableVertexAttribArray(this.d);
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 8, (Buffer) this.a);
        GLES20.glEnableVertexAttribArray(this.e);
        GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 8, (Buffer) this.b);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.l);
        GLES20.glUniform1i(this.f, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.d);
        GLES20.glDisableVertexAttribArray(this.e);
    }
}
