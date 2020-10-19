package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes15.dex */
public class a extends c {
    private static volatile a yL;
    @NonNull
    private static final Executor sMainThreadExecutor = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.hr().d(runnable);
        }
    };
    @NonNull
    private static final Executor yO = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.hr().c(runnable);
        }
    };
    @NonNull
    private c yN = new b();
    @NonNull
    private c yM = this.yN;

    private a() {
    }

    @NonNull
    public static a hr() {
        if (yL != null) {
            return yL;
        }
        synchronized (a.class) {
            if (yL == null) {
                yL = new a();
            }
        }
        return yL;
    }

    @Override // android.arch.a.a.c
    public void c(Runnable runnable) {
        this.yM.c(runnable);
    }

    @Override // android.arch.a.a.c
    public void d(Runnable runnable) {
        this.yM.d(runnable);
    }

    @Override // android.arch.a.a.c
    public boolean isMainThread() {
        return this.yM.isMainThread();
    }
}
