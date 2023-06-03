package com.baidu.searchbox.performance.speed.task;

import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
/* loaded from: classes4.dex */
public abstract class LaunchTask implements Runnable {
    public static final boolean DEBUG;
    public static final String TAG = "LaunchTask";
    public static Looper asyncLooper;

    public abstract void execute();

    public abstract String getName();

    public int getProcess() {
        return -1;
    }

    static {
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        asyncLooper = handlerThread.getLooper();
        DEBUG = AppConfig.isDebug();
    }

    @Override // java.lang.Runnable
    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        execute();
        SpeedStatsManager.getInstance().setTaskRunTime(getName(), System.currentTimeMillis() - currentTimeMillis);
    }
}
