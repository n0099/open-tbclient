package android.arch.a.a;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class b extends c {
    @Nullable
    private volatile Handler mMainHandler;
    private final Object mLock = new Object();
    private ExecutorService yP = Executors.newFixedThreadPool(2);

    @Override // android.arch.a.a.c
    public void c(Runnable runnable) {
        this.yP.execute(runnable);
    }

    @Override // android.arch.a.a.c
    public void d(Runnable runnable) {
        if (this.mMainHandler == null) {
            synchronized (this.mLock) {
                if (this.mMainHandler == null) {
                    this.mMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.mMainHandler.post(runnable);
    }

    @Override // android.arch.a.a.c
    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
