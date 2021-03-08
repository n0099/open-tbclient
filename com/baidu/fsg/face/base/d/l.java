package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1633a = "ThreadPoolService";
    private static final int d = 0;
    private ExecutorService b;
    private ExecutorService c;
    private Handler e;

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f1635a = new l();

        private a() {
        }
    }

    public static l a() {
        return a.f1635a;
    }

    private l() {
        this.e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        k kVar = (k) message.obj;
                        if (kVar.b != null) {
                            kVar.b.run();
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

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        this.c.submit(kVar);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j) {
        d.a(f1633a, "runDelay()", kVar.f1632a, Long.valueOf(j));
        this.c.submit(kVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        d.a(f1633a, "runInUiThread()", kVar.f1632a);
        this.e.sendMessage(this.e.obtainMessage(0, kVar));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j) {
        d.a(f1633a, "runInUiThreadDelay()", kVar.f1632a, Long.valueOf(j));
        this.e.sendMessageDelayed(this.e.obtainMessage(0, kVar), j);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        d.a(f1633a, "runImport()", kVar.f1632a);
        this.b.submit(kVar);
    }

    public void c(k kVar, long j) {
        d.a(f1633a, "runDelayImport()", kVar.f1632a, Long.valueOf(j));
        this.b.submit(kVar, Long.valueOf(j));
    }
}
