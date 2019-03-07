package bolts;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
final class a {
    private final Executor jI = new ExecutorC0004a();
    private static final a jH = new a();
    private static final int jJ = Runtime.getRuntime().availableProcessors();
    static final int CORE_POOL_SIZE = jJ + 1;
    static final int jK = (jJ * 2) + 1;

    private a() {
    }

    public static ExecutorService newCachedThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, jK, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    public static Executor aV() {
        return jH.jI;
    }

    /* renamed from: bolts.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class ExecutorC0004a implements Executor {
        private ExecutorC0004a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
