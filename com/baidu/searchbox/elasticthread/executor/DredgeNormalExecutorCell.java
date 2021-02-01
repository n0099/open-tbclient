package com.baidu.searchbox.elasticthread.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class DredgeNormalExecutorCell extends BaseDredgeExecutorCell {
    /* JADX INFO: Access modifiers changed from: protected */
    public DredgeNormalExecutorCell(int i) {
        super(i);
        this.maxThreadNum = i;
        this.mExecutor = new ThreadPoolExecutor(i, i, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected String getTag() {
        return "ElasticDredgeNormalCell";
    }
}
