package com.baidu.live.tbadk.timer;
/* loaded from: classes7.dex */
public class LiveTimerTask {
    public long duration;
    public long liveId;
    public OnLiveTimerListener onLiveTimerListener;
    public Runnable runnable;
    public String taskId;
    public long totalDuration;

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public long getLiveId() {
        return this.liveId;
    }

    public void setLiveId(long j) {
        this.liveId = j;
    }

    public OnLiveTimerListener getOnLiveTimerListener() {
        return this.onLiveTimerListener;
    }

    public void setOnLiveTimerListener(OnLiveTimerListener onLiveTimerListener) {
        this.onLiveTimerListener = onLiveTimerListener;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public long getTotalDuration() {
        return this.totalDuration;
    }

    public void setTotalDuration(long j) {
        this.totalDuration = j;
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
}
