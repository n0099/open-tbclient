package com.baidu.rtc.camera.filter.glfilter.utils;

import android.opengl.GLES30;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
    }

    public static synchronized int createProgram(String str, String str2) {
        int loadShader;
        int i = 0;
        synchronized (a.class) {
            int loadShader2 = loadShader(35633, str);
            if (loadShader2 != 0 && (loadShader = loadShader(35632, str2)) != 0) {
                int glCreateProgram = GLES30.glCreateProgram();
                checkGlError("glCreateProgram");
                if (glCreateProgram == 0) {
                    Log.e("OpenGLUtils", "Could not create program");
                }
                GLES30.glAttachShader(glCreateProgram, loadShader2);
                checkGlError("glAttachShader");
                GLES30.glAttachShader(glCreateProgram, loadShader);
                checkGlError("glAttachShader");
                GLES30.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES30.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    Log.e("OpenGLUtils", "Could not link program: ");
                    Log.e("OpenGLUtils", GLES30.glGetProgramInfoLog(glCreateProgram));
                    GLES30.glDeleteProgram(glCreateProgram);
                } else {
                    i = glCreateProgram;
                }
                if (loadShader2 > 0) {
                    GLES30.glDetachShader(i, loadShader2);
                    GLES30.glDeleteShader(loadShader2);
                }
                if (loadShader > 0) {
                    GLES30.glDetachShader(i, loadShader);
                    GLES30.glDeleteShader(loadShader);
                }
            }
        }
        return i;
    }

    public static int loadShader(int i, String str) {
        int glCreateShader = GLES30.glCreateShader(i);
        checkGlError("glCreateShader type=" + i);
        GLES30.glShaderSource(glCreateShader, str);
        GLES30.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES30.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("OpenGLUtils", "Could not compile shader " + i + ":");
            Log.e("OpenGLUtils", " " + GLES30.glGetShaderInfoLog(glCreateShader));
            GLES30.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public static void checkGlError(String str) {
        int glGetError = GLES30.glGetError();
        if (glGetError != 0) {
            Log.e("OpenGLUtils", str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static void a(int[] iArr, int[] iArr2, int i, int i2) {
        GLES30.glGenFramebuffers(iArr.length, iArr, 0);
        GLES30.glGenTextures(iArr2.length, iArr2, 0);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < iArr2.length) {
                GLES30.glBindTexture(3553, iArr2[i4]);
                GLES30.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
                GLES30.glTexParameterf(3553, 10240, 9729.0f);
                GLES30.glTexParameterf(3553, 10241, 9729.0f);
                GLES30.glTexParameterf(3553, 10242, 33071.0f);
                GLES30.glTexParameterf(3553, 10243, 33071.0f);
                GLES30.glBindFramebuffer(36160, iArr[i4]);
                GLES30.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i4], 0);
                GLES30.glBindTexture(3553, 0);
                GLES30.glBindFramebuffer(36160, 0);
                i3 = i4 + 1;
            } else {
                checkGlError("createFrameBuffer");
                return;
            }
        }
    }

    public static int gf(int i) {
        int[] iArr = new int[1];
        GLES30.glGenTextures(1, iArr, 0);
        checkGlError("glGenTextures");
        int i2 = iArr[0];
        GLES30.glBindTexture(i, i2);
        checkGlError("glBindTexture " + i2);
        GLES30.glTexParameterf(i, 10241, 9728.0f);
        GLES30.glTexParameterf(i, 10240, 9729.0f);
        GLES30.glTexParameterf(i, 10242, 33071.0f);
        GLES30.glTexParameterf(i, 10243, 33071.0f);
        checkGlError("glTexParameter");
        return i2;
    }

    public static int Xf() {
        return gf(36197);
    }
}
