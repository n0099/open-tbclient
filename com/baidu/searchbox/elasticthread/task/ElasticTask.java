package com.baidu.searchbox.elasticthread.task;

import android.os.SystemClock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes12.dex */
public class ElasticTask implements Runnable {
    private long id;
    private ElasticTaskCallback mCallback;
    private Runnable mTaskEntity;
    private String name;
    private int priority;
    private long timeOnComplete;
    private long timeOnExecute;
    private long timeOnQueue;
    public Status status = Status.WAITING;
    private ReentrantLock mCallbackLock = new ReentrantLock();

    /* loaded from: classes12.dex */
    public interface ElasticTaskCallback {
        void afterExecuteTask();

        void beforeExecuteTask();
    }

    /* loaded from: classes12.dex */
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
        this.mCallbackLock.lock();
        this.mCallback = elasticTaskCallback;
        this.mCallbackLock.unlock();
    }

    @Override // java.lang.Runnable
    public void run() {
        beforeExecuteCallback();
        this.mTaskEntity.run();
        afterExecuteCallback();
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

    private void beforeExecuteCallback() {
        this.mCallbackLock.lock();
        if (this.mCallback != null) {
            this.mCallback.beforeExecuteTask();
        }
        this.mCallbackLock.unlock();
    }

    private void afterExecuteCallback() {
        this.mCallbackLock.lock();
        if (this.mCallback != null) {
            this.mCallback.afterExecuteTask();
        }
        this.mCallbackLock.unlock();
    }
}
