package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5685a = "ThreadPoolService";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5686d = 0;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f5687b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f5688c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f5689e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f5691a = new l();
    }

    public static l a() {
        return a.f5691a;
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        d.a(f5685a, "runInUiThread()", kVar.f5683a);
        this.f5689e.sendMessage(this.f5689e.obtainMessage(0, kVar));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        d.a(f5685a, "runImport()", kVar.f5683a);
        this.f5687b.submit(kVar);
    }

    public l() {
        this.f5689e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Runnable runnable;
                if (message.what == 0 && (runnable = ((k) message.obj).f5684b) != null) {
                    runnable.run();
                }
            }
        };
        this.f5688c = Executors.newScheduledThreadPool(6);
        this.f5687b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        this.f5688c.submit(kVar);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j) {
        d.a(f5685a, "runDelay()", kVar.f5683a, Long.valueOf(j));
        this.f5688c.submit(kVar, Long.valueOf(j));
    }

    public void c(k kVar, long j) {
        d.a(f5685a, "runDelayImport()", kVar.f5683a, Long.valueOf(j));
        this.f5687b.submit(kVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j) {
        d.a(f5685a, "runInUiThreadDelay()", kVar.f5683a, Long.valueOf(j));
        this.f5689e.sendMessageDelayed(this.f5689e.obtainMessage(0, kVar), j);
    }
}
