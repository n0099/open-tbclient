package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
final class b {
    private static final b zo = new b();
    private final ExecutorService zp;
    private final ScheduledExecutorService zq;
    private final Executor zr;

    private static boolean gA() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.zp = !gA() ? Executors.newCachedThreadPool() : bolts.a.gy();
        this.zq = Executors.newSingleThreadScheduledExecutor();
        this.zr = new a();
    }

    public static ExecutorService gB() {
        return zo.zp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor gC() {
        return zo.zr;
    }

    /* loaded from: classes7.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> zs;

        private a() {
            this.zs = new ThreadLocal<>();
        }

        private int gD() {
            Integer num = this.zs.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.zs.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int gE() {
            Integer num = this.zs.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zs.remove();
            } else {
                this.zs.set(Integer.valueOf(intValue));
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
