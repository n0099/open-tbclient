package com.baidu.searchbox.aideviceperformanceboxproxy.amendedstaticscore;

import com.baidu.searchbox.aideviceperformance.amendeddevicescore.AmendedDeviceScoreManager;
import com.baidu.searchbox.aideviceperformanceboxproxy.model.ModelProviderRuntime;
/* loaded from: classes3.dex */
public class AmendedDeviceScoreManagerSingleton extends AmendedDeviceScoreManager {
    public static AmendedDeviceScoreManagerSingleton sInstance = new AmendedDeviceScoreManagerSingleton();

    public AmendedDeviceScoreManagerSingleton() {
        super(ModelProviderRuntime.amendedDeviceScoreModelProvider());
    }

    public static AmendedDeviceScoreManagerSingleton getInstance() {
        return sInstance;
    }
}
