package com.baidu.minivideo.effect.core;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
/* loaded from: classes13.dex */
class f {
    public static final float[] a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    public static int a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        return i;
    }

    public static int a(Bitmap bitmap, int i, boolean z) {
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static int a(String str, int i) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader type=" + i + " source : " + str + "\n");
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.d("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public static int a(String str, String str2) {
        int[] iArr = new int[1];
        int a2 = a(str, 35633);
        if (a2 == 0) {
            throw new RuntimeException("gl Load Program Vertex Shader Failed");
        }
        int a3 = a(str2, 35632);
        if (a3 == 0) {
            throw new RuntimeException("gl Load Program Fragment Shader Failed");
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            GLES20.glDeleteProgram(glCreateProgram);
            throw new RuntimeException("gl Load Program Linking Failed");
        }
        GLES20.glDeleteShader(a2);
        GLES20.glDeleteShader(a3);
        return glCreateProgram;
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 1281) {
            Log.d("zmy", "---> GL_INVALID_VALUE : glError 0x" + Integer.toHexString(glGetError));
        } else if (glGetError != 0) {
            String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
        }
    }

    public static int b() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return i;
    }
}
