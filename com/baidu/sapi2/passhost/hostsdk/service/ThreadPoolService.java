package com.baidu.sapi2.passhost.hostsdk.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class ThreadPoolService implements IThreadPoolService {
    private static final String a = "ThreadPoolService";
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;
    private ExecutorService b;
    private Handler f;

    /* loaded from: classes.dex */
    private static class a {
        public static ThreadPoolService a = new ThreadPoolService();

        private a() {
        }
    }

    public static ThreadPoolService getInstance() {
        return a.a;
    }

    private ThreadPoolService() {
        this.f = new Handler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        ((TPRunnable) message.obj).run();
                        return;
                    case 1:
                        ThreadPoolService.this.b.submit(((TPRunnable) message.obj).runable);
                        return;
                    case 2:
                        ThreadPoolService.this.b.submit(((TPRunnable) message.obj).runable);
                        return;
                    default:
                        return;
                }
            }
        };
        this.b = Executors.newScheduledThreadPool(6);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void run(TPRunnable tPRunnable) {
        Log.d(a, "run()", tPRunnable.taskName);
        this.b.submit(tPRunnable);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void runDelay(TPRunnable tPRunnable, long j) {
        Log.d(a, "runDelay()", tPRunnable.taskName, Long.valueOf(j));
        this.f.sendMessageDelayed(this.f.obtainMessage(2, tPRunnable), j);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void runInUiThread(TPRunnable tPRunnable) {
        Log.d(a, "runInUiThread()", tPRunnable.taskName);
        this.f.sendMessage(this.f.obtainMessage(0, tPRunnable));
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void runInUiThreadDelay(TPRunnable tPRunnable, long j) {
        Log.d(a, "runInUiThreadDelay()", tPRunnable.taskName, Long.valueOf(j));
        this.f.sendMessageDelayed(this.f.obtainMessage(0, tPRunnable), j);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void runImport(TPRunnable tPRunnable) {
        Log.d(a, "runImport()", tPRunnable.taskName);
        this.b.submit(tPRunnable);
    }

    public void runDelayImport(TPRunnable tPRunnable, long j) {
        Log.d(a, "runDelayImport()", tPRunnable.taskName, Long.valueOf(j));
        this.f.sendMessageDelayed(this.f.obtainMessage(1, tPRunnable), j);
    }
}
