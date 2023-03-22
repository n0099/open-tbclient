package com.baidu.searchbox.devicescore;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.pj1;
/* loaded from: classes2.dex */
public class DeviceScoreConfigFetcher extends pj1<IDeviceScoreConfig> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.pj1
    public IDeviceScoreConfig createService() throws ServiceNotFoundException {
        return DeviceScoreManager.getInstance();
    }
}
