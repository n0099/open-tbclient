package bolts;

import com.baidu.ar.constants.HttpConstants;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes14.dex */
final class b {
    private static final b Co = new b();
    private final ExecutorService Cp;
    private final ScheduledExecutorService Cq;
    private final Executor Cr;

    private static boolean hA() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains(HttpConstants.OS_TYPE_VALUE);
    }

    private b() {
        this.Cp = !hA() ? Executors.newCachedThreadPool() : bolts.a.hy();
        this.Cq = Executors.newSingleThreadScheduledExecutor();
        this.Cr = new a();
    }

    public static ExecutorService hB() {
        return Co.Cp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor hC() {
        return Co.Cr;
    }

    /* loaded from: classes14.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> Cs;

        private a() {
            this.Cs = new ThreadLocal<>();
        }

        private int hD() {
            Integer num = this.Cs.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.Cs.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int hE() {
            Integer num = this.Cs.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.Cs.remove();
            } else {
                this.Cs.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (hD() <= 15) {
                    runnable.run();
                } else {
                    b.hB().execute(runnable);
                }
            } finally {
                hE();
            }
        }
    }
}
