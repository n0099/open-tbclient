package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig;
/* loaded from: classes2.dex */
public class DefaultIDevicePortraitThresholdsConfigProxy implements IDevicePortraitThresholdsConfig {
    public static float sThresholdLowMid = -1.0f;
    public static float sThresholdMidHigh = -1.0f;

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig
    public float getThresholdLowMid() {
        if (sThresholdLowMid < 0.0f) {
            sThresholdLowMid = 0.35f;
        }
        return sThresholdLowMid;
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig
    public float getThresholdMidHigh() {
        if (sThresholdMidHigh < 0.0f) {
            sThresholdMidHigh = 0.6f;
        }
        return sThresholdMidHigh;
    }
}
