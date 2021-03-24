package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5649a = "ThreadPoolService";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5650d = 0;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f5651b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f5652c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f5653e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f5655a = new l();
    }

    public static l a() {
        return a.f5655a;
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        d.a(f5649a, "runInUiThread()", kVar.f5647a);
        this.f5653e.sendMessage(this.f5653e.obtainMessage(0, kVar));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        d.a(f5649a, "runImport()", kVar.f5647a);
        this.f5651b.submit(kVar);
    }

    public l() {
        this.f5653e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Runnable runnable;
                if (message.what == 0 && (runnable = ((k) message.obj).f5648b) != null) {
                    runnable.run();
                }
            }
        };
        this.f5652c = Executors.newScheduledThreadPool(6);
        this.f5651b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        this.f5652c.submit(kVar);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j) {
        d.a(f5649a, "runDelay()", kVar.f5647a, Long.valueOf(j));
        this.f5652c.submit(kVar, Long.valueOf(j));
    }

    public void c(k kVar, long j) {
        d.a(f5649a, "runDelayImport()", kVar.f5647a, Long.valueOf(j));
        this.f5651b.submit(kVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j) {
        d.a(f5649a, "runInUiThreadDelay()", kVar.f5647a, Long.valueOf(j));
        this.f5653e.sendMessageDelayed(this.f5653e.obtainMessage(0, kVar), j);
    }
}
