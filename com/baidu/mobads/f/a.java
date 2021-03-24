package com.baidu.mobads.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class a<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static b f8217f;

    /* renamed from: a  reason: collision with root package name */
    public String f8218a = "default";

    /* renamed from: b  reason: collision with root package name */
    public Future<T> f8219b;

    /* renamed from: c  reason: collision with root package name */
    public long f8220c;

    /* renamed from: d  reason: collision with root package name */
    public long f8221d;

    /* renamed from: e  reason: collision with root package name */
    public long f8222e;

    /* renamed from: com.baidu.mobads.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0105a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final a f8223a;

        /* renamed from: b  reason: collision with root package name */
        public final T f8224b;

        public C0105a(a aVar, T t) {
            this.f8223a = aVar;
            this.f8224b = t;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0105a c0105a = (C0105a) message.obj;
            int i = message.what;
            if (i == 1) {
                c0105a.f8223a.a((a) c0105a.f8224b);
            } else if (i == 2) {
                c0105a.f8223a.a((Throwable) c0105a.f8224b);
            } else if (i != 3) {
            } else {
                c0105a.f8223a.c();
            }
        }
    }

    public static Handler d() {
        b bVar;
        synchronized (a.class) {
            if (f8217f == null) {
                f8217f = new b(Looper.getMainLooper());
            }
            bVar = f8217f;
        }
        return bVar;
    }

    public abstract T a();

    public void a(T t) {
    }

    public void a(Throwable th) {
    }

    public void a(Future future) {
        this.f8219b = future;
    }

    public a b() {
        try {
            this.f8221d = System.currentTimeMillis();
            d().obtainMessage(1, new C0105a(this, a())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    public void c() {
    }

    @Override // java.lang.Runnable
    public void run() {
        b();
    }

    public void a(long j) {
        this.f8220c = j;
    }
}
