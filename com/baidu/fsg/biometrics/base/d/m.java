package com.baidu.fsg.biometrics.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class m implements b {
    private static final String a = "ThreadPoolService";
    private static final int d = 0;
    private ExecutorService b;
    private ExecutorService c;
    private Handler e;

    /* loaded from: classes2.dex */
    private static class a {
        public static m a = new m();

        private a() {
        }
    }

    public static m a() {
        return a.a;
    }

    private m() {
        this.e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.biometrics.base.d.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        l lVar = (l) message.obj;
                        if (lVar.b != null) {
                            lVar.b.run();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.c = Executors.newScheduledThreadPool(6);
        this.b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.biometrics.base.d.b
    public void a(l lVar) {
        this.c.submit(lVar);
    }

    @Override // com.baidu.fsg.biometrics.base.d.b
    public void a(l lVar, long j) {
        c.a(a, "runDelay()", lVar.a, Long.valueOf(j));
        this.c.submit(lVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.biometrics.base.d.b
    public void b(l lVar) {
        c.a(a, "runInUiThread()", lVar.a);
        this.e.sendMessage(this.e.obtainMessage(0, lVar));
    }

    @Override // com.baidu.fsg.biometrics.base.d.b
    public void b(l lVar, long j) {
        c.a(a, "runInUiThreadDelay()", lVar.a, Long.valueOf(j));
        this.e.sendMessageDelayed(this.e.obtainMessage(0, lVar), j);
    }

    @Override // com.baidu.fsg.biometrics.base.d.b
    public void c(l lVar) {
        c.a(a, "runImport()", lVar.a);
        this.b.submit(lVar);
    }

    public void c(l lVar, long j) {
        c.a(a, "runDelayImport()", lVar.a, Long.valueOf(j));
        this.b.submit(lVar, Long.valueOf(j));
    }
}
