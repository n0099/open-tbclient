package com.baidu.mobads.container.components.statemachine;

import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class StateUploadScheduler extends BaseTask {
    public static final int SCHEDULED_RATE = 15;
    public static StateUploadScheduler mInstance;
    public AtomicBoolean mIsRunning = new AtomicBoolean(false);

    public static StateUploadScheduler getInstance() {
        if (mInstance == null) {
            synchronized (StateUploadScheduler.class) {
                if (mInstance == null) {
                    mInstance = new StateUploadScheduler();
                }
            }
        }
        return mInstance;
    }

    @Override // com.baidu.mobads.container.executor.BaseTask
    public Object doInBackground() {
        if (this.mIsRunning.get()) {
            RemoteXAdLogger.getInstance().d("StateMachine", "running!!!");
            StateMachine.markTimeoutState();
            StateMachine.uploadState();
            StateMachine.removeUnusedState();
            if (StateMachine.mAdStatusList.size() == 0) {
                stop();
                return null;
            }
            return null;
        }
        stop();
        return null;
    }

    public synchronized void start() {
        try {
            if (!this.mIsRunning.get()) {
                TaskScheduler.getInstance().submitAtFixedRate(this, 0L, 15L, TimeUnit.SECONDS);
                this.mIsRunning.set(true);
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }

    public synchronized void stop() {
        try {
            if (!isCanceled()) {
                cancel();
                this.mIsRunning.set(false);
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }
}
