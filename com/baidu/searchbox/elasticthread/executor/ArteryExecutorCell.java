package com.baidu.searchbox.elasticthread.executor;

import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class ArteryExecutorCell extends BaseExecutorCell {
    public ArteryExecutorCell(int i2) {
        super(i2);
        this.mExecutor = new ThreadPoolExecutor(i2, i2, ElasticConfig.EXECUTOR_CONFIG_KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public boolean available() {
        return getWorkingThreadNum() < this.maxThreadNum;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public String getTag() {
        return "ArteryElasticExecutorCell";
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public synchronized void onTaskEnd(ElasticTask elasticTask) {
        super.onTaskEnd(elasticTask);
        ElasticTaskScheduler.getInstance().postConcurrentSchedule();
    }
}
