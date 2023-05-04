package com.baidu.searchbox.devicescore;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.tj1;
/* loaded from: classes2.dex */
public class DeviceScoreCollectFetcher extends tj1<IScoreMetaDataCollect> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tj1
    public IScoreMetaDataCollect createService() throws ServiceNotFoundException {
        return DeviceScoreManager.getInstance();
    }
}
