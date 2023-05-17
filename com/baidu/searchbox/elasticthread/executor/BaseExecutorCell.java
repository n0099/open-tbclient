package com.baidu.searchbox.elasticthread.executor;

import android.os.SystemClock;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public abstract class BaseExecutorCell implements Recordable {
    public static final boolean DEBUG = false;
    public int completedTaskCountInRecordLifeCycle;
    public ThreadPoolExecutor mExecutor;
    public int maxThreadNum;
    public long workTimeInRecordLifeCycle;
    public List<ElasticTask> mWorkingTasks = new LinkedList();
    public long recordBeginTime = 0;
    public long recordEndTime = Long.MAX_VALUE;
    public Recordable.RecordStatus mRecordStatus = Recordable.RecordStatus.UNINITIATED;

    /* loaded from: classes3.dex */
    public enum ExecutorType {
        ARTERY,
        DREDGE_NORMAL,
        DREDGE_DISASTER,
        SERIAL
    }

    public abstract boolean available();

    public abstract String getTag();

    /* renamed from: com.baidu.searchbox.elasticthread.executor.BaseExecutorCell$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType;

        static {
            int[] iArr = new int[ExecutorType.values().length];
            $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType = iArr;
            try {
                iArr[ExecutorType.ARTERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType[ExecutorType.DREDGE_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType[ExecutorType.DREDGE_DISASTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType[ExecutorType.SERIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BaseExecutorCell(int i) {
        this.maxThreadNum = i;
    }

    public synchronized boolean execute(final ElasticTask elasticTask) {
        if (!available()) {
            return false;
        }
        elasticTask.setElasticTaskCallback(new ElasticTask.ElasticTaskCallback() { // from class: com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.1
            @Override // com.baidu.searchbox.elasticthread.task.ElasticTask.ElasticTaskCallback
            public void afterExecuteTask() {
                BaseExecutorCell.this.onTaskEnd(elasticTask);
            }

            @Override // com.baidu.searchbox.elasticthread.task.ElasticTask.ElasticTaskCallback
            public void beforeExecuteTask() {
                BaseExecutorCell.this.onTaskBegin(elasticTask);
            }
        });
        this.mWorkingTasks.add(elasticTask);
        this.mExecutor.execute(elasticTask);
        return true;
    }

    public synchronized void onTaskBegin(ElasticTask elasticTask) {
        elasticTask.recordExecuteTime();
        setTreadPriorityAndName(elasticTask);
    }

    public synchronized void onTaskEnd(ElasticTask elasticTask) {
        elasticTask.recordCompleteTime();
        this.mWorkingTasks.remove(elasticTask);
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.workTimeInRecordLifeCycle += elasticTask.getWorkTimeInRecordLifeCycle(this.recordBeginTime, this.recordEndTime);
            this.completedTaskCountInRecordLifeCycle++;
        }
    }

    public static BaseExecutorCell build(int i, ExecutorType executorType) {
        int i2 = AnonymousClass2.$SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType[executorType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return new SerialExecutorCell(i);
                }
                return new DredgeDisasterExecutorCell(i);
            }
            return new DredgeNormalExecutorCell(i);
        }
        return new ArteryExecutorCell(i);
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

    public synchronized int getCompletedTaskCountInRecordLifeCycle() {
        return this.completedTaskCountInRecordLifeCycle;
    }

    public int getMaxThreadNum() {
        return this.maxThreadNum;
    }

    public synchronized long getWorkTimeInRecordLifeCycle() {
        return this.workTimeInRecordLifeCycle;
    }

    public synchronized int getWorkingThreadNum() {
        return this.mWorkingTasks.size();
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
}
