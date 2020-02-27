package com.baidu.live.tbadk.timer;

import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class LiveTimerManager {
    private static LiveTimerManager INSTANCE = new LiveTimerManager();
    private long currLiveId;
    private long now;
    private boolean isRunning = false;
    private Handler handler = new Handler();
    private Handler unimpededHandler = new Handler();
    private Map<String, LiveTimerTask> liveTimerTaskMap = new HashMap();
    private Map<String, LiveTimerTask> unimpededLiveTimerTaskMap = new HashMap();

    public static LiveTimerManager getInstance() {
        return INSTANCE;
    }

    public synchronized void addLiveTimerTask(final String str, final long j, final OnLiveTimerListener onLiveTimerListener, long j2, final boolean z) {
        if (z) {
            if (!this.unimpededLiveTimerTaskMap.containsKey(str)) {
                LiveTimerTask liveTimerTask = new LiveTimerTask();
                liveTimerTask.setTaskId(str);
                liveTimerTask.setLiveId(j);
                liveTimerTask.setOnLiveTimerListener(onLiveTimerListener);
                liveTimerTask.setTotalDuration(j2);
                liveTimerTask.setDuration(0L);
                liveTimerTask.setRunnable(new Runnable() { // from class: com.baidu.live.tbadk.timer.LiveTimerManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveTimerManager.this.removeLiveTimerTask(str, z);
                        if (onLiveTimerListener != null) {
                            if (j == LiveTimerManager.this.currLiveId) {
                                onLiveTimerListener.onComplete(LiveTimerManager.this.isRunning);
                            } else {
                                onLiveTimerListener.onInterrupt();
                            }
                        }
                    }
                });
                this.unimpededLiveTimerTaskMap.put(str, liveTimerTask);
                if (this.isRunning) {
                    this.unimpededHandler.postDelayed(liveTimerTask.getRunnable(), liveTimerTask.getTotalDuration());
                }
            }
        } else if (!this.liveTimerTaskMap.containsKey(str)) {
            LiveTimerTask liveTimerTask2 = new LiveTimerTask();
            liveTimerTask2.setTaskId(str);
            liveTimerTask2.setLiveId(j);
            liveTimerTask2.setOnLiveTimerListener(onLiveTimerListener);
            liveTimerTask2.setTotalDuration(j2);
            liveTimerTask2.setDuration(0L);
            liveTimerTask2.setRunnable(new Runnable() { // from class: com.baidu.live.tbadk.timer.LiveTimerManager.2
                @Override // java.lang.Runnable
                public void run() {
                    LiveTimerManager.this.removeLiveTimerTask(str, z);
                    if (onLiveTimerListener != null) {
                        if (j == LiveTimerManager.this.currLiveId) {
                            onLiveTimerListener.onComplete(LiveTimerManager.this.isRunning);
                        } else {
                            onLiveTimerListener.onInterrupt();
                        }
                    }
                }
            });
            this.liveTimerTaskMap.put(str, liveTimerTask2);
            if (this.isRunning) {
                this.handler.postDelayed(liveTimerTask2.getRunnable(), liveTimerTask2.getTotalDuration());
            }
        }
    }

    public synchronized void removeLiveTimerTask(String str, boolean z) {
        if (z) {
            LiveTimerTask remove = this.unimpededLiveTimerTaskMap.remove(str);
            if (remove != null) {
                this.unimpededHandler.removeCallbacks(remove.getRunnable());
            }
        } else {
            LiveTimerTask remove2 = this.liveTimerTaskMap.remove(str);
            if (remove2 != null) {
                this.handler.removeCallbacks(remove2.getRunnable());
            }
        }
    }

    public void start(long j) {
        Log.i("LiveTimerManager", "@@ start liveId=" + j);
        this.currLiveId = j;
        this.isRunning = true;
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacksAndMessages(null);
        for (LiveTimerTask liveTimerTask : this.liveTimerTaskMap.values()) {
            liveTimerTask.setDuration(0L);
            this.handler.postDelayed(liveTimerTask.getRunnable(), liveTimerTask.getTotalDuration());
        }
        this.unimpededHandler.removeCallbacksAndMessages(null);
        for (LiveTimerTask liveTimerTask2 : this.unimpededLiveTimerTaskMap.values()) {
            liveTimerTask2.setDuration(0L);
            this.unimpededHandler.postDelayed(liveTimerTask2.getRunnable(), liveTimerTask2.getTotalDuration());
        }
    }

    public synchronized void pause() {
        Log.i("LiveTimerManager", "@@ pause");
        this.isRunning = false;
        long currentTimeMillis = System.currentTimeMillis() - this.now;
        if (currentTimeMillis < 0) {
            currentTimeMillis = 0;
        }
        this.handler.removeCallbacksAndMessages(null);
        for (LiveTimerTask liveTimerTask : this.liveTimerTaskMap.values()) {
            liveTimerTask.setDuration(currentTimeMillis);
        }
    }

    public synchronized void resume(long j) {
        Log.i("LiveTimerManager", "@@ resume liveId=" + j);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stop();
        } else {
            this.isRunning = true;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacksAndMessages(null);
            for (LiveTimerTask liveTimerTask : this.liveTimerTaskMap.values()) {
                this.handler.postDelayed(liveTimerTask.getRunnable(), liveTimerTask.getTotalDuration() - liveTimerTask.getDuration());
            }
        }
    }

    public synchronized void stop() {
        Log.i("LiveTimerManager", "@@ stop");
        this.isRunning = false;
        this.currLiveId = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.unimpededHandler.removeCallbacksAndMessages(null);
        for (LiveTimerTask liveTimerTask : this.liveTimerTaskMap.values()) {
            if (liveTimerTask != null && liveTimerTask.getOnLiveTimerListener() != null) {
                liveTimerTask.getOnLiveTimerListener().onInterrupt();
            }
        }
        this.liveTimerTaskMap.clear();
        for (LiveTimerTask liveTimerTask2 : this.unimpededLiveTimerTaskMap.values()) {
            if (liveTimerTask2 != null && liveTimerTask2.getOnLiveTimerListener() != null) {
                liveTimerTask2.getOnLiveTimerListener().onInterrupt();
            }
        }
        this.unimpededLiveTimerTaskMap.clear();
    }
}
