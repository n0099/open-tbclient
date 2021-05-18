package com.baidu.android.util.concurrent.task;

import com.bumptech.glide.load.engine.GlideException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class Task {
    public AtomicBoolean mCancelled;
    public int mId;
    public String mName;
    public volatile RunningStatus mRunStatus;
    public volatile Status mStatus;

    /* loaded from: classes.dex */
    public enum RunningStatus {
        WORK_THREAD,
        UI_THREAD
    }

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

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

    public void cancel() {
        this.mCancelled.set(true);
    }

    public RunningStatus getRunningStatus() {
        return this.mRunStatus;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getTaskId() {
        return this.mId;
    }

    public String getTaskName() {
        return this.mName;
    }

    public boolean isCancelled() {
        return this.mCancelled.get();
    }

    public abstract TaskOperation onExecute(TaskOperation taskOperation);

    public void onProgressUpdate(Object obj) {
    }

    public void setStatus(Status status) {
        this.mStatus = status;
    }

    public void setTaskId(int i2) {
        this.mId = i2;
    }

    public void setTaskName(String str) {
        this.mName = str;
    }

    public String toString() {
        return "name = " + this.mName + GlideException.IndentedAppendable.INDENT + "id = " + this.mId + GlideException.IndentedAppendable.INDENT + super.toString();
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
}
