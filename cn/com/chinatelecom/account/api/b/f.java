package cn.com.chinatelecom.account.api.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class f {
    private static ExecutorService a = Executors.newFixedThreadPool(3);

    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable {
        private boolean a = false;

        public void a(boolean z) {
            this.a = z;
        }

        public boolean a() {
            return this.a;
        }
    }

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return a.submit(runnable);
    }
}
