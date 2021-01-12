package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public class UpMessageManager {
    private static final String TAG = UpMessageManager.class.getSimpleName();
    private static UpMessageManager mInstance;
    private EventHandler mEventHandler;
    private ConcurrentLinkedQueue<Task> mTaskList = new ConcurrentLinkedQueue<>();
    private ThreadPoolExecutor mThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    private boolean onDispath = false;
    private boolean onTaskRunning = false;
    private HandlerThread mHandlerThread = new HandlerThread("task listeners handler thread", 0);

    /* loaded from: classes3.dex */
    public static class Task {
        protected String mAction;
        private boolean mIsRunning;
        protected String mJson;

        protected Task() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Task(String str, String str2) {
            this.mAction = str;
            this.mJson = str2;
            this.mIsRunning = false;
        }

        protected void work() {
        }
    }

    public static synchronized UpMessageManager getInstance(Context context) {
        UpMessageManager upMessageManager;
        synchronized (UpMessageManager.class) {
            if (mInstance == null) {
                mInstance = new UpMessageManager();
            }
            upMessageManager = mInstance;
        }
        return upMessageManager;
    }

    public UpMessageManager() {
        this.mHandlerThread.start();
        this.mEventHandler = new EventHandler(this, this.mHandlerThread.getLooper());
    }

    public void addTaskRequest(Task task) {
        if (task != null) {
            this.mTaskList.add(task);
            if (!this.onDispath) {
                dispatch();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatch() {
        this.onDispath = true;
        if (this.mThreadPool.getActiveCount() >= this.mThreadPool.getCorePoolSize()) {
            LogUtils.d(TAG, "FXF  没有空闲线程 ");
            return;
        }
        int corePoolSize = this.mThreadPool.getCorePoolSize() - this.mThreadPool.getActiveCount();
        if (!this.onTaskRunning && corePoolSize > 0) {
            execute(this.mTaskList.poll());
        }
    }

    public void clear() {
        this.mTaskList.clear();
    }

    private void execute(final Task task) {
        this.mThreadPool.execute(new Runnable() { // from class: com.baidu.android.imsdk.mcast.UpMessageManager.1
            @Override // java.lang.Runnable
            public void run() {
                UpMessageManager.this.onTaskRunning = true;
                try {
                    task.work();
                } catch (Exception e) {
                    UpMessageManager.this.onTaskRunning = false;
                    LogUtils.e(UpMessageManager.TAG, "request work excepation", e);
                }
                LogUtils.d(UpMessageManager.TAG, "FXF  finish a work task ");
                UpMessageManager.this.mEventHandler.sendMessage(UpMessageManager.this.mEventHandler.obtainMessage());
            }
        });
    }

    /* loaded from: classes3.dex */
    class EventHandler extends Handler {
        private final WeakReference<UpMessageManager> mActivity;

        public EventHandler(UpMessageManager upMessageManager, Looper looper) {
            super(looper);
            this.mActivity = new WeakReference<>(upMessageManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            UpMessageManager.this.onTaskRunning = false;
            UpMessageManager upMessageManager = this.mActivity.get();
            if (upMessageManager != null) {
                if (UpMessageManager.this.mTaskList.size() > 0) {
                    upMessageManager.dispatch();
                } else {
                    UpMessageManager.this.onDispath = false;
                }
            }
        }
    }
}
