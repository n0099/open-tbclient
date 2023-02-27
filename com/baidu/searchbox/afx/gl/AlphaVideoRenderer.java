package com.baidu.searchbox.afx.gl;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class AlphaVideoRenderer implements GLTextureView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    public static final String TAG = "AlphaVideoRenderer";
    public int aPositionHandle;
    public int aTextureAlphaHandle;
    public int aTextureColorHandle;
    public OnSurfacePrepareListener mOnSurfacePrepareListener;
    public int mProgram;
    public SurfaceTexture mSurfaceTexture;
    public FloatBuffer mTriangleVertices;
    public int uDismissFlagHandle;
    public int uFilterFactorHandle;
    public int uMVPMatrixHandle;
    public int uSTMatrixHandle;
    public float[] mMVPMatrix = new float[16];
    public float[] mSTMatrix = new float[16];
    public float mFilterFactor = 0.0f;
    public float mDismissFlag = 0.0f;
    public volatile boolean clearLastFrame = false;
    public volatile boolean onPlay = false;
    public volatile boolean mUpdateSurface = false;

    /* loaded from: classes2.dex */
    public interface OnSurfacePrepareListener {
        void onSurfacePrepared(Surface surface);
    }

    public AlphaVideoRenderer() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(AlphaVideoCoords.VERTICES.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = asFloatBuffer;
        asFloatBuffer.put(AlphaVideoCoords.VERTICES).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    @SuppressLint({"BDThrowableCheck"})
    private void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e(TAG, str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
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
            return glCreateShader;
        }
        return glCreateShader;
    }

    private void prepareSurface() {
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        checkGlError("glBindTexture textureID");
        SurfaceTexture surfaceTexture = new SurfaceTexture(i);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        Surface surface = new Surface(this.mSurfaceTexture);
        OnSurfacePrepareListener onSurfacePrepareListener = this.mOnSurfacePrepareListener;
        if (onSurfacePrepareListener != null) {
            onSurfacePrepareListener.onSurfacePrepared(surface);
        }
        synchronized (this) {
            this.mUpdateSurface = false;
        }
    }

    public synchronized void clearLastFrame() {
        this.clearLastFrame = true;
    }

    public synchronized void onPlay() {
        this.onPlay = true;
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
        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        GLES20.glBlendFunc(770, 771);
        float f = 0.0f;
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
        synchronized (this) {
            if (this.clearLastFrame) {
                f = -1.0f;
            }
            this.mDismissFlag = f;
        }
        GLES20.glUniform1f(this.uDismissFlagHandle, f);
        GLES20.glFinish();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.mUpdateSurface = true;
            if (this.onPlay) {
                this.clearLastFrame = false;
                this.onPlay = false;
            }
        }
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

    public void setOnSurfacePrepareListener(OnSurfacePrepareListener onSurfacePrepareListener) {
        this.mOnSurfacePrepareListener = onSurfacePrepareListener;
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView.Renderer
    @SuppressLint({"BDThrowableCheck"})
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int createProgram = createProgram(AlphaVideoShaders.SHADER_VERTEX, AlphaVideoShaders.SHADER_FRAGMENT);
        this.mProgram = createProgram;
        if (createProgram == 0) {
            return;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
        checkGlError("glGetAttribLocation aPosition");
        if (this.aPositionHandle != -1) {
            this.aTextureAlphaHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureAlphaCoord");
            checkGlError("glGetAttribLocation aTextureAlphaCoord");
            if (this.aTextureAlphaHandle != -1) {
                this.aTextureColorHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureColorCoord");
                checkGlError("glGetAttribLocation aTextureColorCoord");
                if (this.aTextureColorHandle != -1) {
                    this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
                    checkGlError("glGetUniformLocation uMVPMatrix");
                    if (this.uMVPMatrixHandle != -1) {
                        this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
                        checkGlError("glGetUniformLocation uSTMatrix");
                        if (this.uSTMatrixHandle != -1) {
                            this.uFilterFactorHandle = GLES20.glGetUniformLocation(this.mProgram, "uFilterFactor");
                            checkGlError("glGetUniformLocation uFilterFactor");
                            if (this.uFilterFactorHandle != -1) {
                                this.uDismissFlagHandle = GLES20.glGetUniformLocation(this.mProgram, "uDismissFlag");
                                checkGlError("glGetUniformLocation uDismissFlag");
                                if (this.uDismissFlagHandle != -1) {
                                    prepareSurface();
                                    return;
                                }
                                throw new RuntimeException("Could not get attrib location for uDismissFlag");
                            }
                            throw new RuntimeException("Could not get attrib location for uFilterFactor");
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib color location for aTextureColorCoord");
            }
            throw new RuntimeException("Could not get attrib alpha location for aTextureAlphaCoord");
        }
        throw new RuntimeException("Could not get attrib location for aPosition");
    }
}
