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
    public final URL f9467a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9468b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f9469c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f9470d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f9471e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f9472f;

    /* renamed from: g  reason: collision with root package name */
    public final e f9473g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f9474h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f9475i;
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
        public final /* synthetic */ l f9476e;

        public a(l lVar) {
            this.f9476e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9476e.a(Request.this.f9475i);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f9478a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f9480e;

            public a(String str) {
                this.f9480e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f9478a.b(this.f9480e);
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0119b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f9482e;

            public RunnableC0119b(Throwable th) {
                this.f9482e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f9478a.a(this.f9482e);
            }
        }

        public b(l lVar) {
            this.f9478a = lVar;
        }

        @Override // d.a.b0.d.a.k
        public void a(Throwable th) {
            Request.this.g(new RunnableC0119b(th));
        }

        @Override // d.a.b0.d.a.k
        public void b(long j, InputStream inputStream) {
            Request.this.g(new a(new String(Request.h(inputStream))));
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f9484a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9485b;

        /* renamed from: c  reason: collision with root package name */
        public URL f9486c;

        /* renamed from: d  reason: collision with root package name */
        public String f9487d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f9488e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f9489f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9490g;

        /* renamed from: h  reason: collision with root package name */
        public Object f9491h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f9492i;
        public RequestError j;

        public c(Context context, String str) {
            this.f9484a = context.getApplicationContext();
            this.f9485b = str;
        }

        public c j(String str, String str2) {
            if (this.f9489f == null) {
                this.f9489f = new HashMap();
            }
            this.f9489f.put(str, str2);
            return this;
        }

        public c k(String str, String str2) {
            if (this.f9488e == null) {
                this.f9488e = new HashMap();
            }
            this.f9488e.put(str, str2.trim());
            return this;
        }

        public Request l() {
            if (this.f9487d == null) {
                m();
            }
            if ("GET".equals(this.f9487d)) {
                try {
                    this.f9486c = new URL(d.a.b0.d.a.b.b(this.f9486c.toString(), this.f9489f));
                } catch (MalformedURLException e2) {
                    this.j = new RequestError("Failed to create url", e2);
                } catch (URISyntaxException e3) {
                    this.j = new RequestError("Failed to add parameters to url", e3);
                }
            }
            return new Request(this, null);
        }

        public c m() {
            if (this.f9486c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f9486c = new URL(this.f9485b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f9487d = "GET";
            return this;
        }

        public c n() {
            if (this.f9486c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f9486c = new URL(this.f9485b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f9487d = "POST";
            return this;
        }

        public c o(boolean z) {
            this.f9492i = z;
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
                    g.f38547a.e(SingleRequest.TAG, "failed to read is", e2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.a.b0.a.c.k.a(byteArrayOutputStream);
        }
    }

    public void d(k kVar) {
        this.f9473g.a(this, kVar);
    }

    public void e(l lVar) {
        if (this.f9475i != null) {
            g(new a(lVar));
        } else {
            this.f9473g.a(this, new b(lVar));
        }
    }

    public boolean f() {
        Map<String, String> map = this.f9470d;
        return map != null && map.size() > 0;
    }

    public final void g(Runnable runnable) {
        this.f9474h.post(runnable);
    }

    public Request(c cVar) {
        this.f9475i = cVar.j;
        this.f9472f = cVar.f9484a;
        this.f9474h = new Handler(this.f9472f.getMainLooper());
        this.f9467a = cVar.f9486c;
        this.f9468b = cVar.f9487d;
        this.f9469c = cVar.f9488e;
        this.f9470d = cVar.f9489f;
        boolean unused = cVar.f9490g;
        this.f9471e = cVar.f9491h != null ? cVar.f9491h : this;
        this.f9473g = d.a.b0.d.a.c.c(this.f9472f);
        this.j = cVar.f9492i;
    }
}
