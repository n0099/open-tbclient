package com.baidu.searchbox.abtest.ioc;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.fg1;
/* loaded from: classes3.dex */
public class AbTestServiceFetcher extends fg1<AbTestService> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.fg1
    public AbTestService createService() throws ServiceNotFoundException {
        return new AbTestServiceManager();
    }
}
