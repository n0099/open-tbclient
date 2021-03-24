package com.baidu.searchbox.elasticthread.task;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class ElasticTask implements Runnable {
    public static final boolean DEBUG = false;
    public long id;
    public ElasticTaskCallback mCallback;
    public Runnable mTaskEntity;
    public String name;
    public int priority;
    public Status status = Status.WAITING;
    public long timeOnComplete;
    public long timeOnExecute;
    public long timeOnQueue;

    /* loaded from: classes2.dex */
    public interface ElasticTaskCallback {
        void afterExecuteTask();

        void beforeExecuteTask();
    }

    /* loaded from: classes2.dex */
    public enum Status {
        WAITING,
        RUNNING,
        COMPLETE
    }

    public ElasticTask(Runnable runnable, String str, long j, int i) {
        this.mTaskEntity = runnable;
        this.id = j;
        this.name = str;
        this.priority = i;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public synchronized long getRawWorkTime() {
        if (this.status == Status.WAITING) {
            return 0L;
        }
        return Math.max(0L, (this.status == Status.RUNNING ? SystemClock.elapsedRealtime() : this.timeOnComplete) - this.timeOnExecute);
    }

    public synchronized long getWaitingTime() {
        if (this.timeOnQueue == 0) {
            return 0L;
        }
        return Math.max(0L, (this.status == Status.WAITING ? SystemClock.elapsedRealtime() : this.timeOnExecute) - this.timeOnQueue);
    }

    public synchronized long getWorkTimeInRecordLifeCycle(long j, long j2) {
        if (this.status == Status.WAITING) {
            return 0L;
        }
        return Math.max(0L, Math.min(this.status == Status.RUNNING ? SystemClock.elapsedRealtime() : this.timeOnComplete, j2) - Math.max(this.timeOnExecute, j));
    }

    public synchronized void recordCompleteTime() {
        this.status = Status.COMPLETE;
        this.timeOnComplete = SystemClock.elapsedRealtime();
    }

    public synchronized void recordEnqueueTime() {
        this.status = Status.WAITING;
        this.timeOnQueue = SystemClock.elapsedRealtime();
    }

    public synchronized void recordExecuteTime() {
        this.status = Status.RUNNING;
        this.timeOnExecute = SystemClock.elapsedRealtime();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.mCallback != null) {
                this.mCallback.beforeExecuteTask();
            }
        } catch (Exception unused) {
        }
        this.mTaskEntity.run();
        try {
            if (this.mCallback != null) {
                this.mCallback.afterExecuteTask();
            }
        } catch (Exception unused2) {
        }
    }

    public void setElasticTaskCallback(ElasticTaskCallback elasticTaskCallback) {
        this.mCallback = elasticTaskCallback;
    }
}
