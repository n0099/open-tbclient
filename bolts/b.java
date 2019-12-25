package bolts;

import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes4.dex */
final class b {
    private static final b cU = new b();
    private final ExecutorService cV;
    private final ScheduledExecutorService cW;
    private final Executor cX;

    private static boolean aN() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains(PraiseDataPassUtil.KEY_FROM_OS);
    }

    private b() {
        this.cV = !aN() ? Executors.newCachedThreadPool() : bolts.a.aL();
        this.cW = Executors.newSingleThreadScheduledExecutor();
        this.cX = new a();
    }

    public static ExecutorService aO() {
        return cU.cV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor aP() {
        return cU.cX;
    }

    /* loaded from: classes4.dex */
    private static class a implements Executor {
        private ThreadLocal<Integer> cY;

        private a() {
            this.cY = new ThreadLocal<>();
        }

        private int aQ() {
            Integer num = this.cY.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.cY.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int aR() {
            Integer num = this.cY.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.cY.remove();
            } else {
                this.cY.set(Integer.valueOf(intValue));
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
