package com.baidu.mobads.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public abstract class a<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static b f8218f;

    /* renamed from: a  reason: collision with root package name */
    public String f8219a = "default";

    /* renamed from: b  reason: collision with root package name */
    public Future<T> f8220b;

    /* renamed from: c  reason: collision with root package name */
    public long f8221c;

    /* renamed from: d  reason: collision with root package name */
    public long f8222d;

    /* renamed from: e  reason: collision with root package name */
    public long f8223e;

    /* renamed from: com.baidu.mobads.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0106a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final a f8224a;

        /* renamed from: b  reason: collision with root package name */
        public final T f8225b;

        public C0106a(a aVar, T t) {
            this.f8224a = aVar;
            this.f8225b = t;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0106a c0106a = (C0106a) message.obj;
            int i = message.what;
            if (i == 1) {
                c0106a.f8224a.a((a) c0106a.f8225b);
            } else if (i == 2) {
                c0106a.f8224a.a((Throwable) c0106a.f8225b);
            } else if (i != 3) {
            } else {
                c0106a.f8224a.c();
            }
        }
    }

    public static Handler d() {
        b bVar;
        synchronized (a.class) {
            if (f8218f == null) {
                f8218f = new b(Looper.getMainLooper());
            }
            bVar = f8218f;
        }
        return bVar;
    }

    public abstract T a();

    public void a(T t) {
    }

    public void a(Throwable th) {
    }

    public void a(Future future) {
        this.f8220b = future;
    }

    public a b() {
        try {
            this.f8222d = System.currentTimeMillis();
            d().obtainMessage(1, new C0106a(this, a())).sendToTarget();
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
        this.f8221c = j;
    }
}
