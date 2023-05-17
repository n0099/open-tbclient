package com.baidu.searchbox.elasticthread.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class DredgeNormalExecutorCell extends BaseDredgeExecutorCell {
    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public String getTag() {
        return "ElasticDredgeNormalCell";
    }

    public DredgeNormalExecutorCell(int i) {
        super(i);
        this.maxThreadNum = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
