package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5637a = "ThreadPoolService";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5638d = 0;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f5639b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f5640c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f5641e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f5643a = new l();
    }

    public static l a() {
        return a.f5643a;
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        d.a(f5637a, "runInUiThread()", kVar.f5635a);
        this.f5641e.sendMessage(this.f5641e.obtainMessage(0, kVar));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        d.a(f5637a, "runImport()", kVar.f5635a);
        this.f5639b.submit(kVar);
    }

    public l() {
        this.f5641e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Runnable runnable;
                if (message.what == 0 && (runnable = ((k) message.obj).f5636b) != null) {
                    runnable.run();
                }
            }
        };
        this.f5640c = Executors.newScheduledThreadPool(6);
        this.f5639b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        this.f5640c.submit(kVar);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j) {
        d.a(f5637a, "runDelay()", kVar.f5635a, Long.valueOf(j));
        this.f5640c.submit(kVar, Long.valueOf(j));
    }

    public void c(k kVar, long j) {
        d.a(f5637a, "runDelayImport()", kVar.f5635a, Long.valueOf(j));
        this.f5639b.submit(kVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j) {
        d.a(f5637a, "runInUiThreadDelay()", kVar.f5635a, Long.valueOf(j));
        this.f5641e.sendMessageDelayed(this.f5641e.obtainMessage(0, kVar), j);
    }
}
