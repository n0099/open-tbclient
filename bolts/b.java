package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
final class b {
    private static final b jK = new b();
    private final ExecutorService jL;
    private final ScheduledExecutorService jM;
    private final Executor jN;

    private static boolean aY() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.jL = !aY() ? Executors.newCachedThreadPool() : bolts.a.aW();
        this.jM = Executors.newSingleThreadScheduledExecutor();
        this.jN = new a();
    }

    public static ExecutorService aZ() {
        return jK.jL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor ba() {
        return jK.jN;
    }

    /* loaded from: classes2.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> jO;

        private a() {
            this.jO = new ThreadLocal<>();
        }

        private int bb() {
            Integer num = this.jO.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.jO.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int bc() {
            Integer num = this.jO.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.jO.remove();
            } else {
                this.jO.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (bb() <= 15) {
                    runnable.run();
                } else {
                    b.aZ().execute(runnable);
                }
            } finally {
                bc();
            }
        }
    }
}
