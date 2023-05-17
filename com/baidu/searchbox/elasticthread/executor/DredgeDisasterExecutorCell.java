package com.baidu.searchbox.elasticthread.executor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class DredgeDisasterExecutorCell extends BaseDredgeExecutorCell {
    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public String getTag() {
        return "ElasticDredgeDisasterCell";
    }

    public DredgeDisasterExecutorCell(int i) {
        super(i);
        this.mExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 100L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }
}
