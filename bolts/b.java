package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
final class b {
    private static final b jL = new b();
    private final ExecutorService jM;
    private final ScheduledExecutorService jN;
    private final Executor jO;

    private static boolean aW() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.jM = !aW() ? Executors.newCachedThreadPool() : bolts.a.newCachedThreadPool();
        this.jN = Executors.newSingleThreadScheduledExecutor();
        this.jO = new a();
    }

    public static ExecutorService aX() {
        return jL.jM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor aY() {
        return jL.jO;
    }

    /* loaded from: classes2.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> jP;

        private a() {
            this.jP = new ThreadLocal<>();
        }

        private int aZ() {
            Integer num = this.jP.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.jP.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int ba() {
            Integer num = this.jP.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.jP.remove();
            } else {
                this.jP.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (aZ() <= 15) {
                    runnable.run();
                } else {
                    b.aX().execute(runnable);
                }
            } finally {
                ba();
            }
        }
    }
}
