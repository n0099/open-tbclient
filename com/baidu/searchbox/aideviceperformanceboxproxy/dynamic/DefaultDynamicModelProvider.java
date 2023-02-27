package com.baidu.searchbox.aideviceperformanceboxproxy.dynamic;

import com.baidu.searchbox.aideviceperformance.dynamic.IDynamicModelProvider;
import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
/* loaded from: classes2.dex */
public class DefaultDynamicModelProvider implements IDynamicModelProvider {
    @Override // com.baidu.searchbox.aideviceperformance.model.IDevicePerformanceModelInfoProvider
    public DevicePerformanceModelInfo getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType, DevicePerformanceModelInfo devicePerformanceModelInfo) {
        return devicePerformanceModelInfo;
    }
}
