package com.baidu.searchbox.elasticthread.task;

import android.os.SystemClock;
/* loaded from: classes11.dex */
public class ElasticTask implements Runnable {
    private long id;
    private ElasticTaskCallback mCallback;
    private Runnable mTaskEntity;
    private String name;
    private int priority;
    public Status status = Status.WAITING;
    private long timeOnComplete;
    private long timeOnExecute;
    private long timeOnQueue;

    /* loaded from: classes11.dex */
    public interface ElasticTaskCallback {
        void afterExecuteTask();

        void beforeExecuteTask();
    }

    /* loaded from: classes11.dex */
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

    public void setElasticTaskCallback(ElasticTaskCallback elasticTaskCallback) {
        this.mCallback = elasticTaskCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mCallback != null) {
            this.mCallback.beforeExecuteTask();
        }
        this.mTaskEntity.run();
        if (this.mCallback != null) {
            this.mCallback.afterExecuteTask();
        }
    }

    public int getPriority() {
        return this.priority;
    }

    public String getName() {
        return this.name;
    }

    public synchronized long getWaitingTime() {
        long j = 0;
        synchronized (this) {
            if (this.timeOnQueue != 0) {
                j = Math.max(0L, (this.status == Status.WAITING ? SystemClock.elapsedRealtime() : this.timeOnExecute) - this.timeOnQueue);
            }
        }
        return j;
    }

    public synchronized long getWorkTimeInRecordLifeCycle(long j, long j2) {
        long j3 = 0;
        synchronized (this) {
            if (this.status != Status.WAITING) {
                j3 = Math.max(0L, Math.min(this.status == Status.RUNNING ? SystemClock.elapsedRealtime() : this.timeOnComplete, j2) - Math.max(this.timeOnExecute, j));
            }
        }
        return j3;
    }

    public synchronized long getRawWorkTime() {
        long j = 0;
        synchronized (this) {
            if (this.status != Status.WAITING) {
                j = Math.max(0L, (this.status == Status.RUNNING ? SystemClock.elapsedRealtime() : this.timeOnComplete) - this.timeOnExecute);
            }
        }
        return j;
    }

    public synchronized void recordEnqueueTime() {
        this.status = Status.WAITING;
        this.timeOnQueue = SystemClock.elapsedRealtime();
    }

    public synchronized void recordExecuteTime() {
        this.status = Status.RUNNING;
        this.timeOnExecute = SystemClock.elapsedRealtime();
    }

    public synchronized void recordCompleteTime() {
        this.status = Status.COMPLETE;
        this.timeOnComplete = SystemClock.elapsedRealtime();
    }
}
