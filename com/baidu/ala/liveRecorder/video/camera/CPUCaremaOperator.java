package com.baidu.ala.liveRecorder.video.camera;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Handler;
import android.view.Surface;
import com.baidu.ala.helper.AlaFrameTrack;
import com.baidu.ala.liveRecorder.video.AlaLiveVideoConfig;
import com.baidu.ala.liveRecorder.video.IVideoRecorder;
import com.baidu.ala.liveRecorder.video.VideoFormat;
import com.baidu.ala.liveRecorder.video.camera.AlaCameraRecorder;
import com.baidu.live.adp.lib.util.BdLog;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.Array;
/* loaded from: classes6.dex */
public class CPUCaremaOperator implements ICameraOperator {
    private static final int PREVIEW_BUFFER_COUNT = 3;
    private Activity mActivity;
    private Camera mCamera;
    private ICameraStatusHandler mCameraStatusHandler;
    private byte[][] mPreviewCallbackBuffer;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private AlaCameraRecorder.SurfaceHolder mSurfaceHolder;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallback;
    private long lasttime = 0;
    private int mFps = 0;
    private AlaFrameTrack mPreviewFpsLimit = new AlaFrameTrack(15);

    static /* synthetic */ int access$108(CPUCaremaOperator cPUCaremaOperator) {
        int i = cPUCaremaOperator.mFps;
        cPUCaremaOperator.mFps = i + 1;
        return i;
    }

    public CPUCaremaOperator(Activity activity, Camera camera, AlaCameraRecorder.SurfaceHolder surfaceHolder, ICameraStatusHandler iCameraStatusHandler, IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        this.mActivity = activity;
        this.mCamera = camera;
        this.mSurfaceHolder = surfaceHolder;
        this.mCameraStatusHandler = iCameraStatusHandler;
        this.mVideoDataCallback = iVideoDataCallBack;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void setBeauty(int i) {
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public int hasBeauty() {
        return -1;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void setVideoDataCallback(IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        this.mVideoDataCallback = iVideoDataCallBack;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public int getOutputWidth() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public int getOutputHeight() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public VideoFormat getVideoFormat() {
        return VideoFormat.NV21;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public boolean onCameraOpened(Camera camera, int i, final int i2) {
        this.mCamera = camera;
        this.mCamera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: com.baidu.ala.liveRecorder.video.camera.CPUCaremaOperator.1
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera2) {
                int i3 = 0;
                if (CPUCaremaOperator.this.lasttime == 0) {
                    CPUCaremaOperator.this.lasttime = System.currentTimeMillis();
                }
                CPUCaremaOperator.access$108(CPUCaremaOperator.this);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - CPUCaremaOperator.this.lasttime > 1000) {
                    CPUCaremaOperator.this.lasttime = currentTimeMillis;
                    CPUCaremaOperator.this.mFps = 0;
                }
                if (bArr != null) {
                    if (bArr.length == i2) {
                        if (CPUCaremaOperator.this.mVideoDataCallback != null && CPUCaremaOperator.this.mPreviewFpsLimit.trackFrame()) {
                            if (CPUCaremaOperator.this.mCameraStatusHandler != null) {
                                i3 = CPUCaremaOperator.this.mCameraStatusHandler.getDisplayRotate();
                                if (!CPUCaremaOperator.this.mCameraStatusHandler.isBackCamera() && !CPUCaremaOperator.this.mVideoConfig.isLandscape()) {
                                    i3 = (i3 + SubsamplingScaleImageView.ORIENTATION_180) % 360;
                                }
                            }
                            if (CPUCaremaOperator.this.mVideoDataCallback != null) {
                                CPUCaremaOperator.this.mVideoDataCallback.onRawVideoFrameReceived(bArr, bArr.length, i3, CPUCaremaOperator.this.mVideoConfig.isLandscape() ? CPUCaremaOperator.this.mVideoConfig.getPreviewHeight() : CPUCaremaOperator.this.mVideoConfig.getPreviewWidth());
                            }
                        }
                    } else {
                        BdLog.e("onPreviewFrame data.length!=bufferLength");
                    }
                    CPUCaremaOperator.this.mCamera.addCallbackBuffer(bArr);
                }
            }
        });
        int previewWidth = (int) (this.mVideoConfig.getPreviewWidth() * this.mVideoConfig.getPreviewHeight() * 1.5d);
        try {
            createPreviewCallbackBuffer();
            for (int i3 = 0; i3 < 3; i3++) {
                this.mCamera.addCallbackBuffer(this.mPreviewCallbackBuffer[i3]);
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
        try {
            Thread.sleep(100L);
            this.mCamera.setPreviewTexture(this.mSurfaceHolder.getSurfaceTexture());
            this.mCamera.startPreview();
            return true;
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void release() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallbackWithBuffer(null);
        }
    }

    private void createPreviewCallbackBuffer() {
        if (this.mPreviewCallbackBuffer == null) {
            try {
                this.mPreviewCallbackBuffer = (byte[][]) Array.newInstance(Byte.TYPE, 3, (int) (this.mVideoConfig.getPreviewWidth() * this.mVideoConfig.getPreviewHeight() * 1.5d));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void setEncoderSurface(Surface surface) {
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void surfaceChanged(int i, int i2) {
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public Handler getDataThreadHandler() {
        return null;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void initResource() {
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void startRecorderData() {
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void setPushMirror(boolean z) {
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public boolean isPushMirror() {
        return false;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraOperator
    public void setPreviewFps(int i) {
        if (i > 0) {
            this.mPreviewFpsLimit.setLimitFps(i);
        }
    }
}
