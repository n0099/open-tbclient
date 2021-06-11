package cn.com.chinatelecom.gateway.lib.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f1599a = Executors.newFixedThreadPool(3);

    /* loaded from: classes.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1600a = false;

        public void a(boolean z) {
            this.f1600a = z;
        }

        public boolean a() {
            return this.f1600a;
        }
    }

    public static void a(Runnable runnable) {
        f1599a.execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return f1599a.submit(runnable);
    }
}
