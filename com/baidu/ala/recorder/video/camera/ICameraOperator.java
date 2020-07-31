package com.baidu.ala.recorder.video.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.VideoFormat;
/* loaded from: classes7.dex */
public interface ICameraOperator {
    int getOutputHeight();

    int getOutputWidth();

    Camera.PreviewCallback getPreviewCallback();

    SurfaceTexture getSurfaceTexture();

    VideoFormat getVideoFormat();

    int hasBeauty();

    boolean onCameraOpened(Camera camera, int i);

    void release();

    void setBeauty(int i);

    void setPreviewFps(int i);

    void setPreviewSize(int i, int i2);

    void setPushMirror(boolean z);

    void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig);

    void setVideoDataCallback(IVideoRecorder.IVideoDataCallBack iVideoDataCallBack);

    void surfaceChanged(int i, int i2);

    void willSwitchSense(int i);
}
