package com.baidu.searchbox.aideviceperformanceboxproxy.model;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreModelProvider;
import com.baidu.searchbox.aideviceperformance.device.IDeviceInfoModelProvider;
import com.baidu.searchbox.aideviceperformance.dynamic.IDynamicModelProvider;
import com.baidu.searchbox.aideviceperformanceboxproxy.amendedstaticscore.DefaultAmendedDeviceScoreModelProvider;
import com.baidu.searchbox.aideviceperformanceboxproxy.device.DefaultDeviceInfoModelProvider;
import com.baidu.searchbox.aideviceperformanceboxproxy.dynamic.DefaultDynamicModelProvider;
@Autowired
/* loaded from: classes2.dex */
public class ModelProviderRuntime {
    @Inject(force = false)
    public static IAmendedDeviceScoreModelProvider amendedDeviceScoreModelProvider() {
        return new DefaultAmendedDeviceScoreModelProvider();
    }

    @Inject(force = false)
    public static IDeviceInfoModelProvider deviceInfoModelProvider() {
        return new DefaultDeviceInfoModelProvider();
    }

    @Inject(force = false)
    public static IDynamicModelProvider dynamicModelProvider() {
        return new DefaultDynamicModelProvider();
    }
}
