package aegon.chrome.base.task;

import aegon.chrome.base.Log;
import androidx.loader.content.ModernAsyncTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AsyncTask<Result> {
    public static final Executor THREAD_POOL_EXECUTOR;
    public final AtomicBoolean mTaskInvoked;

    /* renamed from: aegon.chrome.base.task.AsyncTask$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Callable<Result> {
    }

    /* loaded from: classes.dex */
    public class NamedFutureTask extends FutureTask<Result> {
        public final /* synthetic */ AsyncTask this$0;

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                AsyncTask.access$400(this.this$0, get());
            } catch (InterruptedException e2) {
                Object[] objArr = new Object[0];
                String formatLog = Log.formatLog(e2.toString(), objArr);
                Throwable throwableToLog = Log.getThrowableToLog(objArr);
                String normalizeTag = Log.normalizeTag(ModernAsyncTask.LOG_TAG);
                if (throwableToLog != null) {
                    android.util.Log.w(normalizeTag, formatLog, throwableToLog);
                } else {
                    android.util.Log.w(normalizeTag, formatLog);
                }
            } catch (CancellationException unused) {
                AsyncTask.access$400(this.this$0, null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class StealRunnableHandler implements RejectedExecutionHandler {
        public /* synthetic */ StealRunnableHandler(AnonymousClass1 anonymousClass1) {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }

    static {
        Executor executor;
        executor = AsyncTask$$Lambda$1.instance;
        THREAD_POOL_EXECUTOR = executor;
        new SerialExecutor();
        new StealRunnableHandler(null);
    }

    public static /* synthetic */ void access$400(AsyncTask asyncTask, Object obj) {
        if (asyncTask.mTaskInvoked.get()) {
            return;
        }
        asyncTask.postResult(obj);
    }

    public final void postResult(Result result) {
        throw null;
    }
}
