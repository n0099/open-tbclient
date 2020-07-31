package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.baidu.ala.helper.AlaFrameTrack;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.VideoFormat;
import com.baidu.ala.recorder.video.camera.AlaCameraRecorder;
import com.baidu.live.adp.lib.util.BdLog;
@TargetApi(16)
/* loaded from: classes7.dex */
public class CPUCaremaOperator implements ICameraOperator {
    private Activity mActivity;
    private Camera mCamera;
    private ICameraStatusHandler mCameraStatusHandler;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private AlaCameraRecorder.SurfaceHolder mSurfaceHolder;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallback;
    private long lasttime = 0;
    private int mFps = 0;
    private AlaFrameTrack mPreviewFpsLimit = new AlaFrameTrack(15);
    private Camera.PreviewCallback mPreviewCallback = new Camera.PreviewCallback() { // from class: com.baidu.ala.recorder.video.camera.CPUCaremaOperator.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            camera.addCallbackBuffer(bArr);
        }
    };

    static /* synthetic */ int access$108(CPUCaremaOperator cPUCaremaOperator) {
        int i = cPUCaremaOperator.mFps;
        cPUCaremaOperator.mFps = i + 1;
        return i;
    }

    public CPUCaremaOperator(Activity activity, AlaCameraRecorder.SurfaceHolder surfaceHolder, ICameraStatusHandler iCameraStatusHandler, IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        this.mActivity = activity;
        this.mSurfaceHolder = surfaceHolder;
        this.mCameraStatusHandler = iCameraStatusHandler;
        this.mVideoDataCallback = iVideoDataCallBack;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setBeauty(int i) {
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public int hasBeauty() {
        return -1;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setVideoDataCallback(IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        this.mVideoDataCallback = iVideoDataCallBack;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public int getOutputWidth() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public int getOutputHeight() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void willSwitchSense(int i) {
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public VideoFormat getVideoFormat() {
        return VideoFormat.NV21;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public boolean onCameraOpened(Camera camera, int i) {
        this.mCamera = camera;
        final int previewWidth = this.mVideoConfig.getPreviewWidth() * this.mVideoConfig.getPreviewHeight();
        this.mCamera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: com.baidu.ala.recorder.video.camera.CPUCaremaOperator.1
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera2) {
                int i2 = 0;
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
                    if (bArr.length == previewWidth) {
                        if (CPUCaremaOperator.this.mVideoDataCallback != null && CPUCaremaOperator.this.mPreviewFpsLimit.trackFrame()) {
                            if (CPUCaremaOperator.this.mCameraStatusHandler != null) {
                                i2 = CPUCaremaOperator.this.mCameraStatusHandler.getDisplayRotate();
                                if (!CPUCaremaOperator.this.mCameraStatusHandler.isBackCamera() && !CPUCaremaOperator.this.mVideoConfig.isLandscape()) {
                                    i2 = (i2 + 180) % 360;
                                }
                            }
                            if (CPUCaremaOperator.this.mVideoDataCallback != null) {
                                CPUCaremaOperator.this.mVideoDataCallback.onRawVideoFrameReceived(bArr, bArr.length, i2, CPUCaremaOperator.this.mVideoConfig.isLandscape() ? CPUCaremaOperator.this.mVideoConfig.getPreviewHeight() : CPUCaremaOperator.this.mVideoConfig.getPreviewWidth());
                            }
                        }
                    } else {
                        BdLog.e("onPreviewFrame data.length!=bufferLength");
                    }
                    CPUCaremaOperator.this.mCamera.addCallbackBuffer(bArr);
                }
            }
        });
        return true;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public Camera.PreviewCallback getPreviewCallback() {
        return this.mPreviewCallback;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void release() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallbackWithBuffer(null);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void surfaceChanged(int i, int i2) {
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPushMirror(boolean z) {
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPreviewFps(int i) {
        if (i > 0) {
            this.mPreviewFpsLimit.setLimitFps(i);
        }
    }
}
