package bolts;

import com.baidu.ar.constants.HttpConstants;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
final class b {
    private static final b jH = new b();
    private final ExecutorService jI;
    private final ScheduledExecutorService jJ;
    private final Executor jK;

    private static boolean aW() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains(HttpConstants.OS_TYPE_VALUE);
    }

    private b() {
        this.jI = !aW() ? Executors.newCachedThreadPool() : bolts.a.newCachedThreadPool();
        this.jJ = Executors.newSingleThreadScheduledExecutor();
        this.jK = new a();
    }

    public static ExecutorService aX() {
        return jH.jI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor aY() {
        return jH.jK;
    }

    /* loaded from: classes2.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> jL;

        private a() {
            this.jL = new ThreadLocal<>();
        }

        private int aZ() {
            Integer num = this.jL.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.jL.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int ba() {
            Integer num = this.jL.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.jL.remove();
            } else {
                this.jL.set(Integer.valueOf(intValue));
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
