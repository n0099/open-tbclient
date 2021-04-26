package com.baidu.mobads.container.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class BaseTask<T> implements Runnable {
    public static final String LOG_TAG = "BaseTask";
    public static final int MESSAGE_POST_CANCEL = 3;
    public static final int MESSAGE_POST_FAIL = 2;
    public static final int MESSAGE_POST_SUCCESS = 1;
    public static InternalHandler sHandler;
    public long mCompleteTime;
    public long mExecuteTime;
    public String mName;
    public Future<T> mTask;
    public long mTaskAddTime;

    /* loaded from: classes2.dex */
    public static class BaseTaskResult<T> {
        public final T mData;
        public final BaseTask mTask;

        public BaseTaskResult(BaseTask baseTask, T t) {
            this.mTask = baseTask;
            this.mData = t;
        }
    }

    /* loaded from: classes2.dex */
    public static class InternalHandler extends Handler {
        public InternalHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaseTaskResult baseTaskResult = (BaseTaskResult) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                baseTaskResult.mTask.onTaskSuccess(baseTaskResult.mData);
            } else if (i2 == 2) {
                baseTaskResult.mTask.onTaskFailed((Throwable) baseTaskResult.mData);
            } else if (i2 != 3) {
            } else {
                baseTaskResult.mTask.onTaskCancelled();
            }
        }
    }

    public BaseTask() {
        this.mName = "default";
    }

    public static Handler getMainHandler() {
        InternalHandler internalHandler;
        synchronized (BaseTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler(Looper.getMainLooper());
            }
            internalHandler = sHandler;
        }
        return internalHandler;
    }

    public void cancel(boolean z) {
        Future<T> future = this.mTask;
        if (future != null) {
            future.cancel(z);
            getMainHandler().obtainMessage(3, new BaseTaskResult(this, null)).sendToTarget();
        }
    }

    public abstract T doInBackground();

    public BaseTask enterExecute() {
        try {
            this.mExecuteTime = System.currentTimeMillis();
            getMainHandler().obtainMessage(1, new BaseTaskResult(this, doInBackground())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    public long getCreateToComplete() {
        return this.mCompleteTime - this.mTaskAddTime;
    }

    public long getCreateToExecuteTime() {
        return this.mExecuteTime - this.mTaskAddTime;
    }

    public long getExecuteToComplete() {
        return this.mCompleteTime - this.mExecuteTime;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isCanceled() {
        Future<T> future = this.mTask;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean isComplete() {
        Future<T> future = this.mTask;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public void onTaskCancelled() {
    }

    public void onTaskFailed(Throwable th) {
    }

    public void onTaskSuccess(T t) {
    }

    @Override // java.lang.Runnable
    public void run() {
        enterExecute();
    }

    public void setTask(Future future) {
        this.mTask = future;
    }

    public void setTaskAddTime(long j) {
        this.mTaskAddTime = j;
    }

    public BaseTask(String str) {
        this.mName = str;
    }

    public void cancel() {
        cancel(false);
    }
}
