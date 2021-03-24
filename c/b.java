package c;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static final b f1459c = new b();

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f1460a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f1461b;

    /* renamed from: c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ExecutorC0013b implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public ThreadLocal<Integer> f1462e;

        public ExecutorC0013b() {
            this.f1462e = new ThreadLocal<>();
        }

        public final int a() {
            Integer num = this.f1462e.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f1462e.remove();
            } else {
                this.f1462e.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public final int b() {
            Integer num = this.f1462e.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f1462e.set(Integer.valueOf(intValue));
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (b() <= 15) {
                    runnable.run();
                } else {
                    b.a().execute(runnable);
                }
            } finally {
                a();
            }
        }
    }

    public b() {
        this.f1460a = !c() ? Executors.newCachedThreadPool() : c.a.b();
        Executors.newSingleThreadScheduledExecutor();
        this.f1461b = new ExecutorC0013b();
    }

    public static ExecutorService a() {
        return f1459c.f1460a;
    }

    public static Executor b() {
        return f1459c.f1461b;
    }

    public static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
