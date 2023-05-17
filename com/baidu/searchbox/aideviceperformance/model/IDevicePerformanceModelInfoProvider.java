package com.baidu.searchbox.aideviceperformance.model;

import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
/* loaded from: classes3.dex */
public interface IDevicePerformanceModelInfoProvider {
    DevicePerformanceModelInfo getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType, DevicePerformanceModelInfo devicePerformanceModelInfo);
}
