package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.searchbox.aideviceperformance.device.IDeviceInfoModelProvider;
import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
/* loaded from: classes3.dex */
public class DefaultDeviceInfoModelProvider implements IDeviceInfoModelProvider {
    @Override // com.baidu.searchbox.aideviceperformance.model.IDevicePerformanceModelInfoProvider
    public DevicePerformanceModelInfo getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType, DevicePerformanceModelInfo devicePerformanceModelInfo) {
        return devicePerformanceModelInfo;
    }
}
