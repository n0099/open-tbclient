package com.baidu.baiduarsdk.gpuimage.graphics;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.ar.util.SystemInfoUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class a {
    public static final float[] a = new float[16];
    public static final float[] b;
    public static final float[] c;
    public static final float[] d;

    static {
        Matrix.setIdentityM(a, 0);
        b = new float[16];
        Matrix.setIdentityM(b, 0);
        Matrix.scaleM(b, 0, -1.0f, 1.0f, 1.0f);
        c = new float[16];
        Matrix.setIdentityM(c, 0);
        Matrix.scaleM(c, 0, 1.0f, -1.0f, 1.0f);
        d = new float[16];
        Matrix.setIdentityM(d, 0);
        Matrix.scaleM(d, 0, -1.0f, -1.0f, 1.0f);
    }

    public static int a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(iArr.length, iArr, 0);
        return iArr[0];
    }

    public static int a(int i) {
        return a(i, 0);
    }

    private static int a(int i, int i2) {
        int i3 = i2 == 0 ? 9729 : 9728;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a("glGenTextures");
        int i4 = iArr[0];
        GLES20.glBindTexture(i, i4);
        a("glBindTexture " + i4);
        GLES20.glTexParameterf(i, 10241, i3);
        GLES20.glTexParameterf(i, 10240, i3);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        a("glTexParameter");
        return i4;
    }

    public static int a(int i, int i2, int i3) {
        int a2 = a(i);
        GLES20.glTexImage2D(i, 0, 6408, i2, i3, 0, 6408, 5121, null);
        a("createTextureObject");
        return a2;
    }

    public static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("GlUtil", "Could not compile shader " + i + SystemInfoUtil.COLON);
            Log.e("GlUtil", "error=" + GLES20.glGetError() + ";log=" + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
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

    public static int a(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("GlUtil", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("GlUtil", "Could not link program: ");
            Log.e("GlUtil", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static FloatBuffer a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static void a(int i, int i2, int i3, int i4, int i5) {
        GLES20.glBindRenderbuffer(36161, i4);
        GLES20.glRenderbufferStorage(36161, i, i2, i3);
        GLES20.glBindRenderbuffer(36161, 0);
        GLES20.glBindFramebuffer(36160, i5);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, i4);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public static void a(String str) {
        if (GLES20.glGetError() != 0) {
        }
    }

    public static int b() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    public static void b(int i) {
        if (i == -1) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        a("glDeleteTextures");
    }

    public static void b(int i, int i2, int i3) {
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glBindTexture(i2, i);
        GLES20.glFramebufferTexture2D(36160, 36064, i2, i, 0);
    }

    public static void b(int i, String str) {
        if (i < 0) {
        }
    }

    public static int c() {
        int[] iArr = new int[1];
        GLES20.glGenRenderbuffers(1, iArr, 0);
        return iArr[0];
    }

    public static void c(int i) {
        if (i == -1) {
            return;
        }
        GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
        a("glDeleteFramebuffers");
    }

    public static void d(int i) {
        if (i == -1) {
            return;
        }
        GLES20.glDeleteRenderbuffers(1, new int[]{i}, 0);
        a("glDeleteRenderbuffers");
    }
}
