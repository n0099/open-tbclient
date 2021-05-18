package com.baidu.fsg.face.base.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5694a = "ThreadPoolService";

    /* renamed from: d  reason: collision with root package name */
    public static final int f5695d = 0;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f5696b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f5697c;

    /* renamed from: e  reason: collision with root package name */
    public Handler f5698e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f5700a = new l();
    }

    public static l a() {
        return a.f5700a;
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar) {
        d.a(f5694a, "runInUiThread()", kVar.f5692a);
        this.f5698e.sendMessage(this.f5698e.obtainMessage(0, kVar));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void c(k kVar) {
        d.a(f5694a, "runImport()", kVar.f5692a);
        this.f5696b.submit(kVar);
    }

    public l() {
        this.f5698e = new Handler(Looper.getMainLooper()) { // from class: com.baidu.fsg.face.base.d.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Runnable runnable;
                if (message.what == 0 && (runnable = ((k) message.obj).f5693b) != null) {
                    runnable.run();
                }
            }
        };
        this.f5697c = Executors.newScheduledThreadPool(6);
        this.f5696b = Executors.newScheduledThreadPool(3);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar) {
        this.f5697c.submit(kVar);
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void a(k kVar, long j) {
        d.a(f5694a, "runDelay()", kVar.f5692a, Long.valueOf(j));
        this.f5697c.submit(kVar, Long.valueOf(j));
    }

    public void c(k kVar, long j) {
        d.a(f5694a, "runDelayImport()", kVar.f5692a, Long.valueOf(j));
        this.f5696b.submit(kVar, Long.valueOf(j));
    }

    @Override // com.baidu.fsg.face.base.d.c
    public void b(k kVar, long j) {
        d.a(f5694a, "runInUiThreadDelay()", kVar.f5692a, Long.valueOf(j));
        this.f5698e.sendMessageDelayed(this.f5698e.obtainMessage(0, kVar), j);
    }
}
