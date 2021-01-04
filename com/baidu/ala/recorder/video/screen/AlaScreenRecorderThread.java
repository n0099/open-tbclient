package com.baidu.ala.recorder.video.screen;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.helper.AlaFrameTrack;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.gles.AFullFrameRect;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ala.recorder.video.gles.Texture2dProgram;
import com.baidu.ala.tbadk.core.TbadkCoreApplicationProxy;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes15.dex */
public class AlaScreenRecorderThread extends Thread {
    private static final String TAG = "ScreenRecorder";
    private volatile Handler mDataThreadHandler;
    private HandlerThread mHandlerThread;
    private ImageReader mImageReader;
    private int mImgLineSize;
    private volatile boolean mIsQuit;
    private volatile boolean mIsVideoThreadRun;
    private volatile RecorderHandler mMainHandler;
    private MediaProjection mMediaProjection;
    private volatile AlaScreenRecorderHandler mRenderHandler;
    private RenderWindow mRenderWindow;
    private byte[] mSendBuffer;
    private Surface mSurface;
    private volatile boolean mUseHard;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallback;
    private VirtualDisplay mVirtualDisplay;

    public AlaScreenRecorderThread(Surface surface, MediaProjection mediaProjection, IVideoRecorder.IVideoDataCallBack iVideoDataCallBack, RecorderHandler recorderHandler, boolean z) {
        super(TAG);
        this.mImgLineSize = 0;
        this.mIsVideoThreadRun = false;
        this.mMainHandler = null;
        this.mUseHard = true;
        this.mDataThreadHandler = null;
        this.mIsQuit = false;
        this.mSurface = surface;
        this.mMediaProjection = mediaProjection;
        this.mVideoDataCallback = iVideoDataCallBack;
        this.mMainHandler = recorderHandler;
        this.mUseHard = z;
        this.mIsQuit = false;
    }

    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
    }

    public final void quit() {
        this.mIsQuit = true;
        if (this.mRenderHandler != null && this.mRenderHandler.getLooper() != null) {
            this.mRenderHandler.getLooper().quit();
        }
        this.mRenderHandler = null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    @TargetApi(21)
    public void run() {
        Looper.prepare();
        int videoHeight = this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoHeight() : this.mVideoConfig.getVideoWidth();
        int videoWidth = this.mVideoConfig.isLandscape() ? this.mVideoConfig.getVideoWidth() : this.mVideoConfig.getVideoHeight();
        this.mRenderHandler = new AlaScreenRecorderHandler(this);
        this.mRenderWindow = new RenderWindow(this.mSurface, videoHeight, videoWidth);
        try {
            try {
                prepareEncoder();
                if (!this.mIsQuit) {
                    this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("ScreenRecorder-display", videoHeight, videoWidth, TbadkCoreApplicationProxy.getInst().getAppContext().getResources().getDisplayMetrics().densityDpi, 1, this.mRenderWindow.getSurface(), null, null);
                    this.mIsVideoThreadRun = true;
                    Looper.loop();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } finally {
            release();
        }
    }

    @TargetApi(19)
    private void prepareEncoder() throws IOException {
        if (!this.mUseHard) {
            this.mImageReader = ImageReader.newInstance(this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight(), 1, 1);
            this.mHandlerThread = new HandlerThread("ala_live_recorder_screen");
            this.mHandlerThread.start();
            this.mDataThreadHandler = new Handler(this.mHandlerThread.getLooper());
            this.mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.baidu.ala.recorder.video.screen.AlaScreenRecorderThread.1
                @Override // android.media.ImageReader.OnImageAvailableListener
                public void onImageAvailable(ImageReader imageReader) {
                    Image image;
                    try {
                        image = AlaScreenRecorderThread.this.mImageReader.acquireNextImage();
                    } catch (UnsupportedOperationException e) {
                        if (AlaScreenRecorderThread.this.mMainHandler != null) {
                            AlaScreenRecorderThread.this.mMainHandler.sendError(1, e.getMessage());
                        }
                        AlaScreenRecorderThread.this.quit();
                        image = null;
                    }
                    if (image != null) {
                        if (!AlaScreenRecorderThread.this.mIsVideoThreadRun) {
                            image.close();
                            return;
                        }
                        try {
                            ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                            if (buffer == null) {
                                image.close();
                                return;
                            }
                            AlaScreenRecorderThread.this.mImgLineSize = (image.getPlanes()[0].getRowStride() / image.getPlanes()[0].getPixelStride()) * 4;
                            buffer.rewind();
                            int remaining = buffer.remaining();
                            try {
                                if (AlaScreenRecorderThread.this.mSendBuffer == null || AlaScreenRecorderThread.this.mSendBuffer.length < remaining) {
                                    AlaScreenRecorderThread.this.mSendBuffer = new byte[remaining];
                                }
                                buffer.get(AlaScreenRecorderThread.this.mSendBuffer);
                                image.close();
                                if (AlaScreenRecorderThread.this.mVideoDataCallback != null) {
                                    AlaScreenRecorderThread.this.mVideoDataCallback.onRawVideoFrameReceived(AlaScreenRecorderThread.this.mSendBuffer, remaining, 0, AlaScreenRecorderThread.this.mImgLineSize, AlaNdkAdapter.getMediaStreamTS(false));
                                }
                            } catch (OutOfMemoryError e2) {
                            }
                        } catch (IllegalStateException e3) {
                            image.close();
                        }
                    }
                }
            }, this.mDataThreadHandler);
            this.mSurface = this.mImageReader.getSurface();
        }
    }

    @TargetApi(21)
    private void release() {
        this.mIsVideoThreadRun = false;
        this.mRenderHandler = null;
        if (this.mDataThreadHandler != null) {
            this.mDataThreadHandler.removeCallbacksAndMessages(null);
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.getLooper().quit();
        }
        if (this.mImageReader != null) {
            this.mImageReader.close();
            this.mImageReader = null;
        }
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.release();
            this.mVirtualDisplay = null;
        }
        if (this.mRenderWindow != null) {
            this.mRenderWindow.destory();
            this.mRenderWindow = null;
        }
        this.mMediaProjection = null;
    }

    public boolean isVideoThreadRun() {
        return this.mIsVideoThreadRun;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIsVideoThreadRun(boolean z) {
        this.mIsVideoThreadRun = z;
    }

    public AlaScreenRecorderHandler getRenderHandler() {
        return this.mRenderHandler;
    }

    public Handler getDataThreadHandler() {
        return this.mDataThreadHandler == null ? this.mRenderHandler : this.mDataThreadHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class RenderWindow {
        private static final int MAX_FPS = 30;
        private AFullFrameRect mFullScreen;
        private int mInputHeight;
        private int mInputWidth;
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private SurfaceTexture.OnFrameAvailableListener mSurfaceTextureListener;
        private int mTexture;
        private AlaFrameTrack mTrack = new AlaFrameTrack(30);
        private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
        private EGLContext mEGLContextEncoder = EGL14.EGL_NO_CONTEXT;
        private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
        private EGLSurface mEGLSurfaceEncoder = EGL14.EGL_NO_SURFACE;

        public RenderWindow(Surface surface, int i, int i2) {
            try {
                init(surface, i, i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void destory() {
            try {
                uninit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private int init(Surface surface, int i, int i2) {
            this.mSurfaceTextureListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.ala.recorder.video.screen.AlaScreenRecorderThread.RenderWindow.1
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    try {
                        RenderWindow.this.makeCurrent(1);
                        surfaceTexture.updateTexImage();
                        if (RenderWindow.this.mTrack.trackFrame()) {
                            RenderWindow.this.draw();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            this.mInputWidth = i;
            this.mInputHeight = i2;
            eglSetup(surface);
            GlUtil.checkGlError("init begin");
            makeCurrent();
            this.mTexture = createTexture();
            GlUtil.checkGlError("generate texture");
            this.mSurfaceTexture = new SurfaceTexture(this.mTexture);
            this.mSurfaceTexture.setDefaultBufferSize(this.mInputWidth, this.mInputHeight);
            this.mSurfaceTexture.setOnFrameAvailableListener(this.mSurfaceTextureListener);
            this.mSurface = new Surface(this.mSurfaceTexture);
            this.mFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            GlUtil.checkGlError("build Program");
            return 0;
        }

        private int uninit() {
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            if (this.mTexture > 0) {
                GLES20.glDeleteTextures(1, new int[]{this.mTexture}, 0);
                this.mTexture = 0;
            }
            if (this.mSurface != null) {
                this.mSurface.release();
                this.mSurface = null;
            }
            if (this.mFullScreen != null) {
                this.mFullScreen.release(true);
                this.mFullScreen = null;
            }
            return 0;
        }

        public void draw() {
            try {
                GlUtil.checkGlError("draw start");
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                GlUtil.checkGlError("draw makeCurrent");
                this.mSurfaceTexture.getTransformMatrix(fArr);
                this.mFullScreen.drawFrame(this.mTexture, fArr);
                GlUtil.checkGlError("draw drawFrame");
                setPresentationTime(this.mSurfaceTexture.getTimestamp());
                swapBuffers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        private static int createTexture() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glTexParameteri(36197, 10241, 9729);
            GLES20.glTexParameteri(36197, 10240, 9729);
            GlUtil.checkGlError("generate texture");
            return iArr[0];
        }

        private void eglSetup(Surface surface) {
            this.mEGLDisplay = EGL14.eglGetDisplay(0);
            if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
                this.mEGLDisplay = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            EGLConfig config = getConfig(2);
            int[] iArr2 = {12440, 2, 12344};
            this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, iArr2, 0);
            GlUtil.checkGlError("eglCreateContext");
            if (this.mEGLContext == null) {
                throw new RuntimeException("null context");
            }
            this.mEGLContextEncoder = EGL14.eglCreateContext(this.mEGLDisplay, config, this.mEGLContext, iArr2, 0);
            GlUtil.checkGlError("eglCreateContext");
            if (this.mEGLContextEncoder == null) {
                throw new RuntimeException("null context2");
            }
            this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, eGLConfigArr[0], new int[]{12375, this.mInputWidth, 12374, this.mInputHeight, 12344}, 0);
            GlUtil.checkGlError("eglCreatePbufferSurface");
            if (this.mEGLSurface == null) {
                throw new RuntimeException("surface was null");
            }
            this.mEGLSurfaceEncoder = EGL14.eglCreateWindowSurface(this.mEGLDisplay, config, surface, new int[]{12344}, 0);
            GlUtil.checkGlError("eglCreateWindowSurface");
            if (this.mEGLSurfaceEncoder == null) {
                throw new RuntimeException("surface was null");
            }
        }

        private EGLConfig getConfig(int i) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i >= 3 ? 68 : 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w(AlaScreenRecorderThread.TAG, "unable to find RGB8888 / " + i + " EGLConfig");
            return null;
        }

        public void makeCurrent() {
            if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }

        public void makeCurrent(int i) {
            if (i == 0) {
                if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext)) {
                    throw new RuntimeException("eglMakeCurrent failed");
                }
            } else if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurfaceEncoder, this.mEGLSurfaceEncoder, this.mEGLContextEncoder)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }

        public void setPresentationTime(long j) {
            EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurfaceEncoder, j);
            GlUtil.checkGlError("eglPresentationTimeANDROID");
        }

        public boolean swapBuffers() {
            boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurfaceEncoder);
            GlUtil.checkGlError("eglSwapBuffers");
            return eglSwapBuffers;
        }
    }
}
