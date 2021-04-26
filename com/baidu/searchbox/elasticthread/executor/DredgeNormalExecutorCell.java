package com.baidu.searchbox.elasticthread.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class DredgeNormalExecutorCell extends BaseDredgeExecutorCell {
    public DredgeNormalExecutorCell(int i2) {
        super(i2);
        this.maxThreadNum = i2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public String getTag() {
        return "ElasticDredgeNormalCell";
    }
}
