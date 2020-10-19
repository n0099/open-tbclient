package com.baidu.searchbox.elasticthread.executor;

import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes17.dex */
public class ArteryExecutorCell extends BaseExecutorCell {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ArteryExecutorCell(int i) {
        super(i);
        this.mExecutor = new ThreadPoolExecutor(i, i, ElasticConfig.EXECUTOR_CONFIG_KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected boolean available() {
        return getWorkingThreadNum() < this.maxThreadNum;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected String getTag() {
        return "ArteryElasticExecutorCell";
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected synchronized void onTaskEnd(ElasticTask elasticTask) {
        super.onTaskEnd(elasticTask);
        ElasticTaskScheduler.getInstance().postConcurrentSchedule();
    }
}
