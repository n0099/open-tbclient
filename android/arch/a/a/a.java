package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes17.dex */
public class a extends c {
    private static volatile a zA;
    @NonNull
    private static final Executor sMainThreadExecutor = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.hr().d(runnable);
        }
    };
    @NonNull
    private static final Executor zD = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.hr().c(runnable);
        }
    };
    @NonNull
    private c zC = new b();
    @NonNull
    private c zB = this.zC;

    private a() {
    }

    @NonNull
    public static a hr() {
        if (zA != null) {
            return zA;
        }
        synchronized (a.class) {
            if (zA == null) {
                zA = new a();
            }
        }
        return zA;
    }

    @Override // android.arch.a.a.c
    public void c(Runnable runnable) {
        this.zB.c(runnable);
    }

    @Override // android.arch.a.a.c
    public void d(Runnable runnable) {
        this.zB.d(runnable);
    }

    @Override // android.arch.a.a.c
    public boolean isMainThread() {
        return this.zB.isMainThread();
    }
}
