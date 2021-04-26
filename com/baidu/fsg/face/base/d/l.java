package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5840a = "ThreadPoolService";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5841d = 0;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f5842b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f5843c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f5844e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f5846a = new l();
    }

    public static l a() {
        return a.f5846a;
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        d.a(f5840a, "runInUiThread()", kVar.f5838a);
        this.f5844e.sendMessage(this.f5844e.obtainMessage(0, kVar));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        d.a(f5840a, "runImport()", kVar.f5838a);
        this.f5842b.submit(kVar);
    }

    public l() {
        this.f5844e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Runnable runnable;
                if (message.what == 0 && (runnable = ((k) message.obj).f5839b) != null) {
                    runnable.run();
                }
            }
        };
        this.f5843c = Executors.newScheduledThreadPool(6);
        this.f5842b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        this.f5843c.submit(kVar);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j) {
        d.a(f5840a, "runDelay()", kVar.f5838a, Long.valueOf(j));
        this.f5843c.submit(kVar, Long.valueOf(j));
    }

    public void c(k kVar, long j) {
        d.a(f5840a, "runDelayImport()", kVar.f5838a, Long.valueOf(j));
        this.f5842b.submit(kVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j) {
        d.a(f5840a, "runInUiThreadDelay()", kVar.f5838a, Long.valueOf(j));
        this.f5844e.sendMessageDelayed(this.f5844e.obtainMessage(0, kVar), j);
    }
}
