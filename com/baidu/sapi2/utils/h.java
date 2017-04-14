package com.baidu.sapi2.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class h implements b {
    private static final String a = "ThreadPoolService";
    private static final int d = 0;
    private ExecutorService b;
    private ExecutorService c;
    private Handler e;

    /* loaded from: classes.dex */
    private static class a {
        public static h a = new h();

        private a() {
        }
    }

    public static h a() {
        return a.a;
    }

    private h() {
        this.e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.utils.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        g gVar = (g) message.obj;
                        if (gVar.b != null) {
                            gVar.b.run();
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

    @Override // com.baidu.sapi2.utils.b
    public void a(g gVar) {
        this.c.submit(gVar);
    }

    @Override // com.baidu.sapi2.utils.b
    public void a(g gVar, long j) {
        L.d(a, "runDelay()", gVar.a, Long.valueOf(j));
        this.c.submit(gVar, Long.valueOf(j));
    }

    @Override // com.baidu.sapi2.utils.b
    public void b(g gVar) {
        L.d(a, "runInUiThread()", gVar.a);
        this.e.sendMessage(this.e.obtainMessage(0, gVar));
    }

    @Override // com.baidu.sapi2.utils.b
    public void b(g gVar, long j) {
        L.d(a, "runInUiThreadDelay()", gVar.a, Long.valueOf(j));
        this.e.sendMessageDelayed(this.e.obtainMessage(0, gVar), j);
    }

    @Override // com.baidu.sapi2.utils.b
    public void c(g gVar) {
        L.d(a, "runImport()", gVar.a);
        this.b.submit(gVar);
    }

    public void c(g gVar, long j) {
        L.d(a, "runDelayImport()", gVar.a, Long.valueOf(j));
        this.b.submit(gVar, Long.valueOf(j));
    }
}
