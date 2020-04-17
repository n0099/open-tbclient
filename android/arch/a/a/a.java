package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public class a extends c {
    private static volatile a xv;
    @NonNull
    private static final Executor sMainThreadExecutor = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.fL().f(runnable);
        }
    };
    @NonNull
    private static final Executor xy = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.fL().e(runnable);
        }
    };
    @NonNull
    private c xx = new b();
    @NonNull
    private c xw = this.xx;

    private a() {
    }

    @NonNull
    public static a fL() {
        if (xv != null) {
            return xv;
        }
        synchronized (a.class) {
            if (xv == null) {
                xv = new a();
            }
        }
        return xv;
    }

    @Override // android.arch.a.a.c
    public void e(Runnable runnable) {
        this.xw.e(runnable);
    }

    @Override // android.arch.a.a.c
    public void f(Runnable runnable) {
        this.xw.f(runnable);
    }

    @Override // android.arch.a.a.c
    public boolean isMainThread() {
        return this.xw.isMainThread();
    }
}
