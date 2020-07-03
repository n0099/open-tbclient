package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public class a extends c {
    private static volatile a xV;
    @NonNull
    private static final Executor sMainThreadExecutor = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.gb().f(runnable);
        }
    };
    @NonNull
    private static final Executor xY = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.gb().e(runnable);
        }
    };
    @NonNull
    private c xX = new b();
    @NonNull
    private c xW = this.xX;

    private a() {
    }

    @NonNull
    public static a gb() {
        if (xV != null) {
            return xV;
        }
        synchronized (a.class) {
            if (xV == null) {
                xV = new a();
            }
        }
        return xV;
    }

    @Override // android.arch.a.a.c
    public void e(Runnable runnable) {
        this.xW.e(runnable);
    }

    @Override // android.arch.a.a.c
    public void f(Runnable runnable) {
        this.xW.f(runnable);
    }

    @Override // android.arch.a.a.c
    public boolean isMainThread() {
        return this.xW.isMainThread();
    }
}
