package com.baidu.ala.recorder.video.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.view.Surface;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.VideoFormat;
/* loaded from: classes2.dex */
public interface ICameraOperator {
    Handler getDataThreadHandler();

    int getOutputHeight();

    int getOutputWidth();

    VideoFormat getVideoFormat();

    int hasBeauty();

    void initResource();

    boolean isPushMirror();

    boolean onCameraOpened(Camera camera, int i, int i2);

    void release();

    void setBeauty(int i);

    void setEncoderSurface(Surface surface);

    void setPreviewFps(int i);

    void setPreviewSize(int i, int i2);

    void setPushMirror(boolean z);

    void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig);

    void setVideoDataCallback(IVideoRecorder.IVideoDataCallBack iVideoDataCallBack);

    void startRecorderData();

    void surfaceChanged(int i, int i2);
}
