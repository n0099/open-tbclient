package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
final class b {
    private static final b bT = new b();
    private final ExecutorService bV;
    private final ScheduledExecutorService bW;
    private final Executor bX;

    private static boolean aB() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.bV = !aB() ? Executors.newCachedThreadPool() : bolts.a.az();
        this.bW = Executors.newSingleThreadScheduledExecutor();
        this.bX = new a();
    }

    public static ExecutorService aC() {
        return bT.bV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor aD() {
        return bT.bX;
    }

    /* loaded from: classes2.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> bY;

        private a() {
            this.bY = new ThreadLocal<>();
        }

        private int aE() {
            Integer num = this.bY.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.bY.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int aF() {
            Integer num = this.bY.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.bY.remove();
            } else {
                this.bY.set(Integer.valueOf(intValue));
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
