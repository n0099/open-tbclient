package com.baidu.sapi2.passhost.hostsdk.service;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
@TargetApi(3)
/* loaded from: classes.dex */
public class ThreadPoolService implements IThreadPoolService {

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
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void run(TPRunnable tPRunnable) {
        runDelay(tPRunnable, 0L);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void runDelay(final TPRunnable tPRunnable, final long j) {
        AsyncTask<Object, Void, Void> asyncTask = new AsyncTask<Object, Void, Void>() { // from class: com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public Void doInBackground(Object... objArr) {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException e) {
                    Log.e(e);
                }
                tPRunnable.run();
                return null;
            }
        };
        if (Build.VERSION.SDK_INT > 10) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } else {
            asyncTask.execute(new Object[0]);
        }
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void runInUiThread(TPRunnable tPRunnable) {
        runInUiThreadDelay(tPRunnable, 0L);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void runInUiThreadDelay(final TPRunnable tPRunnable, final long j) {
        AsyncTask<Object, Void, Void> asyncTask = new AsyncTask<Object, Void, Void>() { // from class: com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public Void doInBackground(Object... objArr) {
                try {
                    Thread.sleep(j);
                    return null;
                } catch (InterruptedException e) {
                    Log.e(e);
                    return null;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(Void r2) {
                super.onPostExecute(r2);
                tPRunnable.run();
            }
        };
        if (Build.VERSION.SDK_INT > 10) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } else {
            asyncTask.execute(new Object[0]);
        }
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IThreadPoolService
    public void runImport(TPRunnable tPRunnable) {
        run(tPRunnable);
    }

    public void runDelayImport(TPRunnable tPRunnable, long j) {
        runDelay(tPRunnable, j);
    }
}
