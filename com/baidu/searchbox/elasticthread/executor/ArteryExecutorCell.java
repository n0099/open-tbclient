package com.baidu.searchbox.elasticthread.executor;

import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class ArteryExecutorCell extends BaseExecutorCell {
    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public String getTag() {
        return "ArteryElasticExecutorCell";
    }

    public ArteryExecutorCell(int i) {
        super(i);
        this.mExecutor = new ThreadPoolExecutor(i, i, ElasticConfig.EXECUTOR_CONFIG_KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public synchronized void onTaskEnd(ElasticTask elasticTask) {
        super.onTaskEnd(elasticTask);
        ElasticTaskScheduler.getInstance().postConcurrentSchedule();
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public boolean available() {
        if (getWorkingThreadNum() < this.maxThreadNum) {
            return true;
        }
        return false;
    }
}
