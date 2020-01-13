package com.baidu.media.transcoder.a;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes5.dex */
class e {
    private int e;
    private int g;
    private int h;
    private int i;
    private int j;
    private final float[] a = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private float[] c = new float[16];
    private float[] d = new float[16];
    private int f = -12345;
    private FloatBuffer b = ByteBuffer.allocateDirect(this.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public e() {
        this.b.put(this.a).position(0);
        Matrix.setIdentityM(this.d, 0);
    }

    private int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            com.baidu.media.transcoder.d.d("TextureRender", "Could not compile shader " + i + ":");
            com.baidu.media.transcoder.d.d("TextureRender", HanziToPinyin.Token.SEPARATOR + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    private int a(String str, String str2) {
        int a;
        int a2 = a(35633, str);
        if (a2 == 0 || (a = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            com.baidu.media.transcoder.d.d("TextureRender", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            com.baidu.media.transcoder.d.d("TextureRender", "Could not link program: ");
            com.baidu.media.transcoder.d.d("TextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public int a() {
        return this.f;
    }

    public void a(SurfaceTexture surfaceTexture) {
        a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.d);
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.e);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f);
        this.b.position(0);
        GLES20.glVertexAttribPointer(this.i, 3, 5126, false, 20, (Buffer) this.b);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.i);
        a("glEnableVertexAttribArray maPositionHandle");
        this.b.position(3);
        GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 20, (Buffer) this.b);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.j);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.c, 0);
        GLES20.glUniformMatrix4fv(this.g, 1, false, this.c, 0);
        GLES20.glUniformMatrix4fv(this.h, 1, false, this.d, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            com.baidu.media.transcoder.d.d("TextureRender", str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }

    public void b() {
        this.e = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        if (this.e == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.i = GLES20.glGetAttribLocation(this.e, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.i == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.j = GLES20.glGetAttribLocation(this.e, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.j == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.g = GLES20.glGetUniformLocation(this.e, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.g == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.h = GLES20.glGetUniformLocation(this.e, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.h == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f = iArr[0];
        GLES20.glBindTexture(36197, this.f);
        a("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        a("glTexParameter");
    }
}
