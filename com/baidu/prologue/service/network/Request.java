package com.baidu.prologue.service.network;

import android.content.Context;
import android.os.Handler;
import com.bumptech.glide.request.SingleRequest;
import d.a.b0.a.c.g;
import d.a.b0.d.a.e;
import d.a.b0.d.a.k;
import d.a.b0.d.a.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class Request {

    /* renamed from: a  reason: collision with root package name */
    public final URL f10430a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10431b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f10432c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f10433d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f10434e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f10435f;

    /* renamed from: g  reason: collision with root package name */
    public final e f10436g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f10437h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f10438i;
    public boolean j;

    /* loaded from: classes2.dex */
    public static class RequestError extends IOException {
        public RequestError(String str) {
            super(str);
        }

        public RequestError(String str, Throwable th) {
            super(str, th);
        }

        public RequestError(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f10439e;

        public a(l lVar) {
            this.f10439e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10439e.a(Request.this.f10438i);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f10441a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f10443e;

            public a(String str) {
                this.f10443e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f10441a.b(this.f10443e);
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0134b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f10445e;

            public RunnableC0134b(Throwable th) {
                this.f10445e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f10441a.a(this.f10445e);
            }
        }

        public b(l lVar) {
            this.f10441a = lVar;
        }

        @Override // d.a.b0.d.a.k
        public void a(Throwable th) {
            Request.this.g(new RunnableC0134b(th));
        }

        @Override // d.a.b0.d.a.k
        public void b(long j, InputStream inputStream) {
            Request.this.g(new a(new String(Request.h(inputStream))));
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f10447a;

        /* renamed from: b  reason: collision with root package name */
        public final String f10448b;

        /* renamed from: c  reason: collision with root package name */
        public URL f10449c;

        /* renamed from: d  reason: collision with root package name */
        public String f10450d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f10451e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f10452f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f10453g;

        /* renamed from: h  reason: collision with root package name */
        public Object f10454h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10455i;
        public RequestError j;

        public c(Context context, String str) {
            this.f10447a = context.getApplicationContext();
            this.f10448b = str;
        }

        public c j(String str, String str2) {
            if (this.f10452f == null) {
                this.f10452f = new HashMap();
            }
            this.f10452f.put(str, str2);
            return this;
        }

        public c k(String str, String str2) {
            if (this.f10451e == null) {
                this.f10451e = new HashMap();
            }
            this.f10451e.put(str, str2.trim());
            return this;
        }

        public Request l() {
            if (this.f10450d == null) {
                m();
            }
            if ("GET".equals(this.f10450d)) {
                try {
                    this.f10449c = new URL(d.a.b0.d.a.b.b(this.f10449c.toString(), this.f10452f));
                } catch (MalformedURLException e2) {
                    this.j = new RequestError("Failed to create url", e2);
                } catch (URISyntaxException e3) {
                    this.j = new RequestError("Failed to add parameters to url", e3);
                }
            }
            return new Request(this, null);
        }

        public c m() {
            if (this.f10449c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f10449c = new URL(this.f10448b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f10450d = "GET";
            return this;
        }

        public c n() {
            if (this.f10449c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f10449c = new URL(this.f10448b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f10450d = "POST";
            return this;
        }

        public c o(boolean z) {
            this.f10455i = z;
            return this;
        }
    }

    public /* synthetic */ Request(c cVar, a aVar) {
        this(cVar);
    }

    public static byte[] h(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e2) {
                    g.f39302a.e(SingleRequest.TAG, "failed to read is", e2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.a.b0.a.c.k.a(byteArrayOutputStream);
        }
    }

    public void d(k kVar) {
        this.f10436g.a(this, kVar);
    }

    public void e(l lVar) {
        if (this.f10438i != null) {
            g(new a(lVar));
        } else {
            this.f10436g.a(this, new b(lVar));
        }
    }

    public boolean f() {
        Map<String, String> map = this.f10433d;
        return map != null && map.size() > 0;
    }

    public final void g(Runnable runnable) {
        this.f10437h.post(runnable);
    }

    public Request(c cVar) {
        this.f10438i = cVar.j;
        this.f10435f = cVar.f10447a;
        this.f10437h = new Handler(this.f10435f.getMainLooper());
        this.f10430a = cVar.f10449c;
        this.f10431b = cVar.f10450d;
        this.f10432c = cVar.f10451e;
        this.f10433d = cVar.f10452f;
        boolean unused = cVar.f10453g;
        this.f10434e = cVar.f10454h != null ? cVar.f10454h : this;
        this.f10436g = d.a.b0.d.a.c.c(this.f10435f);
        this.j = cVar.f10455i;
    }
}
