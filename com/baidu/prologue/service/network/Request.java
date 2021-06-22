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
    public final URL f9432a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9433b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f9434c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f9435d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f9436e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f9437f;

    /* renamed from: g  reason: collision with root package name */
    public final e f9438g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f9439h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f9440i;
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
        public final /* synthetic */ l f9441e;

        public a(l lVar) {
            this.f9441e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9441e.a(Request.this.f9440i);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f9443a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f9445e;

            public a(String str) {
                this.f9445e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f9443a.b(this.f9445e);
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0121b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f9447e;

            public RunnableC0121b(Throwable th) {
                this.f9447e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f9443a.a(this.f9447e);
            }
        }

        public b(l lVar) {
            this.f9443a = lVar;
        }

        @Override // d.a.d0.d.a.k
        public void a(Throwable th) {
            Request.this.g(new RunnableC0121b(th));
        }

        @Override // d.a.d0.d.a.k
        public void b(long j, InputStream inputStream) {
            Request.this.g(new a(new String(Request.h(inputStream))));
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f9449a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9450b;

        /* renamed from: c  reason: collision with root package name */
        public URL f9451c;

        /* renamed from: d  reason: collision with root package name */
        public String f9452d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f9453e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f9454f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9455g;

        /* renamed from: h  reason: collision with root package name */
        public Object f9456h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f9457i;
        public RequestError j;

        public c(Context context, String str) {
            this.f9449a = context.getApplicationContext();
            this.f9450b = str;
        }

        public c j(String str, String str2) {
            if (this.f9454f == null) {
                this.f9454f = new HashMap();
            }
            this.f9454f.put(str, str2);
            return this;
        }

        public c k(String str, String str2) {
            if (this.f9453e == null) {
                this.f9453e = new HashMap();
            }
            this.f9453e.put(str, str2.trim());
            return this;
        }

        public Request l() {
            if (this.f9452d == null) {
                m();
            }
            if ("GET".equals(this.f9452d)) {
                try {
                    this.f9451c = new URL(d.a.d0.d.a.b.b(this.f9451c.toString(), this.f9454f));
                } catch (MalformedURLException e2) {
                    this.j = new RequestError("Failed to create url", e2);
                } catch (URISyntaxException e3) {
                    this.j = new RequestError("Failed to add parameters to url", e3);
                }
            }
            return new Request(this, null);
        }

        public c m() {
            if (this.f9451c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f9451c = new URL(this.f9450b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f9452d = "GET";
            return this;
        }

        public c n() {
            if (this.f9451c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f9451c = new URL(this.f9450b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f9452d = "POST";
            return this;
        }

        public c o(boolean z) {
            this.f9457i = z;
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
                    g.f43388a.e(SingleRequest.TAG, "failed to read is", e2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.a.d0.a.c.k.a(byteArrayOutputStream);
        }
    }

    public void d(k kVar) {
        this.f9438g.a(this, kVar);
    }

    public void e(l lVar) {
        if (this.f9440i != null) {
            g(new a(lVar));
        } else {
            this.f9438g.a(this, new b(lVar));
        }
    }

    public boolean f() {
        Map<String, String> map = this.f9435d;
        return map != null && map.size() > 0;
    }

    public final void g(Runnable runnable) {
        this.f9439h.post(runnable);
    }

    public Request(c cVar) {
        this.f9440i = cVar.j;
        this.f9437f = cVar.f9449a;
        this.f9439h = new Handler(this.f9437f.getMainLooper());
        this.f9432a = cVar.f9451c;
        this.f9433b = cVar.f9452d;
        this.f9434c = cVar.f9453e;
        this.f9435d = cVar.f9454f;
        boolean unused = cVar.f9455g;
        this.f9436e = cVar.f9456h != null ? cVar.f9456h : this;
        this.f9438g = d.a.d0.d.a.c.c(this.f9437f);
        this.j = cVar.f9457i;
    }
}
