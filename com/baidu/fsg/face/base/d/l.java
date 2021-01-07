package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2157a = "ThreadPoolService";
    private static final int d = 0;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f2158b;
    private ExecutorService c;
    private Handler e;

    /* loaded from: classes6.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f2160a = new l();

        private a() {
        }
    }

    public static l a() {
        return a.f2160a;
    }

    private l() {
        this.e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        k kVar = (k) message.obj;
                        if (kVar.f2156b != null) {
                            kVar.f2156b.run();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.c = Executors.newScheduledThreadPool(6);
        this.f2158b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        this.c.submit(kVar);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j) {
        d.a(f2157a, "runDelay()", kVar.f2155a, Long.valueOf(j));
        this.c.submit(kVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        d.a(f2157a, "runInUiThread()", kVar.f2155a);
        this.e.sendMessage(this.e.obtainMessage(0, kVar));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j) {
        d.a(f2157a, "runInUiThreadDelay()", kVar.f2155a, Long.valueOf(j));
        this.e.sendMessageDelayed(this.e.obtainMessage(0, kVar), j);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        d.a(f2157a, "runImport()", kVar.f2155a);
        this.f2158b.submit(kVar);
    }

    public void c(k kVar, long j) {
        d.a(f2157a, "runDelayImport()", kVar.f2155a, Long.valueOf(j));
        this.f2158b.submit(kVar, Long.valueOf(j));
    }
}
