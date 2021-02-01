package bolts;

import com.baidu.ar.constants.HttpConstants;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
final class b {
    private static final b zC = new b();
    private final ExecutorService zD;
    private final ScheduledExecutorService zE;
    private final Executor zF;

    private static boolean ht() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains(HttpConstants.OS_TYPE_VALUE);
    }

    private b() {
        this.zD = !ht() ? Executors.newCachedThreadPool() : bolts.a.hr();
        this.zE = Executors.newSingleThreadScheduledExecutor();
        this.zF = new a();
    }

    public static ExecutorService hu() {
        return zC.zD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor hv() {
        return zC.zF;
    }

    /* loaded from: classes6.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> zG;

        private a() {
            this.zG = new ThreadLocal<>();
        }

        private int hw() {
            Integer num = this.zG.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.zG.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int hx() {
            Integer num = this.zG.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zG.remove();
            } else {
                this.zG.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (hw() <= 15) {
                    runnable.run();
                } else {
                    b.hu().execute(runnable);
                }
            } finally {
                hx();
            }
        }
    }
}
