package com.baidu.searchbox.ng.ai.apps.util.task;

import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class TaskQueue implements TaskManager {
    private Task mLoadedTask;
    private final Queue<Task> mTaskQueue = new ArrayDeque();

    @Override // com.baidu.searchbox.ng.ai.apps.util.task.TaskManager
    public void offer(Task task) {
        if (task != null) {
            synchronized (this.mTaskQueue) {
                this.mTaskQueue.offer(task.host(this));
            }
        }
        checkAndRunTask();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.util.task.TaskManager
    public void finish(Task task) {
        synchronized (this.mTaskQueue) {
            if (task == this.mLoadedTask) {
                runNextTask();
            }
        }
    }

    private void checkAndRunTask() {
        synchronized (this.mTaskQueue) {
            if (this.mLoadedTask == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.mTaskQueue) {
            this.mLoadedTask = null;
            if (!this.mTaskQueue.isEmpty()) {
                this.mLoadedTask = this.mTaskQueue.poll();
                if (this.mLoadedTask == null) {
                    runNextTask();
                } else {
                    AiAppsUtils.postOnUi(this.mLoadedTask);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.mLoadedTask != null) {
            this.mLoadedTask.finish();
            this.mLoadedTask = null;
        }
        this.mTaskQueue.clear();
    }
}
