package com.baidu.searchbox.ng.ai.apps.util.task;
/* loaded from: classes2.dex */
public abstract class Task implements Runnable {
    private TaskManager mHost;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task host(TaskManager taskManager) {
        this.mHost = taskManager;
        return this;
    }

    public void finish() {
        if (this.mHost != null) {
            this.mHost.finish(this);
            this.mHost = null;
        }
    }
}
