package com.baidu.searchbox.afx.gl;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.afx.gl.GLTextureView;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes13.dex */
public class AlphaVideoRenderer implements SurfaceTexture.OnFrameAvailableListener, GLTextureView.Renderer {
    private static final String TAG = "AlphaVideoRenderer";
    private int aPositionHandle;
    private int aTextureAlphaHandle;
    private int aTextureColorHandle;
    private OnSurfacePrepareListener mOnSurfacePrepareListener;
    private int mProgram;
    private SurfaceTexture mSurfaceTexture;
    private int uFilterFactorHandle;
    private int uMVPMatrixHandle;
    private int uSTMatrixHandle;
    private float[] mMVPMatrix = new float[16];
    private float[] mSTMatrix = new float[16];
    private float mFilterFactor = 0.0f;
    private boolean mUpdateSurface = false;
    private FloatBuffer mTriangleVertices = ByteBuffer.allocateDirect(AlphaVideoCoords.VERTICES.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* loaded from: classes13.dex */
    public interface OnSurfacePrepareListener {
        void onSurfacePrepared(Surface surface);
    }

    public AlphaVideoRenderer() {
        this.mTriangleVertices.put(AlphaVideoCoords.VERTICES).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    public void setOnSurfacePrepareListener(OnSurfacePrepareListener onSurfacePrepareListener) {
        this.mOnSurfacePrepareListener = onSurfacePrepareListener;
    }

    public void setDarkFilter(float f) {
        if (f < 0.0f) {
            this.mFilterFactor = 0.0f;
        } else if (f > 1.0f) {
            this.mFilterFactor = 1.0f;
        } else {
            this.mFilterFactor = f;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.mUpdateSurface = true;
        }
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.mProgram = createProgram("uniform mat4 uMVPMatrix; \n uniform mat4 uSTMatrix; \n uniform float uFilterFactor; \n attribute vec4 aPosition; \n attribute vec4 aTextureAlphaCoord; \n attribute vec4 aTextureColorCoord; \n varying vec2 vTextureAlphaCoord; \n varying vec2 vTextureColorCoord; \n varying float vFilterFactor; \n void main() { \n gl_Position = uMVPMatrix * aPosition; \n vTextureAlphaCoord = (uSTMatrix * aTextureAlphaCoord).xy; \n vTextureColorCoord = (uSTMatrix * aTextureColorCoord).xy; \n vFilterFactor = (1.0 - uFilterFactor); \n } \n ", "#extension GL_OES_EGL_image_external : require \n precision highp float; \n varying vec2 vTextureAlphaCoord; \n varying vec2 vTextureColorCoord; \n uniform samplerExternalOES sTexture; \n varying float vFilterFactor; \n void main() { \n vec4 alphaColor = texture2D(sTexture, vTextureAlphaCoord); \n vec4 color = texture2D(sTexture, vTextureColorCoord); \n float blendFactor = alphaColor.r; \n if (blendFactor == 0.0) { \n blendFactor = 1.0; \n } \n gl_FragColor = vec4(color.r/blendFactor*vFilterFactor,color.g/blendFactor*vFilterFactor,color.b/blendFactor*vFilterFactor,alphaColor.r); \n } \n ");
        if (this.mProgram != 0) {
            this.aPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
            checkGlError("glGetAttribLocation aPosition");
            if (this.aPositionHandle == -1) {
                throw new RuntimeException("Could not get attrib location for aPosition");
            }
            this.aTextureAlphaHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureAlphaCoord");
            checkGlError("glGetAttribLocation aTextureAlphaCoord");
            if (this.aTextureAlphaHandle == -1) {
                throw new RuntimeException("Could not get attrib alpha location for aTextureAlphaCoord");
            }
            this.aTextureColorHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureColorCoord");
            checkGlError("glGetAttribLocation aTextureColorCoord");
            if (this.aTextureColorHandle == -1) {
                throw new RuntimeException("Could not get attrib color location for aTextureColorCoord");
            }
            this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
            checkGlError("glGetUniformLocation uMVPMatrix");
            if (this.uMVPMatrixHandle == -1) {
                throw new RuntimeException("Could not get attrib location for uMVPMatrix");
            }
            this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
            checkGlError("glGetUniformLocation uSTMatrix");
            if (this.uSTMatrixHandle == -1) {
                throw new RuntimeException("Could not get attrib location for uSTMatrix");
            }
            this.uFilterFactorHandle = GLES20.glGetUniformLocation(this.mProgram, "uFilterFactor");
            checkGlError("glGetUniformLocation uFilterFactor");
            if (this.uFilterFactorHandle == -1) {
                throw new RuntimeException("Could not get attrib location for uFilterFactor");
            }
            prepareSurface();
        }
    }

    private int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e(TAG, "Could not link program: ");
                Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Log.e(TAG, "Could not compile shader " + i + ":");
                Log.e(TAG, GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
        }
        return glCreateShader;
    }

    private void prepareSurface() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        checkGlError("glBindTexture textureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        this.mSurfaceTexture = new SurfaceTexture(i);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Surface surface = new Surface(this.mSurfaceTexture);
        if (this.mOnSurfacePrepareListener != null) {
            this.mOnSurfacePrepareListener.onSurfacePrepared(surface);
        }
        synchronized (this) {
            this.mUpdateSurface = false;
        }
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView.Renderer
    public void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            if (this.mUpdateSurface) {
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                this.mUpdateSurface = false;
            }
        }
        GLES20.glClear(16640);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(this.mProgram);
        checkGlError("glUseProgram");
        this.mTriangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 3, 5126, false, 28, (Buffer) this.mTriangleVertices);
        checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        checkGlError("glEnableVertexAttribArray aPositionHandle");
        this.mTriangleVertices.position(3);
        GLES20.glVertexAttribPointer(this.aTextureAlphaHandle, 2, 5126, false, 28, (Buffer) this.mTriangleVertices);
        checkGlError("glVertexAttribPointer aTextureAlphaHandle");
        GLES20.glEnableVertexAttribArray(this.aTextureAlphaHandle);
        checkGlError("glEnableVertexAttribArray aTextureAlphaHandle");
        this.mTriangleVertices.position(5);
        GLES20.glVertexAttribPointer(this.aTextureColorHandle, 2, 5126, false, 28, (Buffer) this.mTriangleVertices);
        checkGlError("glVertexAttribPointer aTextureColorHandle");
        GLES20.glEnableVertexAttribArray(this.aTextureColorHandle);
        checkGlError("glEnableVertexAttribArray aTextureColorHandle");
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        GLES20.glUniform1f(this.uFilterFactorHandle, this.mFilterFactor);
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glFinish();
    }

    private void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e(TAG, str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }
}
