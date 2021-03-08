package cn.com.chinatelecom.account.api.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f1042a = Executors.newFixedThreadPool(3);

    /* loaded from: classes4.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1043a = false;

        public void a(boolean z) {
            this.f1043a = z;
        }

        public boolean a() {
            return this.f1043a;
        }
    }

    public static void a(Runnable runnable) {
        f1042a.execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return f1042a.submit(runnable);
    }
}
