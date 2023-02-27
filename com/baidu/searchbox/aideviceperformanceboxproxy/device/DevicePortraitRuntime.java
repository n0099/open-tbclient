package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig;
@Autowired
/* loaded from: classes2.dex */
public class DevicePortraitRuntime {
    @Inject(force = false)
    public static IDevicePortraitResultHandler getDefaultResultHandler() {
        return new DefaultDevicePortraitResultHandler();
    }

    @Inject(force = false)
    public static IDevicePortraitThresholdsConfig getDefaultThresholdsConfig() {
        return new DefaultIDevicePortraitThresholdsConfigProxy();
    }
}
