package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
final class b {
    private static final b cu = new b();
    private final ExecutorService cv;
    private final ScheduledExecutorService cx;
    private final Executor cy;

    private static boolean aB() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.cv = !aB() ? Executors.newCachedThreadPool() : bolts.a.az();
        this.cx = Executors.newSingleThreadScheduledExecutor();
        this.cy = new a();
    }

    public static ExecutorService aC() {
        return cu.cv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor aD() {
        return cu.cy;
    }

    /* loaded from: classes2.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> cz;

        private a() {
            this.cz = new ThreadLocal<>();
        }

        private int aE() {
            Integer num = this.cz.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.cz.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int aF() {
            Integer num = this.cz.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.cz.remove();
            } else {
                this.cz.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (aE() <= 15) {
                    runnable.run();
                } else {
                    b.aC().execute(runnable);
                }
            } finally {
                aF();
            }
        }
    }
}
