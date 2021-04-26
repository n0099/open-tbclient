package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.baidu.wallet.core.StatusCode;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes.dex */
public class RendererUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f4251a = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f4252b = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4253a;

        /* renamed from: b  reason: collision with root package name */
        public int f4254b;

        /* renamed from: c  reason: collision with root package name */
        public int f4255c;

        /* renamed from: d  reason: collision with root package name */
        public int f4256d;

        /* renamed from: e  reason: collision with root package name */
        public FloatBuffer f4257e;

        /* renamed from: f  reason: collision with root package name */
        public FloatBuffer f4258f;
    }

    public static int createFBO(int i2, int i3, int i4, int i5) {
        int[] iArr = new int[1];
        GLES20.glGenRenderbuffers(1, iArr, 0);
        GLES20.glBindRenderbuffer(36161, iArr[0]);
        GLES20.glRenderbufferStorage(36161, i5, i3, i4);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        GLES20.glBindFramebuffer(36160, iArr2[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, iArr[0]);
        GLES20.glBindFramebuffer(36160, 0);
        return iArr2[0];
    }

    public static a createProgram() {
        int loadShader;
        int loadShader2 = loadShader(35633, "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n");
        if (loadShader2 == 0 || (loadShader = loadShader(35632, "precision mediump float;\nuniform sampler2D tex_sampler;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_FragColor = texture2D(tex_sampler, v_texcoord);\n}\n")) == 0) {
            return null;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            GLES20.glAttachShader(glCreateProgram, loadShader);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                throw new RuntimeException("Could not link program: " + glGetProgramInfoLog);
            }
        }
        a aVar = new a();
        aVar.f4254b = GLES20.glGetUniformLocation(glCreateProgram, "tex_sampler");
        aVar.f4255c = GLES20.glGetAttribLocation(glCreateProgram, "a_texcoord");
        aVar.f4256d = GLES20.glGetAttribLocation(glCreateProgram, "a_position");
        aVar.f4257e = createVerticesBuffer(f4251a);
        aVar.f4258f = createVerticesBuffer(f4252b);
        aVar.f4253a = glCreateProgram;
        return aVar;
    }

    public static int createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    public static FloatBuffer createVerticesBuffer(float[] fArr) {
        if (fArr.length == 8) {
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(fArr).position(0);
            return asFloatBuffer;
        }
        throw new RuntimeException("Number of vertices should be four.");
    }

    public static int loadShader(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                throw new RuntimeException("Could not compile shader " + i2 + ":" + glGetShaderInfoLog);
            }
        }
        return glCreateShader;
    }

    public static void renderTexture(a aVar, int i2, int i3, int i4) {
        GLES20.glViewport(0, 0, i3, i4);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(aVar.f4253a);
        GLES20.glDisable(2929);
        GLES20.glDisable(3042);
        GLES20.glVertexAttribPointer(aVar.f4255c, 2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 0, (Buffer) aVar.f4257e);
        GLES20.glEnableVertexAttribArray(aVar.f4255c);
        GLES20.glVertexAttribPointer(aVar.f4256d, 2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 0, (Buffer) aVar.f4258f);
        GLES20.glEnableVertexAttribArray(aVar.f4256d);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(aVar.f4254b, 0);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public static int createTexture(Bitmap bitmap) {
        int createTexture = createTexture();
        GLES20.glBindTexture(3553, createTexture);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        return createTexture;
    }

    public static int createTexture(int i2, int i3) {
        int createTexture = createTexture();
        GLES20.glBindTexture(3553, createTexture);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        return createTexture;
    }
}
