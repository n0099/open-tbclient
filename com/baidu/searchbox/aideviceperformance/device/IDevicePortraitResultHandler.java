package com.baidu.searchbox.aideviceperformance.device;
/* loaded from: classes10.dex */
public interface IDevicePortraitResultHandler {
    float getStaticPredictScore(float f2);

    float getStaticScorePercent(float f2);

    void putStaticPredictScore(float f2);

    void putStaticScorePercent(float f2);

    void removeStaticPredictScore();

    void removeStaticScorePercent();
}
