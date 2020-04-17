package com.baidu.sapi2.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.ActivityChooserView;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class ThreadPoolService implements com.baidu.sapi2.c {
    private static final ThreadFactory a = new s();
    private static final int b = 0;
    private static final int c = 1;
    private Handler d;
    public ThreadPoolExecutor poolService;

    /* loaded from: classes6.dex */
    private static class a {
        static ThreadPoolService a = new ThreadPoolService(null);

        private a() {
        }
    }

    /* synthetic */ ThreadPoolService(s sVar) {
        this();
    }

    public static ThreadPoolService getInstance() {
        return a.a;
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.d.sendMessage(this.d.obtainMessage(0, tPRunnable));
    }

    private ThreadPoolService() {
        this.d = new t(this, Looper.getMainLooper());
        this.poolService = new ThreadPoolExecutor(6, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), a);
        if (Build.VERSION.SDK_INT >= 9) {
            this.poolService.allowCoreThreadTimeOut(true);
        }
    }
}
