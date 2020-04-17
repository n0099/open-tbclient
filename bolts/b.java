package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
final class b {
    private static final b yO = new b();
    private final ExecutorService yP;
    private final ScheduledExecutorService yQ;
    private final Executor yR;

    private static boolean gk() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private b() {
        this.yP = !gk() ? Executors.newCachedThreadPool() : bolts.a.gi();
        this.yQ = Executors.newSingleThreadScheduledExecutor();
        this.yR = new a();
    }

    public static ExecutorService gl() {
        return yO.yP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor gm() {
        return yO.yR;
    }

    /* loaded from: classes7.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> yS;

        private a() {
            this.yS = new ThreadLocal<>();
        }

        private int gn() {
            Integer num = this.yS.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.yS.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int go() {
            Integer num = this.yS.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.yS.remove();
            } else {
                this.yS.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (gn() <= 15) {
                    runnable.run();
                } else {
                    b.gl().execute(runnable);
                }
            } finally {
                go();
            }
        }
    }
}
