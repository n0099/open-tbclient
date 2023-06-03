package com.baidu.searchbox.devicescore;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.sl1;
/* loaded from: classes3.dex */
public class DeviceScoreFetcher extends sl1<IDeviceScore> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sl1
    public IDeviceScore createService() throws ServiceNotFoundException {
        return DeviceScoreManager.getInstance();
    }
}
