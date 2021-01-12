package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.Thread;
/* loaded from: classes4.dex */
public class JavaHandlerThread {
    public final HandlerThread mThread;
    public Throwable mUnhandledException;

    static {
        JavaHandlerThread.class.desiredAssertionStatus();
    }

    public JavaHandlerThread(String str, int i) {
        this.mThread = new HandlerThread(str, i);
    }

    @CalledByNative
    public static JavaHandlerThread create(String str, int i) {
        return new JavaHandlerThread(str, i);
    }

    @CalledByNative
    private Throwable getUncaughtExceptionIfAny() {
        return this.mUnhandledException;
    }

    @CalledByNative
    private boolean isAlive() {
        return this.mThread.isAlive();
    }

    @CalledByNative
    private void joinThread() {
        boolean z = false;
        while (!z) {
            try {
                this.mThread.join();
                z = true;
            } catch (InterruptedException e) {
            }
        }
    }

    @CalledByNative
    private void listenForUncaughtExceptionsForTesting() {
        this.mThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: aegon.chrome.base.JavaHandlerThread.3
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JavaHandlerThread.this.mUnhandledException = th;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitializeThread(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnLooperStopped(long j);

    @CalledByNative
    private void quitThreadSafely(final long j) {
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: aegon.chrome.base.JavaHandlerThread.2
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThread.this.mThread.quit();
                JavaHandlerThread.this.nativeOnLooperStopped(j);
            }
        });
        if (Build.VERSION.SDK_INT >= 18) {
            this.mThread.getLooper().quitSafely();
        }
    }

    @CalledByNative
    private void startAndInitialize(final long j, final long j2) {
        maybeStart();
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: aegon.chrome.base.JavaHandlerThread.1
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThread.this.nativeInitializeThread(j, j2);
            }
        });
    }

    public void maybeStart() {
        if (this.mThread.getState() != Thread.State.NEW) {
            return;
        }
        this.mThread.start();
    }
}
