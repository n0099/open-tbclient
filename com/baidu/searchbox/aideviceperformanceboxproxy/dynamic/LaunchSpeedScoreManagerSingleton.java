package com.baidu.searchbox.aideviceperformanceboxproxy.dynamic;

import com.baidu.searchbox.aideviceperformance.dynamic.LaunchSpeedScoreManager;
import com.baidu.searchbox.aideviceperformanceboxproxy.model.ModelProviderRuntime;
/* loaded from: classes3.dex */
public class LaunchSpeedScoreManagerSingleton extends LaunchSpeedScoreManager {
    public static LaunchSpeedScoreManagerSingleton sInstance = new LaunchSpeedScoreManagerSingleton();

    public LaunchSpeedScoreManagerSingleton() {
        super(ModelProviderRuntime.dynamicModelProvider());
    }

    public static LaunchSpeedScoreManagerSingleton getInstance() {
        return sInstance;
    }
}
