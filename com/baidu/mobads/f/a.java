package com.baidu.mobads.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public abstract class a<T> implements Runnable {
    private static b f;

    /* renamed from: a  reason: collision with root package name */
    private String f2376a = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    protected Future<T> b;
    private long c;
    private long d;
    private long e;

    protected abstract T a();

    @Override // java.lang.Runnable
    public void run() {
        b();
    }

    public void a(Future future) {
        this.b = future;
    }

    public void a(long j) {
        this.c = j;
    }

    public a b() {
        try {
            this.d = System.currentTimeMillis();
            d().obtainMessage(1, new C0269a(this, a())).sendToTarget();
        } catch (Throwable th) {
            try {
                d().obtainMessage(2, new C0269a(this, th)).sendToTarget();
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
    /* loaded from: classes4.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0269a c0269a = (C0269a) message.obj;
            switch (message.what) {
                case 1:
                    c0269a.f2377a.a((a) c0269a.b);
                    return;
                case 2:
                    c0269a.f2377a.a((Throwable) c0269a.b);
                    return;
                case 3:
                    c0269a.f2377a.c();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mobads.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0269a<T> {

        /* renamed from: a  reason: collision with root package name */
        final a f2377a;
        final T b;

        C0269a(a aVar, T t) {
            this.f2377a = aVar;
            this.b = t;
        }
    }

    protected void a(T t) {
    }

    protected void a(Throwable th) {
    }

    protected void c() {
    }
}
