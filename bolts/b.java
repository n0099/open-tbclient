package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes19.dex */
final class b {
    private static final b zq = new b();
    private final ExecutorService zr;
    private final ScheduledExecutorService zs;
    private final Executor zt;

    private static boolean gA() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.zr = !gA() ? Executors.newCachedThreadPool() : bolts.a.gy();
        this.zs = Executors.newSingleThreadScheduledExecutor();
        this.zt = new a();
    }

    public static ExecutorService gB() {
        return zq.zr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor gC() {
        return zq.zt;
    }

    /* loaded from: classes19.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> zu;

        private a() {
            this.zu = new ThreadLocal<>();
        }

        private int gD() {
            Integer num = this.zu.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.zu.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int gE() {
            Integer num = this.zu.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zu.remove();
            } else {
                this.zu.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (gD() <= 15) {
                    runnable.run();
                } else {
                    b.gB().execute(runnable);
                }
            } finally {
                gE();
            }
        }
    }
}
