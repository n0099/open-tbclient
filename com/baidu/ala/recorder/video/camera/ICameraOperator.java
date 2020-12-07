package com.baidu.ala.recorder.video.camera;

import android.hardware.Camera;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.VideoFormat;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.listener.ImageFilter;
/* loaded from: classes9.dex */
public interface ICameraOperator {
    ImageFilter getImageFilter();

    VideoFormat getVideoFormat();

    int hasBeauty();

    boolean onCameraOpened(Camera camera, int i, EglCore eglCore);

    void release();

    void setBeauty(int i);

    void setPreviewFps(int i);

    void setPushMirror(boolean z);

    void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig);

    void surfaceChanged(int i, int i2);

    void willSwitchSense(int i);
}
