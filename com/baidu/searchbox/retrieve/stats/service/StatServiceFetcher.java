package com.baidu.searchbox.retrieve.stats.service;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.stats.StatTask;
import com.baidu.tieba.pl1;
/* loaded from: classes4.dex */
public class StatServiceFetcher extends pl1<IStatTask> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.pl1
    public IStatTask createService() throws ServiceNotFoundException {
        return new StatTask();
    }
}
