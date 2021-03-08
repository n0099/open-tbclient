package com.baidu.ala.recorder.video.camera;

import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
/* loaded from: classes5.dex */
public interface ICameraStatusHandler {

    /* loaded from: classes5.dex */
    public interface Beauty {
        boolean hasAdvancedBeauty();

        int hasBeauty();

        void setBeauty(int i);
    }

    int getDisplayRotate();

    boolean isBackCamera();

    boolean isFlashingLightOpen();

    void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig);

    void switchCamera();

    void switchFlashingLight();
}
