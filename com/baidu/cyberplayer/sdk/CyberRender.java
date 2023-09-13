package com.baidu.cyberplayer.sdk;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.ICyberRenderView;
import com.baidu.searchbox.afx.recode.TextureRender;
import com.faceunity.gles.GeneratedTexture;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class CyberRender implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    public static final int FLOAT_SIZE_BYTES = 4;
    public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    public static final String TAG = "CyberRender";
    public static final int VERTICES_DATA_POS_OFFSET = 0;
    public static final int VERTICES_DATA_STRIDE_BYTES = 20;
    public static final int VERTICES_DATA_UV_OFFSET = 3;
    public CyberRenderSizeHelper mCyberRenderSizeHelper;
    public ICyberRenderView.ICyberSurfaceListener mCyberSufaceListener;
    public boolean mFirstDisplay;
    public int mFragmentProgram;
    public OnRequestRenderListener mOnRequestRenderListener;
    public int mProgram;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    public int mTextureID;
    public int mVertexProgram;
    public FloatBuffer mVertices;
    public int maPositionHandle;
    public int maTextureHandle;
    public int muMVPMatrixHandle;
    public int muSTMatrixHandle;
    public final float[] mVerticesData = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public final String mVertexShader = TextureRender.VERTEX_SHADER;
    public final String mFragmentShader = TextureRender.FRAGMENT_SHADER;
    public float[] mMVPMatrix = new float[16];
    public float[] mSTMatrix = new float[16];
    public boolean mUpdateSurface = false;
    public final Object mSurfaceMonitor = new Object();
    public final Object mSnapShotMonitor = new Object();
    public boolean mTakeSnapShot = false;
    public float mSnapShotScale = 1.0f;
    public int mSnapShotX = 0;
    public int mSnapShotY = 0;

    /* loaded from: classes3.dex */
    public interface OnRequestRenderListener {
        void onRequestRender();
    }

    public boolean setFilterRegion(int i, float f, float f2, float f3, float f4) {
        return false;
    }

    public CyberRender() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.mVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mVertices = asFloatBuffer;
        asFloatBuffer.put(this.mVerticesData).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
        this.mFirstDisplay = false;
        this.mCyberRenderSizeHelper = new CyberRenderSizeHelper();
    }

    private void createSurfaceTexture() {
        releaseSurfaceTexture(this.mSurfaceTexture);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mTextureID = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        detachGL();
        checkGlError("detachGL");
    }

    public void attachGL() {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.attachToGLContext(this.mTextureID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Surface createNewSurface() {
        release();
        createSurfaceTexture();
        if (this.mSurfaceTexture != null) {
            this.mSurface = new Surface(this.mSurfaceTexture);
        }
        this.mUpdateSurface = false;
        this.mFirstDisplay = false;
        return this.mSurface;
    }

    public void detachGL() {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.detachFromGLContext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public void recreateSurfaceTexture() {
        synchronized (this.mSurfaceMonitor) {
            createSurfaceTexture();
            this.mUpdateSurface = false;
            this.mFirstDisplay = false;
        }
    }

    public synchronized void release() {
        releaseSurfaceTexture(this.mSurfaceTexture);
        this.mSurfaceTexture = null;
        if (this.mSurface != null) {
            this.mSurface.release();
        }
        this.mSurface = null;
    }

    public void reset() {
        this.mCyberRenderSizeHelper.reset();
    }

    private void doTakeSnapShotBuffer(int i, int i2, int i3, int i4) {
        if (this.mCyberSufaceListener != null) {
            this.mCyberSufaceListener.onSnapShotComplete(i3, i4, getFrame(i, i2, i3, i4));
        }
    }

    private void drawSmallScreen(int i, int i2, int i3, int i4) {
        CyberLog.i(TAG, "drawSmallScreen called width:" + i3 + " height:" + i4);
        GLES20.glViewport(i, i2, i3, i4);
        onDrawFrameSurfaceTexImpl();
        CyberLog.i(TAG, "drawSmallScreen called end");
    }

    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mCyberRenderSizeHelper.onVideoSizeChanged(i, i2, i3, i4)) {
            this.mCyberRenderSizeHelper.updateDisplaySize();
        }
    }

    private Buffer getFrame(int i, int i2, int i3, int i4) {
        CyberLog.i(TAG, "=> getFrame width:" + i3 + " height:" + i4);
        IntBuffer wrap = IntBuffer.wrap(new int[i3 * i4]);
        wrap.position(0);
        GLES20.glPixelStorei(3333, 4);
        GLES20.glReadPixels(i, i2, i3, i4, GeneratedTexture.FORMAT, 5121, wrap);
        return wrap;
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                CyberLog.e(TAG, "Could not compile shader " + i + ":");
                CyberLog.e(TAG, GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    private void onTakeSnapShot() {
        if (this.mTakeSnapShot && this.mFirstDisplay) {
            synchronized (this.mSnapShotMonitor) {
                if (!this.mTakeSnapShot) {
                    return;
                }
                if (this.mSnapShotScale > 1.0f) {
                    this.mSnapShotScale = 1.0f;
                }
                int i = this.mSnapShotX;
                int i2 = this.mSnapShotY;
                this.mTakeSnapShot = false;
                CyberLog.i(TAG, "drawScreenSnapshot called");
                int surfaceWidth = this.mCyberRenderSizeHelper.getSurfaceWidth();
                int surfaceHeight = this.mCyberRenderSizeHelper.getSurfaceHeight();
                int round = Math.round(surfaceWidth * this.mSnapShotScale);
                int round2 = Math.round(surfaceHeight * this.mSnapShotScale);
                if (round > 0 && round2 > 0) {
                    CyberLog.i(TAG, "drawScreenSnapshot called mSurfaceWidth:" + surfaceWidth + " mSurfaceHeight:" + surfaceHeight + " snapWidth:" + round + " snapHeight:" + round2);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                    drawSmallScreen(i, i2, round, round2);
                    doTakeSnapShotBuffer(i, i2, round, round2);
                    if (round != surfaceWidth || round2 != surfaceHeight) {
                        GLES20.glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
                        GLES20.glClear(16640);
                    }
                    GLES20.glViewport(0, 0, this.mCyberRenderSizeHelper.getSurfaceWidth(), this.mCyberRenderSizeHelper.getSurfaceHeight());
                    OnRequestRenderListener onRequestRenderListener = this.mOnRequestRenderListener;
                    if (onRequestRenderListener != null) {
                        onRequestRenderListener.onRequestRender();
                    }
                    CyberLog.i(TAG, "drawScreenSnapshot called end x:" + i + " y:" + i2);
                }
            }
        }
    }

    public static void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            try {
                surfaceTexture.setOnFrameAvailableListener(null);
                surfaceTexture.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            CyberLog.e(TAG, str + ": glError " + glGetError);
            return true;
        }
        return false;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        attachGL();
        updateTexture();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        onDrawFrameSurfaceTexImpl();
        detachGL();
        onTakeSnapShot();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.mSurfaceMonitor) {
            if (surfaceTexture != this.mSurfaceTexture) {
                return;
            }
            this.mUpdateSurface = true;
            OnRequestRenderListener onRequestRenderListener = this.mOnRequestRenderListener;
            if (onRequestRenderListener != null) {
                onRequestRenderListener.onRequestRender();
            }
        }
    }

    public void setClientRotation(int i) {
        if (this.mCyberRenderSizeHelper.onClientRotationChanged(i)) {
            this.mCyberRenderSizeHelper.updateDisplaySize();
        }
    }

    public void setCyberSurfaceListener(ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener) {
        this.mCyberSufaceListener = iCyberSurfaceListener;
    }

    public void setDisplayeMode(int i) {
        if (this.mCyberRenderSizeHelper.onDisplayModeChanged(i)) {
            this.mCyberRenderSizeHelper.updateDisplaySize();
        }
    }

    public void setFirstDisplay(boolean z) {
        this.mFirstDisplay = z;
    }

    public void setOnRequestRenderListener(OnRequestRenderListener onRequestRenderListener) {
        this.mOnRequestRenderListener = onRequestRenderListener;
    }

    public void setRawFrameRotation(int i) {
        if (this.mCyberRenderSizeHelper.onRawFrameRotationChanged(i)) {
            this.mCyberRenderSizeHelper.updateDisplaySize();
        }
    }

    private void updateTexture() {
        synchronized (this.mSurfaceMonitor) {
            try {
                if (this.mUpdateSurface) {
                    if (this.mSurfaceTexture != null) {
                        this.mSurfaceTexture.updateTexImage();
                        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                    }
                    this.mUpdateSurface = false;
                    if (!this.mFirstDisplay) {
                        this.mFirstDisplay = true;
                        if (this.mCyberSufaceListener != null) {
                            this.mCyberSufaceListener.onSurfaceFirstFrameDrawed(System.currentTimeMillis());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int createProgram(String str, String str2) {
        int loadShader = loadShader(35633, str);
        this.mVertexProgram = loadShader;
        if (loadShader == 0) {
            return 0;
        }
        int loadShader2 = loadShader(35632, str2);
        this.mFragmentProgram = loadShader2;
        if (loadShader2 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                CyberLog.e(TAG, "Could not link program: ");
                CyberLog.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    public void onDrawFrameSurfaceTexImpl() {
        int i = this.mProgram;
        if (i == 0) {
            return;
        }
        GLES20.glUseProgram(i);
        checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
        this.mVertices.position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, (Buffer) this.mVertices);
        checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        checkGlError("glEnableVertexAttribArray maPositionHandle");
        this.mVertices.position(3);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 3, 5126, false, 20, (Buffer) this.mVertices);
        checkGlError("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        checkGlError("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        float[] displayScale = this.mCyberRenderSizeHelper.getDisplayScale();
        if (this.mCyberRenderSizeHelper.isNeedTranslate()) {
            float[] displayTranslate = this.mCyberRenderSizeHelper.getDisplayTranslate();
            Matrix.translateM(this.mMVPMatrix, 0, displayTranslate[0], displayTranslate[1], 0.0f);
        }
        Matrix.scaleM(this.mMVPMatrix, 0, displayScale[0], displayScale[1], 0.0f);
        Matrix.rotateM(this.mMVPMatrix, 0, this.mCyberRenderSizeHelper.getDrawFrameRotation(), 0.0f, 0.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glFinish();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this.mCyberRenderSizeHelper.onSurfaceSizeChanged(i, i2);
        this.mCyberRenderSizeHelper.updateDisplaySize();
        ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener = this.mCyberSufaceListener;
        if (iCyberSurfaceListener != null) {
            iCyberSurfaceListener.onSurfaceChanged(i, i2);
        }
    }

    public void takeSnapshot(float f, int i, int i2) {
        synchronized (this.mSnapShotMonitor) {
            this.mTakeSnapShot = true;
            this.mSnapShotScale = f;
            this.mSnapShotX = i;
            this.mSnapShotY = i2;
        }
        OnRequestRenderListener onRequestRenderListener = this.mOnRequestRenderListener;
        if (onRequestRenderListener != null) {
            onRequestRenderListener.onRequestRender();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int createProgram = createProgram(TextureRender.VERTEX_SHADER, TextureRender.FRAGMENT_SHADER);
        this.mProgram = createProgram;
        if (createProgram == 0) {
            return;
        }
        this.maPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
        checkGlError("glGetAttribLocation aPosition");
        if (this.maPositionHandle == -1) {
            CyberLog.e(TAG, "Could not get attrib location for aPosition");
            return;
        }
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        checkGlError("glGetAttribLocation aTextureCoord");
        if (this.maTextureHandle == -1) {
            CyberLog.e(TAG, "Could not get attrib location for aTextureCoord");
            return;
        }
        this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
        checkGlError("glGetUniformLocation uMVPMatrix");
        if (this.muMVPMatrixHandle == -1) {
            CyberLog.e(TAG, "Could not get attrib location for uMVPMatrix");
            return;
        }
        this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        checkGlError("glGetUniformLocation uSTMatrix");
        if (this.muMVPMatrixHandle == -1) {
            CyberLog.e(TAG, "Could not get attrib location for uSTMatrix");
            return;
        }
        GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
        GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener = this.mCyberSufaceListener;
        if (iCyberSurfaceListener != null && iCyberSurfaceListener.onSurfaceReady(0)) {
            synchronized (this.mSurfaceMonitor) {
                this.mUpdateSurface = false;
            }
        }
    }
}
