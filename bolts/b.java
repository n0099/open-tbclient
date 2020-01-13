package bolts;

import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
final class b {
    private static final b cT = new b();
    private final ExecutorService cU;
    private final ScheduledExecutorService cV;
    private final Executor cW;

    private static boolean aN() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains(PraiseDataPassUtil.KEY_FROM_OS);
    }

    private b() {
        this.cU = !aN() ? Executors.newCachedThreadPool() : bolts.a.aL();
        this.cV = Executors.newSingleThreadScheduledExecutor();
        this.cW = new a();
    }

    public static ExecutorService aO() {
        return cT.cU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor aP() {
        return cT.cW;
    }

    /* loaded from: classes5.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> cX;

        private a() {
            this.cX = new ThreadLocal<>();
        }

        private int aQ() {
            Integer num = this.cX.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.cX.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int aR() {
            Integer num = this.cX.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.cX.remove();
            } else {
                this.cX.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (aQ() <= 15) {
                    runnable.run();
                } else {
                    b.aO().execute(runnable);
                }
            } finally {
                aR();
            }
        }
    }
}
