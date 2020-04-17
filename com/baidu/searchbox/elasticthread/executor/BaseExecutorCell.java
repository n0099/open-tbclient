package com.baidu.searchbox.elasticthread.executor;

import android.os.SystemClock;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes11.dex */
public abstract class BaseExecutorCell implements Recordable {
    protected static final boolean DEBUG = false;
    protected int completedTaskCountInRecordLifeCycle;
    protected ThreadPoolExecutor mExecutor;
    protected int maxThreadNum;
    protected long workTimeInRecordLifeCycle;
    protected List<ElasticTask> mWorkingTasks = new LinkedList();
    protected long recordBeginTime = 0;
    protected long recordEndTime = Long.MAX_VALUE;
    protected Recordable.RecordStatus mRecordStatus = Recordable.RecordStatus.UNINITIATED;

    /* loaded from: classes11.dex */
    public enum ExecutorType {
        ARTERY,
        DREDGE_NORMAL,
        DREDGE_DISASTER,
        SERIAL
    }

    protected abstract boolean available();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseExecutorCell(int i) {
        this.maxThreadNum = i;
    }

    public static BaseExecutorCell build(int i, ExecutorType executorType) {
        switch (executorType) {
            case ARTERY:
                return new ArteryExecutorCell(i);
            case DREDGE_NORMAL:
                return new DredgeNormalExecutorCell(i);
            case DREDGE_DISASTER:
                return new DredgeDisasterExecutorCell(i);
            case SERIAL:
                return new SerialExecutorCell(i);
            default:
                return null;
        }
    }

    public synchronized boolean execute(final ElasticTask elasticTask) {
        boolean z;
        if (!available()) {
            z = false;
        } else {
            elasticTask.setElasticTaskCallback(new ElasticTask.ElasticTaskCallback() { // from class: com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.1
                @Override // com.baidu.searchbox.elasticthread.task.ElasticTask.ElasticTaskCallback
                public void beforeExecuteTask() {
                    BaseExecutorCell.this.onTaskBegin(elasticTask);
                }

                @Override // com.baidu.searchbox.elasticthread.task.ElasticTask.ElasticTaskCallback
                public void afterExecuteTask() {
                    BaseExecutorCell.this.onTaskEnd(elasticTask);
                }
            });
            this.mWorkingTasks.add(elasticTask);
            this.mExecutor.execute(elasticTask);
            z = true;
        }
        return z;
    }

    private void setTreadPriorityAndName(ElasticTask elasticTask) {
        int priority = elasticTask.getPriority();
        Thread currentThread = Thread.currentThread();
        if (priority == 0) {
            currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_IMMEDIATE);
        } else if (priority == 1) {
            currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_USER_RELATED);
        } else if (priority == 2) {
            currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_INTIME);
        } else if (priority == 3) {
            currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_BACKGROUND);
        } else if (priority == 4) {
            currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_SERIAL);
        }
        currentThread.setName(elasticTask.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void onTaskBegin(ElasticTask elasticTask) {
        elasticTask.recordExecuteTime();
        setTreadPriorityAndName(elasticTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void onTaskEnd(ElasticTask elasticTask) {
        elasticTask.recordCompleteTime();
        this.mWorkingTasks.remove(elasticTask);
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.workTimeInRecordLifeCycle += elasticTask.getWorkTimeInRecordLifeCycle(this.recordBeginTime, this.recordEndTime);
            this.completedTaskCountInRecordLifeCycle++;
        }
    }

    public synchronized int getWorkingThreadNum() {
        return this.mWorkingTasks.size();
    }

    public int getMaxThreadNum() {
        return this.maxThreadNum;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public synchronized void onRecordBegin() {
        this.recordBeginTime = SystemClock.elapsedRealtime();
        this.recordEndTime = Long.MAX_VALUE;
        this.workTimeInRecordLifeCycle = 0L;
        this.completedTaskCountInRecordLifeCycle = 0;
        this.mRecordStatus = Recordable.RecordStatus.RECORDING;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public synchronized void onRecordEnd() {
        this.recordEndTime = SystemClock.elapsedRealtime();
        for (ElasticTask elasticTask : this.mWorkingTasks) {
            this.workTimeInRecordLifeCycle += elasticTask.getWorkTimeInRecordLifeCycle(this.recordBeginTime, this.recordEndTime);
        }
        this.mRecordStatus = Recordable.RecordStatus.RECORD_END;
    }

    public synchronized int getCompletedTaskCountInRecordLifeCycle() {
        return this.completedTaskCountInRecordLifeCycle;
    }

    public synchronized long getWorkTimeInRecordLifeCycle() {
        return this.workTimeInRecordLifeCycle;
    }
}
