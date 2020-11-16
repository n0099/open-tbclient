package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.ala.helper.AlaFrameTrack;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.VideoFormat;
import com.baidu.ala.recorder.video.gles.AFullFrameRect;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ala.recorder.video.gles.Texture2dProgram;
import com.baidu.ala.recorder.video.listener.ImageFilter;
import com.baidu.ala.recorder.video.listener.TextureViewListener;
import java.lang.ref.WeakReference;
@TargetApi(16)
/* loaded from: classes15.dex */
public class GPUCameraOperator implements ICameraOperator {
    private static final int DEFAULT_ROTATE = 0;
    private static final int MAX_DROP_FIRST_FRAMES = 5;
    private static final int MIN_SURFACE_CHANGE = 10;
    private static final String TAG = "AlaLiveRecorder_GPU";
    private WeakReference<Activity> mActivityReference;
    private AFullFrameRect mCamFullScreen;
    private byte[] mCameraNV21Byte;
    private int mCameraPreviewHeight;
    private int mCameraPreviewWidth;
    private SurfaceTexture mCameraTexture;
    private int mCameraTxtId;
    private AlaLiveVideoConfig mConfig;
    private int mDepthBuffer;
    private EglCore mEglCore;
    private int mFramebuffer;
    private AFullFrameRect mOffFullScreen;
    private float[] mPreviewVertex;
    private RecorderHandler mRecorderHandler;
    private TextureViewListener.SurfaceHolder mSurfaceHolder;
    private boolean mVideoModelFit;
    private AlaFrameTrack mPreviewFpsLimit = new AlaFrameTrack(15);
    private int mWindowSurfaceWidth = 0;
    private int mWindowSurfaceHeight = 0;
    private int mDropFrames = 0;
    private volatile int mBeautyLevel = 3;
    private int mCameraId = 1;
    private int mOffscreenTexture = 0;
    private float[] mIdentityMatrix = new float[16];
    private float[] mIdentityMatrix90 = new float[16];
    private float[] mMirrorIdentityMatrix = new float[16];
    private float[] mMirrorIdentityMatrix90 = new float[16];
    private volatile boolean mIsMirror = false;
    private Camera.PreviewCallback mPreviewCallback = new Camera.PreviewCallback() { // from class: com.baidu.ala.recorder.video.camera.GPUCameraOperator.1
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            camera.addCallbackBuffer(bArr);
            GPUCameraOperator.this.mCameraNV21Byte = bArr;
            GPUCameraOperator.this.frameAvailable();
        }
    };
    private ImageFilter.Output mImageFilterOutput = null;
    private ImageFilter mImageFilter = new ImageFilter() { // from class: com.baidu.ala.recorder.video.camera.GPUCameraOperator.2
        @Override // com.baidu.ala.recorder.video.listener.ImageFilter
        public void setupImageOutput(ImageFilter.Output output) {
            GPUCameraOperator.this.mImageFilterOutput = output;
        }

        @Override // com.baidu.ala.recorder.video.listener.ImageFilter
        public SurfaceTexture getCameraTexture() {
            return GPUCameraOperator.this.mCameraTexture;
        }

        @Override // com.baidu.ala.recorder.video.listener.ImageFilter
        public Camera.PreviewCallback getCameraPreviewCallback() {
            return GPUCameraOperator.this.mPreviewCallback;
        }
    };

    public GPUCameraOperator(Activity activity, TextureViewListener.SurfaceHolder surfaceHolder, ICameraStatusHandler iCameraStatusHandler, RecorderHandler recorderHandler) {
        this.mActivityReference = null;
        this.mSurfaceHolder = surfaceHolder;
        this.mRecorderHandler = recorderHandler;
        this.mActivityReference = new WeakReference<>(activity);
        Matrix.setIdentityM(this.mIdentityMatrix, 0);
        AlaLiveUtilHelper.getTextureMatrix(this.mIdentityMatrix90, 90.0f, true);
        AlaLiveUtilHelper.getTextureMatrix(this.mMirrorIdentityMatrix, 0.0f, false);
        AlaLiveUtilHelper.getTextureMatrix(this.mMirrorIdentityMatrix90, 90.0f, false);
        this.mPreviewVertex = new float[8];
        this.mVideoModelFit = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void frameAvailable() {
        float[] fArr = new float[16];
        try {
            this.mCameraTexture.updateTexImage();
            this.mCameraTexture.getTransformMatrix(fArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mPreviewFpsLimit.trackFrame()) {
            try {
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0) {
                    Log.e(TAG, "camera nv21 bytes null");
                } else {
                    GLES20.glBindFramebuffer(36160, this.mFramebuffer);
                    GlUtil.checkGlError("glBindFramebuffer");
                    GLES20.glViewport(0, 0, this.mCameraPreviewHeight, this.mCameraPreviewWidth);
                    this.mCamFullScreen.drawFrame2(this.mCameraTxtId, fArr);
                    if (this.mDropFrames < 5) {
                        this.mDropFrames++;
                    } else {
                        this.mImageFilterOutput.onImageDone(this.mOffscreenTexture, this.mIdentityMatrix, AlaNdkAdapter.getMediaStreamTS(true));
                        GlUtil.checkGlError("draw done");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public boolean onCameraOpened(Camera camera, int i, EglCore eglCore) {
        if (this.mActivityReference.get() == null) {
            return false;
        }
        this.mCameraId = i;
        this.mDropFrames = 0;
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        this.mCameraPreviewWidth = previewSize.width;
        this.mCameraPreviewHeight = previewSize.height;
        initResource(eglCore);
        if (this.mCameraTexture == null) {
            setupSurface(this.mSurfaceHolder);
        }
        return true;
    }

    private void setupSurface(TextureViewListener.SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            try {
                if (this.mWindowSurfaceHeight == 0 || this.mWindowSurfaceWidth == 0) {
                    this.mWindowSurfaceWidth = surfaceHolder.getSurfaceWidth();
                    this.mWindowSurfaceHeight = surfaceHolder.getSurfaceHeight();
                }
                if (this.mOffFullScreen == null) {
                    this.mOffFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                }
                if (this.mCamFullScreen == null) {
                    this.mCamFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                }
                if (this.mCameraTexture == null) {
                    this.mCameraTxtId = GlUtil.createTextureOES();
                    this.mCameraTexture = new SurfaceTexture(this.mCameraTxtId);
                    setupSurfaceFinish();
                }
            } catch (Exception e) {
                if (this.mRecorderHandler != null) {
                    this.mRecorderHandler.sendError(3, "create window surface --" + e.getMessage());
                }
            }
        }
    }

    private void setupSurfaceFinish() {
        GLES20.glViewport(0, 0, this.mWindowSurfaceWidth, this.mWindowSurfaceHeight);
        updateGeometry();
        prepareFramebuffer(this.mCameraPreviewHeight, this.mCameraPreviewWidth);
    }

    private void prepareFramebuffer(int i, int i2) {
        int[] iArr = new int[1];
        if (this.mOffscreenTexture > 0) {
            iArr[0] = this.mOffscreenTexture;
            GLES20.glDeleteTextures(1, iArr, 0);
            this.mOffscreenTexture = -1;
        }
        if (this.mFramebuffer > 0) {
            iArr[0] = this.mFramebuffer;
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            this.mFramebuffer = -1;
        }
        if (this.mDepthBuffer > 0) {
            iArr[0] = this.mDepthBuffer;
            GLES20.glDeleteRenderbuffers(1, iArr, 0);
            this.mDepthBuffer = -1;
        }
        GlUtil.checkGlError("prepareFramebuffer start");
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        this.mOffscreenTexture = iArr[0];
        GLES20.glBindTexture(3553, this.mOffscreenTexture);
        GlUtil.checkGlError("glBindTexture " + this.mOffscreenTexture);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        GLES20.glGenFramebuffers(1, iArr, 0);
        GlUtil.checkGlError("glGenFramebuffers");
        this.mFramebuffer = iArr[0];
        GLES20.glBindFramebuffer(36160, this.mFramebuffer);
        GlUtil.checkGlError("glBindFramebuffer " + this.mFramebuffer);
        GLES20.glGenRenderbuffers(1, iArr, 0);
        GlUtil.checkGlError("glGenRenderbuffers");
        this.mDepthBuffer = iArr[0];
        GLES20.glBindRenderbuffer(36161, this.mDepthBuffer);
        GlUtil.checkGlError("glBindRenderbuffer " + this.mDepthBuffer);
        GLES20.glRenderbufferStorage(36161, 33189, i, i2);
        GlUtil.checkGlError("glRenderbufferStorage");
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mDepthBuffer);
        GlUtil.checkGlError("glFramebufferRenderbuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOffscreenTexture, 0);
        GlUtil.checkGlError("glFramebufferTexture2D");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            throw new RuntimeException("Framebuffer not complete, status=" + glCheckFramebufferStatus);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkGlError("prepareFramebuffer done");
    }

    private void updateGeometry() {
        boolean z;
        if (this.mOffFullScreen != null && this.mOffFullScreen.getVertexCount() == 4) {
            if (isLandscape()) {
                z = false;
            } else {
                z = true;
            }
            this.mPreviewVertex = AlaLiveUtilHelper.getVertexArray(this.mWindowSurfaceWidth, this.mWindowSurfaceHeight, z ? this.mCameraPreviewHeight : this.mCameraPreviewWidth, z ? this.mCameraPreviewWidth : this.mCameraPreviewHeight, this.mVideoModelFit);
            this.mOffFullScreen.resetVertexArray(this.mPreviewVertex);
        }
    }

    private boolean isLandscape() {
        if (this.mActivityReference.get() == null || this.mActivityReference.get().getResources().getConfiguration().orientation != 2) {
            return false;
        }
        return true;
    }

    private void resetTextures() {
        GlUtil.checkGlError("resetTextures begin");
        if (this.mOffFullScreen != null) {
            this.mOffFullScreen.release(true);
            this.mOffFullScreen = null;
        }
        if (this.mCamFullScreen != null) {
            this.mCamFullScreen.release(true);
            this.mCamFullScreen = null;
        }
        if (this.mCameraTexture != null) {
            this.mCameraTexture.release();
            this.mCameraTexture = null;
        }
        GlUtil.checkGlError("resetTextures end");
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void surfaceChanged(int i, int i2) {
        if (this.mEglCore != null) {
            if (Math.abs(this.mWindowSurfaceHeight - i2) >= 10 || Math.abs(this.mWindowSurfaceWidth - i) >= 10) {
                if (this.mWindowSurfaceHeight > this.mWindowSurfaceWidth && i2 > i && this.mWindowSurfaceWidth > 0) {
                    this.mWindowSurfaceHeight = i2;
                    this.mWindowSurfaceWidth = i;
                    updateGeometry();
                } else if (this.mWindowSurfaceWidth > this.mWindowSurfaceHeight && i > i2 && this.mWindowSurfaceHeight > 0) {
                    this.mWindowSurfaceHeight = i2;
                    this.mWindowSurfaceWidth = i;
                    updateGeometry();
                } else {
                    this.mWindowSurfaceWidth = i;
                    this.mWindowSurfaceHeight = i2;
                    resetTextures();
                    setupSurface(this.mSurfaceHolder);
                }
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setBeauty(int i) {
        this.mBeautyLevel = i;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public int hasBeauty() {
        return this.mBeautyLevel;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void willSwitchSense(int i) {
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public ImageFilter getImageFilter() {
        return this.mImageFilter;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public VideoFormat getVideoFormat() {
        return VideoFormat.RGBA;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void release() {
        if (this.mRecorderHandler != null) {
            this.mRecorderHandler.removeCallbacksAndMessages(null);
            this.mRecorderHandler = null;
        }
        GlUtil.checkGlError("releaseGl start");
        resetTextures();
        GlUtil.checkGlError("releaseGl done");
    }

    private void initResource(EglCore eglCore) {
        if (this.mEglCore == null) {
            this.mEglCore = eglCore;
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPushMirror(boolean z) {
        this.mIsMirror = z;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPreviewFps(int i) {
        if (i > 0) {
            this.mPreviewFpsLimit.setLimitFps(i);
        }
    }
}
