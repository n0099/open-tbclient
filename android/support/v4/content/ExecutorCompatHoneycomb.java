package android.support.v4.content;

import android.os.AsyncTask;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
class ExecutorCompatHoneycomb {
    public static Executor getParallelExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}
