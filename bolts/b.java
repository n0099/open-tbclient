package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes12.dex */
final class b {
    private static final b zY = new b();
    private final ScheduledExecutorService Aa;
    private final Executor Ab;
    private final ExecutorService zZ;

    private static boolean hZ() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.zZ = !hZ() ? Executors.newCachedThreadPool() : bolts.a.hX();
        this.Aa = Executors.newSingleThreadScheduledExecutor();
        this.Ab = new a();
    }

    public static ExecutorService ia() {
        return zY.zZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor ib() {
        return zY.Ab;
    }

    /* loaded from: classes12.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> Ac;

        private a() {
            this.Ac = new ThreadLocal<>();
        }

        private int ic() {
            Integer num = this.Ac.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.Ac.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int ie() {
            Integer num = this.Ac.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.Ac.remove();
            } else {
                this.Ac.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (ic() <= 15) {
                    runnable.run();
                } else {
                    b.ia().execute(runnable);
                }
            } finally {
                ie();
            }
        }
    }
}
