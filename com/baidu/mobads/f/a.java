package com.baidu.mobads.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public abstract class a<T> implements Runnable {
    private static b f;

    /* renamed from: a  reason: collision with root package name */
    private String f3320a = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;

    /* renamed from: b  reason: collision with root package name */
    protected Future<T> f3321b;
    private long c;
    private long d;
    private long e;

    protected abstract T a();

    @Override // java.lang.Runnable
    public void run() {
        b();
    }

    public void a(Future future) {
        this.f3321b = future;
    }

    public void a(long j) {
        this.c = j;
    }

    public a b() {
        try {
            this.d = System.currentTimeMillis();
            d().obtainMessage(1, new C0263a(this, a())).sendToTarget();
        } catch (Throwable th) {
            try {
                d().obtainMessage(2, new C0263a(this, th)).sendToTarget();
            } finally {
                this.e = System.currentTimeMillis();
            }
        }
        return this;
    }

    private static Handler d() {
        b bVar;
        synchronized (a.class) {
            if (f == null) {
                f = new b(Looper.getMainLooper());
            }
            bVar = f;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0263a c0263a = (C0263a) message.obj;
            switch (message.what) {
                case 1:
                    c0263a.f3322a.a((a) c0263a.f3323b);
                    return;
                case 2:
                    c0263a.f3322a.a((Throwable) c0263a.f3323b);
                    return;
                case 3:
                    c0263a.f3322a.c();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mobads.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0263a<T> {

        /* renamed from: a  reason: collision with root package name */
        final a f3322a;

        /* renamed from: b  reason: collision with root package name */
        final T f3323b;

        C0263a(a aVar, T t) {
            this.f3322a = aVar;
            this.f3323b = t;
        }
    }

    protected void a(T t) {
    }

    protected void a(Throwable th) {
    }

    protected void c() {
    }
}
