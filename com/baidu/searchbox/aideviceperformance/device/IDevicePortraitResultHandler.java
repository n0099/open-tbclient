package com.baidu.searchbox.aideviceperformance.device;
/* loaded from: classes2.dex */
public interface IDevicePortraitResultHandler {
    float getStaticPredictScore(float f);

    float getStaticScorePercent(float f);

    void putStaticPredictScore(float f);

    void putStaticScorePercent(float f);

    void removeStaticPredictScore();

    void removeStaticScorePercent();
}
