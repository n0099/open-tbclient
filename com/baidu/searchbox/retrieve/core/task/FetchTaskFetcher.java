package com.baidu.searchbox.retrieve.core.task;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.tieba.tj1;
/* loaded from: classes2.dex */
public class FetchTaskFetcher extends tj1<IFetchTask> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tj1
    public IFetchTask createService() throws ServiceNotFoundException {
        return new FetchTask();
    }
}
