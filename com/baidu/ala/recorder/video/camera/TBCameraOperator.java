package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.Matrix;
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
/* loaded from: classes9.dex */
public class TBCameraOperator implements ICameraOperator {
    private static final int DEFAULT_ROTATE = 0;
    private static final boolean IS_OPEN_TAG = false;
    private static final int MIN_SURFACE_CHANGE = 10;
    private static final String TAG = "LIVE_SDK_JNI";
    private WeakReference<Activity> mActivityReference;
    private int mCameraPreviewHeight;
    private int mCameraPreviewWidth;
    private SurfaceTexture mCameraTexture;
    private volatile AlaLiveVideoConfig mConfig;
    private int mDepthBuffer;
    private EglCore mEglCore;
    private int mFramebuffer;
    private AFullFrameRect mFullScreen;
    private int mFullScreenTexture;
    private int mOffscreenTexture;
    private RecorderHandler mRecorderHandler;
    private TextureViewListener.SurfaceHolder mSurfaceHolder;
    private Texture2dProgram mTexProgram;
    private int mWindowSurfaceWidth = 0;
    private int mWindowSurfaceHeight = 0;
    private AlaFrameTrack mPreviewFpsLimit = new AlaFrameTrack(15);
    private volatile int mBeautyLevel = 3;
    private int mCameraId = 1;
    private float[] mIdentityMatrix = new float[16];
    private float[] mMirrorIdentityMatrix = new float[16];
    private volatile boolean mIsMirror = false;
    private Camera.PreviewCallback mPreviewCallback = new Camera.PreviewCallback() { // from class: com.baidu.ala.recorder.video.camera.TBCameraOperator.1
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            camera.addCallbackBuffer(bArr);
            TBCameraOperator.this.frameAvailable();
        }
    };
    private ImageFilter.Output mImageFilterOutput = null;
    private ImageFilter mImageFilter = new ImageFilter() { // from class: com.baidu.ala.recorder.video.camera.TBCameraOperator.2
        @Override // com.baidu.ala.recorder.video.listener.ImageFilter
        public void setupImageOutput(ImageFilter.Output output) {
            TBCameraOperator.this.mImageFilterOutput = output;
        }

        @Override // com.baidu.ala.recorder.video.listener.ImageFilter
        public SurfaceTexture getCameraTexture() {
            return TBCameraOperator.this.mCameraTexture;
        }

        @Override // com.baidu.ala.recorder.video.listener.ImageFilter
        public Camera.PreviewCallback getCameraPreviewCallback() {
            return TBCameraOperator.this.mPreviewCallback;
        }
    };

    public TBCameraOperator(Activity activity, TextureViewListener.SurfaceHolder surfaceHolder, ICameraStatusHandler iCameraStatusHandler, RecorderHandler recorderHandler) {
        this.mActivityReference = null;
        this.mSurfaceHolder = surfaceHolder;
        this.mRecorderHandler = recorderHandler;
        this.mActivityReference = new WeakReference<>(activity);
        Matrix.setIdentityM(this.mIdentityMatrix, 0);
        AlaLiveUtilHelper.getTextureMatrix(this.mMirrorIdentityMatrix, 0.0f, false);
        this.mFullScreenTexture = -1;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public boolean onCameraOpened(Camera camera, int i, EglCore eglCore) {
        if (this.mActivityReference.get() == null) {
            return false;
        }
        if (this.mEglCore == null) {
            this.mEglCore = eglCore;
        }
        this.mCameraId = i;
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        this.mCameraPreviewWidth = previewSize.width;
        this.mCameraPreviewHeight = previewSize.height;
        if (this.mCameraTexture == null) {
            setupSurface(this.mSurfaceHolder);
        }
        return true;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public ImageFilter getImageFilter() {
        return this.mImageFilter;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void surfaceChanged(int i, int i2) {
        if (Math.abs(this.mWindowSurfaceHeight - i2) >= 10 || Math.abs(this.mWindowSurfaceWidth - i) >= 10) {
            if (this.mWindowSurfaceHeight > this.mWindowSurfaceWidth && i2 > i && this.mWindowSurfaceWidth > 0) {
                this.mWindowSurfaceHeight = i2;
                this.mWindowSurfaceWidth = i;
            } else if (this.mWindowSurfaceWidth > this.mWindowSurfaceHeight && i > i2 && this.mWindowSurfaceHeight > 0) {
                this.mWindowSurfaceHeight = i2;
                this.mWindowSurfaceWidth = i;
            } else {
                this.mWindowSurfaceWidth = i;
                this.mWindowSurfaceHeight = i2;
                resetTextures();
                setupSurface(this.mSurfaceHolder);
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setBeauty(int i) {
        if (i <= 5 && i >= 1) {
            this.mBeautyLevel = i;
        }
        if (this.mTexProgram != null) {
            this.mTexProgram.setBeautyLevel(this.mBeautyLevel);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public int hasBeauty() {
        return this.mBeautyLevel;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void willSwitchSense(int i) {
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
        resetTextures();
        GlUtil.checkGlError("releaseGl done");
        this.mCameraTexture = null;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (alaLiveVideoConfig != null) {
            this.mConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
        }
    }

    private void resetTextures() {
        GlUtil.checkGlError("resetTextures begin");
        try {
            if (this.mTexProgram != null) {
                this.mTexProgram.release();
                this.mTexProgram = null;
            }
            if (this.mCameraTexture != null) {
                this.mCameraTexture.release();
                this.mCameraTexture = null;
            }
            if (this.mFullScreen != null) {
                this.mFullScreen.release(false);
                this.mFullScreen = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlUtil.checkGlError("resetTextures end");
    }

    public void frameAvailable() {
        float[] fArr = new float[16];
        if (!this.mPreviewFpsLimit.trackFrame()) {
            this.mCameraTexture.updateTexImage();
            this.mCameraTexture.getTransformMatrix(fArr);
            return;
        }
        try {
            this.mCameraTexture.updateTexImage();
            this.mCameraTexture.getTransformMatrix(fArr);
            GLES20.glBindFramebuffer(36160, this.mFramebuffer);
            GlUtil.checkGlError("glBindFramebuffer");
            GlUtil.checkGlError("draw start");
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glClear(16384);
            GLES20.glViewport(0, 0, this.mCameraPreviewHeight, this.mCameraPreviewWidth);
            this.mFullScreen.drawFrame(this.mFullScreenTexture, fArr);
            GLES20.glBindFramebuffer(36160, 0);
            GlUtil.checkGlError("glBindFramebuffer");
            this.mImageFilterOutput.onImageDone(this.mOffscreenTexture, this.mIdentityMatrix, AlaNdkAdapter.getMediaStreamTS(true));
            GlUtil.checkGlError("draw done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupSurfaceFinish() {
        GLES20.glViewport(0, 0, this.mWindowSurfaceWidth, this.mWindowSurfaceHeight);
        prepareFramebuffer(this.mCameraPreviewHeight, this.mCameraPreviewWidth);
        GlUtil.checkGlError("setupSurfaceFinish done");
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

    private void setupSurface(TextureViewListener.SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            try {
                if (this.mWindowSurfaceHeight == 0 || this.mWindowSurfaceWidth == 0) {
                    this.mWindowSurfaceWidth = surfaceHolder.getSurfaceWidth();
                    this.mWindowSurfaceHeight = surfaceHolder.getSurfaceHeight();
                }
                if (this.mCameraTexture == null) {
                    if (this.mTexProgram == null) {
                        this.mTexProgram = new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT_MAGIC_2);
                    }
                    if (this.mFullScreen == null) {
                        this.mFullScreen = new AFullFrameRect(this.mTexProgram);
                    }
                    if (this.mCameraPreviewWidth > 0) {
                        this.mTexProgram.setInputWH(this.mCameraPreviewWidth, this.mCameraPreviewHeight);
                    }
                    this.mFullScreenTexture = GlUtil.createTextureOES();
                    this.mCameraTexture = new SurfaceTexture(this.mFullScreenTexture);
                    this.mTexProgram.setBeautyLevel(this.mBeautyLevel);
                    setupSurfaceFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
