package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class a extends c {
    private static volatile a yu;
    @NonNull
    private static final Executor sMainThreadExecutor = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.hq().d(runnable);
        }
    };
    @NonNull
    private static final Executor yx = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.hq().c(runnable);
        }
    };
    @NonNull
    private c yw = new b();
    @NonNull
    private c yv = this.yw;

    private a() {
    }

    @NonNull
    public static a hq() {
        if (yu != null) {
            return yu;
        }
        synchronized (a.class) {
            if (yu == null) {
                yu = new a();
            }
        }
        return yu;
    }

    @Override // android.arch.a.a.c
    public void c(Runnable runnable) {
        this.yv.c(runnable);
    }

    @Override // android.arch.a.a.c
    public void d(Runnable runnable) {
        this.yv.d(runnable);
    }

    @Override // android.arch.a.a.c
    public boolean isMainThread() {
        return this.yv.isMainThread();
    }
}
