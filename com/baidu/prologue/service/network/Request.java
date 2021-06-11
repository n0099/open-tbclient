package com.baidu.prologue.service.network;

import android.content.Context;
import android.os.Handler;
import com.bumptech.glide.request.SingleRequest;
import d.a.d0.a.c.g;
import d.a.d0.d.a.e;
import d.a.d0.d.a.k;
import d.a.d0.d.a.l;
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
    public final URL f9424a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9425b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f9426c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f9427d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f9428e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f9429f;

    /* renamed from: g  reason: collision with root package name */
    public final e f9430g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f9431h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f9432i;
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
        public final /* synthetic */ l f9433e;

        public a(l lVar) {
            this.f9433e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9433e.a(Request.this.f9432i);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f9435a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f9437e;

            public a(String str) {
                this.f9437e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f9435a.b(this.f9437e);
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0120b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f9439e;

            public RunnableC0120b(Throwable th) {
                this.f9439e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f9435a.a(this.f9439e);
            }
        }

        public b(l lVar) {
            this.f9435a = lVar;
        }

        @Override // d.a.d0.d.a.k
        public void a(Throwable th) {
            Request.this.g(new RunnableC0120b(th));
        }

        @Override // d.a.d0.d.a.k
        public void b(long j, InputStream inputStream) {
            Request.this.g(new a(new String(Request.h(inputStream))));
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f9441a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9442b;

        /* renamed from: c  reason: collision with root package name */
        public URL f9443c;

        /* renamed from: d  reason: collision with root package name */
        public String f9444d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f9445e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f9446f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9447g;

        /* renamed from: h  reason: collision with root package name */
        public Object f9448h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f9449i;
        public RequestError j;

        public c(Context context, String str) {
            this.f9441a = context.getApplicationContext();
            this.f9442b = str;
        }

        public c j(String str, String str2) {
            if (this.f9446f == null) {
                this.f9446f = new HashMap();
            }
            this.f9446f.put(str, str2);
            return this;
        }

        public c k(String str, String str2) {
            if (this.f9445e == null) {
                this.f9445e = new HashMap();
            }
            this.f9445e.put(str, str2.trim());
            return this;
        }

        public Request l() {
            if (this.f9444d == null) {
                m();
            }
            if ("GET".equals(this.f9444d)) {
                try {
                    this.f9443c = new URL(d.a.d0.d.a.b.b(this.f9443c.toString(), this.f9446f));
                } catch (MalformedURLException e2) {
                    this.j = new RequestError("Failed to create url", e2);
                } catch (URISyntaxException e3) {
                    this.j = new RequestError("Failed to add parameters to url", e3);
                }
            }
            return new Request(this, null);
        }

        public c m() {
            if (this.f9443c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f9443c = new URL(this.f9442b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f9444d = "GET";
            return this;
        }

        public c n() {
            if (this.f9443c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f9443c = new URL(this.f9442b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f9444d = "POST";
            return this;
        }

        public c o(boolean z) {
            this.f9449i = z;
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
                    g.f43285a.e(SingleRequest.TAG, "failed to read is", e2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.a.d0.a.c.k.a(byteArrayOutputStream);
        }
    }

    public void d(k kVar) {
        this.f9430g.a(this, kVar);
    }

    public void e(l lVar) {
        if (this.f9432i != null) {
            g(new a(lVar));
        } else {
            this.f9430g.a(this, new b(lVar));
        }
    }

    public boolean f() {
        Map<String, String> map = this.f9427d;
        return map != null && map.size() > 0;
    }

    public final void g(Runnable runnable) {
        this.f9431h.post(runnable);
    }

    public Request(c cVar) {
        this.f9432i = cVar.j;
        this.f9429f = cVar.f9441a;
        this.f9431h = new Handler(this.f9429f.getMainLooper());
        this.f9424a = cVar.f9443c;
        this.f9425b = cVar.f9444d;
        this.f9426c = cVar.f9445e;
        this.f9427d = cVar.f9446f;
        boolean unused = cVar.f9447g;
        this.f9428e = cVar.f9448h != null ? cVar.f9448h : this;
        this.f9430g = d.a.d0.d.a.c.c(this.f9429f);
        this.j = cVar.f9449i;
    }
}
