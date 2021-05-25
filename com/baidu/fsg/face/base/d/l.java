package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5594a = "ThreadPoolService";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5595d = 0;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f5596b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f5597c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f5598e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f5600a = new l();
    }

    public static l a() {
        return a.f5600a;
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        d.a(f5594a, "runInUiThread()", kVar.f5592a);
        this.f5598e.sendMessage(this.f5598e.obtainMessage(0, kVar));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        d.a(f5594a, "runImport()", kVar.f5592a);
        this.f5596b.submit(kVar);
    }

    public l() {
        this.f5598e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Runnable runnable;
                if (message.what == 0 && (runnable = ((k) message.obj).f5593b) != null) {
                    runnable.run();
                }
            }
        };
        this.f5597c = Executors.newScheduledThreadPool(6);
        this.f5596b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        this.f5597c.submit(kVar);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j) {
        d.a(f5594a, "runDelay()", kVar.f5592a, Long.valueOf(j));
        this.f5597c.submit(kVar, Long.valueOf(j));
    }

    public void c(k kVar, long j) {
        d.a(f5594a, "runDelayImport()", kVar.f5592a, Long.valueOf(j));
        this.f5596b.submit(kVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j) {
        d.a(f5594a, "runInUiThreadDelay()", kVar.f5592a, Long.valueOf(j));
        this.f5598e.sendMessageDelayed(this.f5598e.obtainMessage(0, kVar), j);
    }
}
