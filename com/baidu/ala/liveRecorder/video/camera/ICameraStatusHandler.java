package com.baidu.ala.liveRecorder.video.camera;

import com.baidu.ala.liveRecorder.video.AlaLiveVideoConfig;
/* loaded from: classes6.dex */
public interface ICameraStatusHandler {
    int getDisplayRotate();

    boolean hasAdvancedBeauty();

    int hasBeauty();

    boolean isBackCamera();

    boolean isFlashingLightOpen();

    void setBeauty(int i);

    void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig);

    void switchCamera();

    void switchFlashingLight();
}
