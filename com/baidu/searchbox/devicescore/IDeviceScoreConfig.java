package com.baidu.searchbox.devicescore;

import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes9.dex */
public interface IDeviceScoreConfig {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("device_score", "DEVICE_SCORE_CONFIG");

    void updateConfig(DeviceScoreConfig deviceScoreConfig);
}
