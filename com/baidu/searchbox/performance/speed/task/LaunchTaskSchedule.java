package com.baidu.searchbox.performance.speed.task;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.util.concurrent.AsyncTaskAssistant;
import com.baidu.searchbox.performance.speed.SpeedRuntime;
import com.baidu.tieba.qb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@MainThread
/* loaded from: classes2.dex */
public class LaunchTaskSchedule {
    public static LaunchTaskSchedule sInstance;
    public final Set<Integer> historyLifecycle = new HashSet();
    public HashSet<String> mChangeToSyncTaskSet = new HashSet<>();
    public int mProcessType;
    public BaseTaskPool mTaskPool;

    public static LaunchTaskSchedule getInstance() {
        if (sInstance == null) {
            sInstance = new LaunchTaskSchedule();
        }
        return sInstance;
    }

    private boolean checkStartBefore(int i) {
        if (this.historyLifecycle.contains(Integer.valueOf(i))) {
            return true;
        }
        this.historyLifecycle.add(Integer.valueOf(i));
        return false;
    }

    private void startSyncTask(int i) {
        List<LaunchTask> taskList = this.mTaskPool.getTaskList(i, 1);
        if (taskList == null) {
            return;
        }
        for (LaunchTask launchTask : taskList) {
            if ((launchTask.getProcess() & this.mProcessType) != 0) {
                launchTask.run();
            }
        }
    }

    public void start(int i) {
        if (this.mProcessType <= 0 || this.mTaskPool == null || checkStartBefore(i)) {
            return;
        }
        startAsyncTask(i);
        startSyncTask(i);
        startIdleTask(i);
    }

    public void startTaskInSingleThread(int i) {
        List<LaunchTask> taskList = this.mTaskPool.getTaskList(i, 2);
        if (taskList == null) {
            return;
        }
        for (LaunchTask launchTask : taskList) {
            if ((launchTask.getProcess() & this.mProcessType) != 0) {
                new Thread(launchTask).start();
            }
        }
    }

    private void startAsyncTask(int i) {
        List<LaunchTask> taskList = this.mTaskPool.getTaskList(i, 2);
        if (taskList == null) {
            return;
        }
        try {
            if (SpeedRuntime.getSpeedContext().isMainProcess() && !this.mChangeToSyncTaskSet.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (LaunchTask launchTask : taskList) {
                    if (launchTask.getName() != null && this.mChangeToSyncTaskSet.contains(launchTask.getName()) && (launchTask.getProcess() & this.mProcessType) != 0) {
                        launchTask.run();
                    } else {
                        arrayList.add(launchTask);
                    }
                }
                taskList = arrayList;
            }
        } catch (Exception unused) {
        }
        for (LaunchTask launchTask2 : taskList) {
            if ((launchTask2.getProcess() & this.mProcessType) != 0) {
                AsyncTaskAssistant.executeOnThreadPool(launchTask2, launchTask2.getName());
            }
        }
    }

    private void startIdleTask(int i) {
        List<LaunchTask> taskList = this.mTaskPool.getTaskList(i, 3);
        if (taskList == null) {
            return;
        }
        for (final LaunchTask launchTask : taskList) {
            if ((launchTask.getProcess() & this.mProcessType) != 0) {
                qb.b().a(launchTask.getName(), new Runnable() { // from class: com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule.1
                    @Override // java.lang.Runnable
                    public void run() {
                        launchTask.run();
                    }
                });
            }
        }
    }

    public void init(int i, @NonNull BaseTaskPool baseTaskPool, HashSet<String> hashSet) {
        this.mProcessType = i;
        this.mTaskPool = baseTaskPool;
        this.mChangeToSyncTaskSet = hashSet;
    }

    public void startTask(int i) {
        List<LaunchTask> taskList = this.mTaskPool.getTaskList(i, 2);
        if (taskList != null) {
            for (LaunchTask launchTask : taskList) {
                launchTask.run();
            }
        }
        List<LaunchTask> taskList2 = this.mTaskPool.getTaskList(i, 1);
        if (taskList2 != null) {
            for (LaunchTask launchTask2 : taskList2) {
                launchTask2.run();
            }
        }
        List<LaunchTask> taskList3 = this.mTaskPool.getTaskList(i, 3);
        if (taskList3 != null) {
            for (LaunchTask launchTask3 : taskList3) {
                launchTask3.run();
            }
        }
    }
}
