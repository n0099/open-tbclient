package com.baidu.searchbox.aideviceperformanceboxproxy.amendedstaticscore;

import com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreModelProvider;
import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
/* loaded from: classes3.dex */
public class DefaultAmendedDeviceScoreModelProvider implements IAmendedDeviceScoreModelProvider {
    @Override // com.baidu.searchbox.aideviceperformance.model.IDevicePerformanceModelInfoProvider
    public DevicePerformanceModelInfo getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType, DevicePerformanceModelInfo devicePerformanceModelInfo) {
        return devicePerformanceModelInfo;
    }
}
