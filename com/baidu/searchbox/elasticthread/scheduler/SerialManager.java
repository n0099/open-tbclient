package com.baidu.searchbox.elasticthread.scheduler;

import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.executor.SerialExecutorCell;
import com.baidu.searchbox.elasticthread.queue.ElasticQueue;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
/* loaded from: classes17.dex */
public class SerialManager implements Recordable {
    private ElasticQueue mElasticQueue = new ElasticQueue();
    private BaseExecutorCell mCurrentWorkingExecutor = BaseExecutorCell.build(1, BaseExecutorCell.ExecutorType.SERIAL);

    public void insertTask(Runnable runnable, String str, int i) {
        this.mElasticQueue.insertTask(runnable, str, i);
    }

    public boolean scheduleNextTask() {
        ElasticTask next = this.mElasticQueue.getNext();
        if (next != null && this.mCurrentWorkingExecutor.execute(next)) {
            this.mElasticQueue.remove(next);
            return true;
        }
        return false;
    }

    public boolean checkBlockAndDredge() {
        return ((SerialExecutorCell) this.mCurrentWorkingExecutor).checkBlockAndDredge();
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        this.mCurrentWorkingExecutor.onRecordBegin();
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        this.mCurrentWorkingExecutor.onRecordEnd();
    }
}
