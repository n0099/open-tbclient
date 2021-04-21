package com.baidu.prologue.service.network;

import android.content.Context;
import android.os.Handler;
import com.bumptech.glide.request.SingleRequest;
import d.b.b0.a.c.g;
import d.b.b0.d.a.e;
import d.b.b0.d.a.k;
import d.b.b0.d.a.l;
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
    public final URL f10055a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10056b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f10057c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f10058d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f10059e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f10060f;

    /* renamed from: g  reason: collision with root package name */
    public final e f10061g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f10062h;
    public final RequestError i;
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
        public final /* synthetic */ l f10063e;

        public a(l lVar) {
            this.f10063e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10063e.a(Request.this.i);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f10065a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f10067e;

            public a(String str) {
                this.f10067e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f10065a.b(this.f10067e);
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0134b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f10069e;

            public RunnableC0134b(Throwable th) {
                this.f10069e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f10065a.a(this.f10069e);
            }
        }

        public b(l lVar) {
            this.f10065a = lVar;
        }

        @Override // d.b.b0.d.a.k
        public void a(Throwable th) {
            Request.this.g(new RunnableC0134b(th));
        }

        @Override // d.b.b0.d.a.k
        public void b(long j, InputStream inputStream) {
            Request.this.g(new a(new String(Request.h(inputStream))));
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f10071a;

        /* renamed from: b  reason: collision with root package name */
        public final String f10072b;

        /* renamed from: c  reason: collision with root package name */
        public URL f10073c;

        /* renamed from: d  reason: collision with root package name */
        public String f10074d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f10075e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f10076f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f10077g;

        /* renamed from: h  reason: collision with root package name */
        public Object f10078h;
        public boolean i;
        public RequestError j;

        public c(Context context, String str) {
            this.f10071a = context.getApplicationContext();
            this.f10072b = str;
        }

        public c j(String str, String str2) {
            if (this.f10076f == null) {
                this.f10076f = new HashMap();
            }
            this.f10076f.put(str, str2);
            return this;
        }

        public c k(String str, String str2) {
            if (this.f10075e == null) {
                this.f10075e = new HashMap();
            }
            this.f10075e.put(str, str2.trim());
            return this;
        }

        public Request l() {
            if (this.f10074d == null) {
                m();
            }
            if ("GET".equals(this.f10074d)) {
                try {
                    this.f10073c = new URL(d.b.b0.d.a.b.b(this.f10073c.toString(), this.f10076f));
                } catch (MalformedURLException e2) {
                    this.j = new RequestError("Failed to create url", e2);
                } catch (URISyntaxException e3) {
                    this.j = new RequestError("Failed to add parameters to url", e3);
                }
            }
            return new Request(this, null);
        }

        public c m() {
            if (this.f10073c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f10073c = new URL(this.f10072b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f10074d = "GET";
            return this;
        }

        public c n() {
            if (this.f10073c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f10073c = new URL(this.f10072b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f10074d = "POST";
            return this;
        }

        public c o(boolean z) {
            this.i = z;
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
                    g.f42120a.e(SingleRequest.TAG, "failed to read is", e2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.b.b0.a.c.k.a(byteArrayOutputStream);
        }
    }

    public void d(k kVar) {
        this.f10061g.a(this, kVar);
    }

    public void e(l lVar) {
        if (this.i != null) {
            g(new a(lVar));
        } else {
            this.f10061g.a(this, new b(lVar));
        }
    }

    public boolean f() {
        Map<String, String> map = this.f10058d;
        return map != null && map.size() > 0;
    }

    public final void g(Runnable runnable) {
        this.f10062h.post(runnable);
    }

    public Request(c cVar) {
        this.i = cVar.j;
        this.f10060f = cVar.f10071a;
        this.f10062h = new Handler(this.f10060f.getMainLooper());
        this.f10055a = cVar.f10073c;
        this.f10056b = cVar.f10074d;
        this.f10057c = cVar.f10075e;
        this.f10058d = cVar.f10076f;
        boolean unused = cVar.f10077g;
        this.f10059e = cVar.f10078h != null ? cVar.f10078h : this;
        this.f10061g = d.b.b0.d.a.c.c(this.f10060f);
        this.j = cVar.i;
    }
}
