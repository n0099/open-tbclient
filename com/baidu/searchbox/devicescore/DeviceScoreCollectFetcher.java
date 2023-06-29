package com.baidu.searchbox.devicescore;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.wl1;
/* loaded from: classes3.dex */
public class DeviceScoreCollectFetcher extends wl1<IScoreMetaDataCollect> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.wl1
    public IScoreMetaDataCollect createService() throws ServiceNotFoundException {
        return DeviceScoreManager.getInstance();
    }
}
