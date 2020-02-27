package com.baidu.ala.recorder.video.camera;

import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
/* loaded from: classes3.dex */
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
