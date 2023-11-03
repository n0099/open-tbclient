package com.baidu.android.pushservice.z;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class e {
    public static com.baidu.android.pushservice.z.a a;
    public static e b;
    public static final int c;
    public static final int d;
    public static final int e;

    /* loaded from: classes.dex */
    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            e.this.b();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = Math.max(2, Math.min(availableProcessors - 1, 4));
        e = c << 3;
    }

    public e() {
        Runtime.getRuntime().addShutdownHook(new a());
        com.baidu.android.pushservice.z.a aVar = new com.baidu.android.pushservice.z.a(d, e, 2L, TimeUnit.MINUTES, new b());
        a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static e a() {
        com.baidu.android.pushservice.z.a aVar;
        if (b == null || (aVar = a) == null || aVar.isShutdown() || a.isTerminated()) {
            b = new e();
        }
        return b;
    }

    public boolean a(c cVar) {
        try {
            a.submit(cVar);
            return true;
        } catch (Exception unused) {
            com.baidu.android.pushservice.z.a aVar = a;
            if (aVar == null || aVar.getCorePoolSize() == 0 || a.getPoolSize() == 0) {
                a = new com.baidu.android.pushservice.z.a(d, e, 2L, TimeUnit.MINUTES, new b());
                return false;
            }
            return false;
        }
    }

    public void b() {
        com.baidu.android.pushservice.z.a aVar = a;
        if (aVar != null) {
            try {
                aVar.getQueue().clear();
                a.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}
