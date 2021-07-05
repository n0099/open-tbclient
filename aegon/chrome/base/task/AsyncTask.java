package aegon.chrome.base.task;

import aegon.chrome.base.Log;
import androidx.loader.content.ModernAsyncTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
    public static /* synthetic */ Interceptable $ic;
    public static final Executor THREAD_POOL_EXECUTOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean mTaskInvoked;

    /* renamed from: aegon.chrome.base.task.AsyncTask$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Callable<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class NamedFutureTask extends FutureTask<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AsyncTask this$0;

        @Override // java.util.concurrent.FutureTask
        public void done() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    /* loaded from: classes.dex */
    public static class StealRunnableHandler implements RejectedExecutionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ StealRunnableHandler(AnonymousClass1 anonymousClass1) {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2028168990, "Laegon/chrome/base/task/AsyncTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2028168990, "Laegon/chrome/base/task/AsyncTask;");
                return;
            }
        }
        THREAD_POOL_EXECUTOR = AsyncTask$$Lambda$1.$ic;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, result) == null) {
            throw null;
        }
    }
}
