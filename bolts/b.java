package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
final class b {
    private static final b Aq = new b();
    private final ExecutorService Ar;
    private final ScheduledExecutorService As;
    private final Executor At;

    private static boolean ia() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.Ar = !ia() ? Executors.newCachedThreadPool() : bolts.a.hY();
        this.As = Executors.newSingleThreadScheduledExecutor();
        this.At = new a();
    }

    public static ExecutorService ib() {
        return Aq.Ar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor ic() {
        return Aq.At;
    }

    /* loaded from: classes6.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> Au;

        private a() {
            this.Au = new ThreadLocal<>();
        }

        private int ie() {
            Integer num = this.Au.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.Au.set(Integer.valueOf(intValue));
            return intValue;
        }

        /* renamed from: if  reason: not valid java name */
        private int m7if() {
            Integer num = this.Au.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.Au.remove();
            } else {
                this.Au.set(Integer.valueOf(intValue));
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
                m7if();
            }
        }
    }
}
