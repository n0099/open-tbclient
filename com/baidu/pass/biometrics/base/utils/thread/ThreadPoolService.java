package com.baidu.pass.biometrics.base.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.pass.biometrics.base.debug.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class ThreadPoolService implements IThreadPoolService {
    private static final int MSG_RUN_IN_UI_THREAD = 0;
    private static final String Tag = "ThreadPoolService";
    private ExecutorService mCommonRunPool;
    private Handler mHandler;
    private ExecutorService mImportRunPool;

    /* loaded from: classes2.dex */
    private static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();

        private SingletonContainer() {
        }
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    private ThreadPoolService() {
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        TPRunnable tPRunnable = (TPRunnable) message.obj;
                        if (tPRunnable.runable != null) {
                            tPRunnable.runable.run();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.mCommonRunPool = Executors.newScheduledThreadPool(6);
        this.mImportRunPool = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.pass.biometrics.base.utils.thread.IThreadPoolService
    public void run(TPRunnable tPRunnable) {
        this.mCommonRunPool.submit(tPRunnable);
    }

    @Override // com.baidu.pass.biometrics.base.utils.thread.IThreadPoolService
    public void runDelay(TPRunnable tPRunnable, long j) {
        Log.d(Tag, "runDelay()", tPRunnable.taskName, Long.valueOf(j));
        this.mCommonRunPool.submit(tPRunnable, Long.valueOf(j));
    }

    @Override // com.baidu.pass.biometrics.base.utils.thread.IThreadPoolService
    public void runInUiThread(TPRunnable tPRunnable) {
        Log.d(Tag, "runInUiThread()", tPRunnable.taskName);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, tPRunnable));
    }

    @Override // com.baidu.pass.biometrics.base.utils.thread.IThreadPoolService
    public void runInUiThreadDelay(TPRunnable tPRunnable, long j) {
        Log.d(Tag, "runInUiThreadDelay()", tPRunnable.taskName, Long.valueOf(j));
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, tPRunnable), j);
    }

    @Override // com.baidu.pass.biometrics.base.utils.thread.IThreadPoolService
    public void runImport(TPRunnable tPRunnable) {
        Log.d(Tag, "runImport()", tPRunnable.taskName);
        this.mImportRunPool.submit(tPRunnable);
    }

    public void runDelayImport(TPRunnable tPRunnable, long j) {
        Log.d(Tag, "runDelayImport()", tPRunnable.taskName, Long.valueOf(j));
        this.mImportRunPool.submit(tPRunnable, Long.valueOf(j));
    }
}
