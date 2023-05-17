package com.baidu.searchbox.aideviceperformance.device;

import android.content.Context;
/* loaded from: classes3.dex */
public interface IDevicePortraitManager {

    /* loaded from: classes3.dex */
    public enum ThresholdType {
        LOW_MID,
        MID_HIGH
    }

    float getDefaultScoreThreshold(ThresholdType thresholdType);

    float getStaticDeviceScore(Context context);

    float getStaticDeviceScorePercentage(Context context);
}
