package com.baidu.searchbox.elasticthread.executor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class DredgeDisasterExecutorCell extends BaseDredgeExecutorCell {
    public DredgeDisasterExecutorCell(int i) {
        super(i);
        this.mExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 100L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public String getTag() {
        return "ElasticDredgeDisasterCell";
    }
}
