package com.baidu.searchbox.elasticthread.executor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes13.dex */
public class DredgeDisasterExecutorCell extends BaseDredgeExecutorCell {
    /* JADX INFO: Access modifiers changed from: protected */
    public DredgeDisasterExecutorCell(int i) {
        super(i);
        this.mExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 100L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected String getTag() {
        return "ElasticDredgeDisasterCell";
    }
}
