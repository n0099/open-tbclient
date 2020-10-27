package cn.com.chinatelecom.account.api.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f977a = Executors.newFixedThreadPool(3);

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f978a = false;

        public void a(boolean z) {
            this.f978a = z;
        }

        public boolean a() {
            return this.f978a;
        }
    }

    public static void a(Runnable runnable) {
        f977a.execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return f977a.submit(runnable);
    }
}
