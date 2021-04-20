package com.baidu.mobads.container.components.monitor;

import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class RemoteScheduledMonitor {
    public static final int MONITOR_INTERVAL = 500;
    public static RemoteScheduledMonitor mInstance;
    public ScheduledTask mTaskRunnable = new ScheduledTask();
    public volatile AtomicBoolean mMonitorRunning = new AtomicBoolean(false);
    public List<IScheduleTask> mTaskList = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes2.dex */
    public class ScheduledTask extends BaseTask {
        public ScheduledTask() {
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            try {
                if (RemoteScheduledMonitor.this.mMonitorRunning.get()) {
                    for (IScheduleTask iScheduleTask : RemoteScheduledMonitor.this.mTaskList) {
                        if (iScheduleTask.handle()) {
                            RemoteScheduledMonitor.this.mTaskList.remove(iScheduleTask);
                        }
                    }
                    if (RemoteScheduledMonitor.this.mTaskList.isEmpty()) {
                        stop();
                        return null;
                    }
                    return null;
                }
                stop();
                return null;
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().i(th);
                stop();
                return null;
            }
        }

        public void stop() {
            RemoteScheduledMonitor.this.mMonitorRunning.set(false);
            RemoteScheduledMonitor.this.mTaskList.clear();
            cancel();
        }
    }

    public static synchronized RemoteScheduledMonitor getInstance() {
        RemoteScheduledMonitor remoteScheduledMonitor;
        synchronized (RemoteScheduledMonitor.class) {
            if (mInstance == null) {
                mInstance = new RemoteScheduledMonitor();
            }
            remoteScheduledMonitor = mInstance;
        }
        return remoteScheduledMonitor;
    }

    public void addTask(IScheduleTask iScheduleTask) {
        this.mTaskList.add(iScheduleTask);
    }

    public void removeTask(IScheduleTask iScheduleTask) {
        this.mTaskList.remove(iScheduleTask);
    }

    public synchronized void startMonitor() {
        if (!this.mMonitorRunning.get()) {
            TaskScheduler.getInstance().submitAtFixedRate(this.mTaskRunnable, 0L, 500L, TimeUnit.MILLISECONDS);
        }
        this.mMonitorRunning.set(true);
    }

    public synchronized void stopMonitor() {
        this.mMonitorRunning.set(false);
        this.mTaskList.clear();
    }
}
