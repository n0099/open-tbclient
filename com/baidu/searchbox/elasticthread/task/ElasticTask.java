package com.baidu.searchbox.elasticthread.task;

import android.os.SystemClock;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public interface ElasticTaskCallback {
        void afterExecuteTask();

        void beforeExecuteTask();
    }

    /* loaded from: classes3.dex */
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
        long j;
        if (this.status == Status.WAITING) {
            return 0L;
        }
        if (this.status == Status.RUNNING) {
            j = SystemClock.elapsedRealtime();
        } else {
            j = this.timeOnComplete;
        }
        return Math.max(0L, j - this.timeOnExecute);
    }

    public synchronized long getWaitingTime() {
        long j;
        if (this.timeOnQueue == 0) {
            return 0L;
        }
        if (this.status == Status.WAITING) {
            j = SystemClock.elapsedRealtime();
        } else {
            j = this.timeOnExecute;
        }
        return Math.max(0L, j - this.timeOnQueue);
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

    public synchronized long getWorkTimeInRecordLifeCycle(long j, long j2) {
        long j3;
        if (this.status == Status.WAITING) {
            return 0L;
        }
        long max = Math.max(this.timeOnExecute, j);
        if (this.status == Status.RUNNING) {
            j3 = SystemClock.elapsedRealtime();
        } else {
            j3 = this.timeOnComplete;
        }
        return Math.max(0L, Math.min(j3, j2) - max);
    }

    public void setElasticTaskCallback(ElasticTaskCallback elasticTaskCallback) {
        this.mCallback = elasticTaskCallback;
    }
}
