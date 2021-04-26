package cn.com.chinatelecom.gateway.lib.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f1586a = Executors.newFixedThreadPool(3);

    /* loaded from: classes.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1587a = false;

        public void a(boolean z) {
            this.f1587a = z;
        }

        public boolean a() {
            return this.f1587a;
        }
    }

    public static void a(Runnable runnable) {
        f1586a.execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return f1586a.submit(runnable);
    }
}
