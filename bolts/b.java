package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes10.dex */
final class b {
    private static final b Bk = new b();
    private final ExecutorService Bl;
    private final ScheduledExecutorService Bm;
    private final Executor Bn;

    private static boolean ia() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.Bl = !ia() ? Executors.newCachedThreadPool() : bolts.a.hY();
        this.Bm = Executors.newSingleThreadScheduledExecutor();
        this.Bn = new a();
    }

    public static ExecutorService ib() {
        return Bk.Bl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor ic() {
        return Bk.Bn;
    }

    /* loaded from: classes10.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> Bo;

        private a() {
            this.Bo = new ThreadLocal<>();
        }

        private int ie() {
            Integer num = this.Bo.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.Bo.set(Integer.valueOf(intValue));
            return intValue;
        }

        /* renamed from: if  reason: not valid java name */
        private int m6if() {
            Integer num = this.Bo.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.Bo.remove();
            } else {
                this.Bo.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (ie() <= 15) {
                    runnable.run();
                } else {
                    b.ib().execute(runnable);
                }
            } finally {
                m6if();
            }
        }
    }
}
