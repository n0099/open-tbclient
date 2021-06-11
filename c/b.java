package c;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static final b f1477c = new b();

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f1478a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f1479b;

    /* renamed from: c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ExecutorC0013b implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public ThreadLocal<Integer> f1480e;

        public ExecutorC0013b() {
            this.f1480e = new ThreadLocal<>();
        }

        public final int a() {
            Integer num = this.f1480e.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f1480e.remove();
            } else {
                this.f1480e.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public final int b() {
            Integer num = this.f1480e.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f1480e.set(Integer.valueOf(intValue));
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
        this.f1478a = !c() ? Executors.newCachedThreadPool() : c.a.b();
        Executors.newSingleThreadScheduledExecutor();
        this.f1479b = new ExecutorC0013b();
    }

    public static ExecutorService a() {
        return f1477c.f1478a;
    }

    public static Executor b() {
        return f1477c.f1479b;
    }

    public static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
