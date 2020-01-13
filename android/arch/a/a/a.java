package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class a extends c {
    private static volatile a br;
    @NonNull
    private static final Executor sMainThreadExecutor = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.ap().d(runnable);
        }
    };
    @NonNull
    private static final Executor bu = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.ap().c(runnable);
        }
    };
    @NonNull
    private c bt = new b();
    @NonNull
    private c bs = this.bt;

    private a() {
    }

    @NonNull
    public static a ap() {
        if (br != null) {
            return br;
        }
        synchronized (a.class) {
            if (br == null) {
                br = new a();
            }
        }
        return br;
    }

    @Override // android.arch.a.a.c
    public void c(Runnable runnable) {
        this.bs.c(runnable);
    }

    @Override // android.arch.a.a.c
    public void d(Runnable runnable) {
        this.bs.d(runnable);
    }

    @Override // android.arch.a.a.c
    public boolean isMainThread() {
        return this.bs.isMainThread();
    }
}
