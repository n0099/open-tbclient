package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
/* loaded from: classes2.dex */
public class DefaultDevicePortraitResultHandler implements IDevicePortraitResultHandler {
    public static final String SP_KEY_STATIC_SCORE = "static_predict_score";
    public static final String SP_KEY_STATIC_SCORE_PERCENTAGE = "static_score_percent";

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public void removeStaticPredictScore() {
        DeviceInfoSharedPreferenceWrapper.getInstance().remove(SP_KEY_STATIC_SCORE);
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public void removeStaticScorePercent() {
        DeviceInfoSharedPreferenceWrapper.getInstance().remove(SP_KEY_STATIC_SCORE_PERCENTAGE);
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public float getStaticPredictScore(float f) {
        return DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(SP_KEY_STATIC_SCORE, -1.0f);
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public float getStaticScorePercent(float f) {
        return DeviceInfoSharedPreferenceWrapper.getInstance().getFloat(SP_KEY_STATIC_SCORE_PERCENTAGE, -1.0f);
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public void putStaticPredictScore(float f) {
        DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(SP_KEY_STATIC_SCORE, f);
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler
    public void putStaticScorePercent(float f) {
        DeviceInfoSharedPreferenceWrapper.getInstance().putFloat(SP_KEY_STATIC_SCORE_PERCENTAGE, f);
    }
}
