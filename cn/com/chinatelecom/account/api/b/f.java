package cn.com.chinatelecom.account.api.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes16.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f980a = Executors.newFixedThreadPool(3);

    /* loaded from: classes16.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f981a = false;

        public void a(boolean z) {
            this.f981a = z;
        }

        public boolean a() {
            return this.f981a;
        }
    }

    public static void a(Runnable runnable) {
        f980a.execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return f980a.submit(runnable);
    }
}
