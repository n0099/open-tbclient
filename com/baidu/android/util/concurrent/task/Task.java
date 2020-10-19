package com.baidu.android.util.concurrent.task;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class Task {
    private AtomicBoolean mCancelled;
    private int mId;
    private String mName;
    private volatile RunningStatus mRunStatus;
    private volatile Status mStatus;

    /* loaded from: classes8.dex */
    public enum RunningStatus {
        WORK_THREAD,
        UI_THREAD
    }

    /* loaded from: classes8.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public abstract TaskOperation onExecute(TaskOperation taskOperation);

    public Task(Task task) {
        this.mId = 0;
        this.mName = null;
        this.mCancelled = new AtomicBoolean(false);
        this.mStatus = Status.PENDING;
        this.mRunStatus = RunningStatus.UI_THREAD;
        this.mRunStatus = task.mRunStatus;
        this.mName = task.mName;
        this.mStatus = task.mStatus;
    }

    public Task(RunningStatus runningStatus) {
        this(runningStatus, null);
    }

    public Task(RunningStatus runningStatus, String str) {
        this.mId = 0;
        this.mName = null;
        this.mCancelled = new AtomicBoolean(false);
        this.mStatus = Status.PENDING;
        this.mRunStatus = RunningStatus.UI_THREAD;
        this.mRunStatus = runningStatus;
        this.mName = str;
    }

    public void onProgressUpdate(Object obj) {
    }

    public void cancel() {
        this.mCancelled.set(true);
    }

    public boolean isCancelled() {
        return this.mCancelled.get();
    }

    public RunningStatus getRunningStatus() {
        return this.mRunStatus;
    }

    public void setTaskName(String str) {
        this.mName = str;
    }

    public String getTaskName() {
        return this.mName;
    }

    public void setStatus(Status status) {
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public void setTaskId(int i) {
        this.mId = i;
    }

    public int getTaskId() {
        return this.mId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name = ").append(this.mName).append("  ");
        sb.append("id = ").append(this.mId).append("  ");
        sb.append(super.toString());
        return sb.toString();
    }
}
