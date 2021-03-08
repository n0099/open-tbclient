package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public class RendererUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f1275a = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] b = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f1276a;
        private int b;
        private int c;
        private int d;
        private FloatBuffer e;
        private FloatBuffer f;
    }

    public static int createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(iArr.length, iArr, 0);
        return iArr[0];
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

    public static int createTexture(int i, int i2) {
        int createTexture = createTexture();
        GLES20.glBindTexture(3553, createTexture);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        return createTexture;
    }

    public static int createFBO(int i, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        GLES20.glGenRenderbuffers(1, iArr, 0);
        GLES20.glBindRenderbuffer(36161, iArr[0]);
        GLES20.glRenderbufferStorage(36161, i4, i2, i3);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        GLES20.glBindFramebuffer(36160, iArr2[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, iArr[0]);
        GLES20.glBindFramebuffer(36160, 0);
        return iArr2[0];
    }

    public static void renderTexture(a aVar, int i, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(aVar.f1276a);
        GLES20.glDisable(2929);
        GLES20.glDisable(3042);
        GLES20.glVertexAttribPointer(aVar.c, 2, 5126, false, 0, (Buffer) aVar.e);
        GLES20.glEnableVertexAttribArray(aVar.c);
        GLES20.glVertexAttribPointer(aVar.d, 2, 5126, false, 0, (Buffer) aVar.f);
        GLES20.glEnableVertexAttribArray(aVar.d);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(aVar.b, 0);
        GLES20.glDrawArrays(5, 0, 4);
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
        aVar.b = GLES20.glGetUniformLocation(glCreateProgram, "tex_sampler");
        aVar.c = GLES20.glGetAttribLocation(glCreateProgram, "a_texcoord");
        aVar.d = GLES20.glGetAttribLocation(glCreateProgram, "a_position");
        aVar.e = createVerticesBuffer(f1275a);
        aVar.f = createVerticesBuffer(b);
        aVar.f1276a = glCreateProgram;
        return aVar;
    }

    private static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                throw new RuntimeException("Could not compile shader " + i + ":" + glGetShaderInfoLog);
            }
        }
        return glCreateShader;
    }

    private static FloatBuffer createVerticesBuffer(float[] fArr) {
        if (fArr.length != 8) {
            throw new RuntimeException("Number of vertices should be four.");
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }
}
