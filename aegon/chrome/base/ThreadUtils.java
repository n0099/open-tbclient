package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public class ThreadUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Object sLock = new Object();
    public static boolean sThreadAssertsDisabled;
    public static Handler sUiThreadHandler;
    public static boolean sWillOverride;

    public static void assertOnUiThread() {
        boolean z = sThreadAssertsDisabled;
    }

    public static Handler getUiThreadHandler() {
        Handler handler;
        synchronized (sLock) {
            if (sUiThreadHandler == null) {
                if (sWillOverride) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                sUiThreadHandler = new Handler(Looper.getMainLooper());
            }
            handler = sUiThreadHandler;
        }
        return handler;
    }

    @CalledByNative
    public static boolean isThreadPriorityAudio(int i) {
        return Process.getThreadPriority(i) == -16;
    }

    @Deprecated
    public static <T> T runOnUiThreadBlockingNoException(Callable<T> callable) {
        try {
            FutureTask futureTask = new FutureTask(callable);
            if (runningOnUiThread()) {
                futureTask.run();
            } else {
                getUiThreadHandler().post(futureTask);
            }
            try {
                return (T) futureTask.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException("Interrupted waiting for callable", e2);
            }
        } catch (ExecutionException e3) {
            throw new RuntimeException("Error occurred waiting for callable", e3);
        }
    }

    public static boolean runningOnUiThread() {
        return getUiThreadHandler().getLooper() == Looper.myLooper();
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int i) {
        Process.setThreadPriority(i, -16);
    }
}
