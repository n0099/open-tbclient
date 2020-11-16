package cn.com.chinatelecom.account.api.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes16.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f982a = Executors.newFixedThreadPool(3);

    /* loaded from: classes16.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f983a = false;

        public void a(boolean z) {
            this.f983a = z;
        }

        public boolean a() {
            return this.f983a;
        }
    }

    public static void a(Runnable runnable) {
        f982a.execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return f982a.submit(runnable);
    }
}
