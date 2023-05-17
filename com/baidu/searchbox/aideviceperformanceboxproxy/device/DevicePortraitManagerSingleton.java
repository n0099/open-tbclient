package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager;
import com.baidu.searchbox.aideviceperformanceboxproxy.model.ModelProviderRuntime;
/* loaded from: classes3.dex */
public class DevicePortraitManagerSingleton extends DevicePortraitManager {
    public static DevicePortraitManagerSingleton sInstance = new DevicePortraitManagerSingleton();

    public DevicePortraitManagerSingleton() {
        super(DevicePortraitRuntime.getDefaultResultHandler(), DevicePortraitRuntime.getDefaultThresholdsConfig(), ModelProviderRuntime.deviceInfoModelProvider());
    }

    public static DevicePortraitManagerSingleton getInstance() {
        return sInstance;
    }
}
