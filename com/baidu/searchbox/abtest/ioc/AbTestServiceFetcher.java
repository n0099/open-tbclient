package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.tj1;
/* loaded from: classes2.dex */
public class AbTestServiceFetcher extends tj1<AbTestService> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tj1
    public AbTestService createService() throws ServiceNotFoundException {
        return new AbTestServiceManager();
    }
}
