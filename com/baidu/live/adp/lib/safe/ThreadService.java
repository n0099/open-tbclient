package com.baidu.live.adp.lib.safe;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes4.dex */
public class ThreadService {
    private static ThreadService _service = new ThreadService();
    private final ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    public static ThreadService sharedInstance() {
        return _service;
    }

    public void submitTaskToSingleThread(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void submitTask(Runnable runnable) {
        if (this.executor.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.executor.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
