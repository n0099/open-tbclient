package cn.com.chinatelecom.account.api.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f979a = Executors.newFixedThreadPool(3);

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f980a = false;

        public void a(boolean z) {
            this.f980a = z;
        }

        public boolean a() {
            return this.f980a;
        }
    }

    public static void a(Runnable runnable) {
        f979a.execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return f979a.submit(runnable);
    }
}
