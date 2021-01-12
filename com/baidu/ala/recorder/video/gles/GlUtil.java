package com.baidu.ala.recorder.video.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
@TargetApi(16)
/* loaded from: classes14.dex */
public class GlUtil {
    public static final float[] IDENTITY_MATRIX = new float[16];
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "Grafika";
    private static final boolean VERBOSE = false;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
    }

    private GlUtil() {
    }

    public static void logPrint(String str) {
    }

    public static int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("Grafika", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, loadShader);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("Grafika", "Could not link program: ");
            Log.e("Grafika", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        checkGlError("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("Grafika", "Could not compile shader " + i + ":");
            Log.e("Grafika", " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public static void checkGlError(String str) {
        int glGetError;
        if (GLES20.glGetError() != 0) {
            String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
            Log.e("Grafika", str2);
            throw new RuntimeException(str2);
        }
    }

    public static void checkLocation(int i, String str) {
        if (i < 0) {
            throw new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    public static int createImageTexture(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i4 = iArr[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, byteBuffer);
        checkGlError("loadImageTexture");
        return i4;
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int createTextureOES() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlError("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        checkGlError("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlError("glTexParameter");
        return i;
    }

    public static void logVersionInfo() {
        Log.i("Grafika", "vendor  : " + GLES20.glGetString(7936));
        Log.i("Grafika", "renderer: " + GLES20.glGetString(7937));
        Log.i("Grafika", "version : " + GLES20.glGetString(7938));
    }

    public static int genTexture(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlError("glGenTextures");
        int i3 = iArr[0];
        GLES20.glBindTexture(3553, i3);
        checkGlError("glBindTexture " + i3);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        checkGlError("glTexParameter");
        return i3;
    }

    public static float[] getIdentityVertexMatrix() {
        return new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    }

    public static float[] getIdentityTextureMatrix() {
        return new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    }

    public static float[] getRoate180TextureMatrix() {
        return new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    }

    public static float[] getIdentityMatrix4() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static float[] getIdentityMatrix2() {
        return new float[]{1.0f, 0.0f, 0.0f, 1.0f};
    }

    public static Bitmap takPicture(int i, int i2, int i3) {
        FrameBufferObject frameBufferObject = new FrameBufferObject();
        frameBufferObject.bindTexture(i3);
        GLES20.glViewport(0, 0, i, i2);
        IntBuffer allocate = IntBuffer.allocate(i * i2);
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, allocate);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocate);
        frameBufferObject.release();
        return createBitmap;
    }

    /* loaded from: classes14.dex */
    public static class FrameBufferObject {
        private int mFramebufferID;

        public FrameBufferObject() {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.mFramebufferID = iArr[0];
        }

        public void release() {
            GLES20.glDeleteFramebuffers(1, new int[]{this.mFramebufferID}, 0);
        }

        public void bind() {
            GLES20.glBindFramebuffer(36160, this.mFramebufferID);
        }

        public void bindTexture(int i) {
            bind();
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
                Log.e("FrameBufferObject", "FrameBuffer::bindTexture2D - Frame buffer is not valid!");
            }
        }
    }
}
