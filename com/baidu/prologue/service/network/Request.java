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
    public final URL f9367a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9368b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f9369c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f9370d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f9371e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f9372f;

    /* renamed from: g  reason: collision with root package name */
    public final e f9373g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f9374h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestError f9375i;
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
        public final /* synthetic */ l f9376e;

        public a(l lVar) {
            this.f9376e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9376e.a(Request.this.f9375i);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f9378a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f9380e;

            public a(String str) {
                this.f9380e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f9378a.b(this.f9380e);
            }
        }

        /* renamed from: com.baidu.prologue.service.network.Request$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0120b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f9382e;

            public RunnableC0120b(Throwable th) {
                this.f9382e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f9378a.a(this.f9382e);
            }
        }

        public b(l lVar) {
            this.f9378a = lVar;
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
        public final Context f9384a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9385b;

        /* renamed from: c  reason: collision with root package name */
        public URL f9386c;

        /* renamed from: d  reason: collision with root package name */
        public String f9387d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f9388e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f9389f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9390g;

        /* renamed from: h  reason: collision with root package name */
        public Object f9391h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f9392i;
        public RequestError j;

        public c(Context context, String str) {
            this.f9384a = context.getApplicationContext();
            this.f9385b = str;
        }

        public c j(String str, String str2) {
            if (this.f9389f == null) {
                this.f9389f = new HashMap();
            }
            this.f9389f.put(str, str2);
            return this;
        }

        public c k(String str, String str2) {
            if (this.f9388e == null) {
                this.f9388e = new HashMap();
            }
            this.f9388e.put(str, str2.trim());
            return this;
        }

        public Request l() {
            if (this.f9387d == null) {
                m();
            }
            if ("GET".equals(this.f9387d)) {
                try {
                    this.f9386c = new URL(d.a.d0.d.a.b.b(this.f9386c.toString(), this.f9389f));
                } catch (MalformedURLException e2) {
                    this.j = new RequestError("Failed to create url", e2);
                } catch (URISyntaxException e3) {
                    this.j = new RequestError("Failed to add parameters to url", e3);
                }
            }
            return new Request(this, null);
        }

        public c m() {
            if (this.f9386c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f9386c = new URL(this.f9385b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f9387d = "GET";
            return this;
        }

        public c n() {
            if (this.f9386c != null) {
                this.j = new RequestError("Method called twice");
            }
            try {
                this.f9386c = new URL(this.f9385b);
            } catch (MalformedURLException e2) {
                this.j = new RequestError(e2);
            }
            this.f9387d = "POST";
            return this;
        }

        public c o(boolean z) {
            this.f9392i = z;
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
                    g.f39604a.e(SingleRequest.TAG, "failed to read is", e2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.a.d0.a.c.k.a(byteArrayOutputStream);
        }
    }

    public void d(k kVar) {
        this.f9373g.a(this, kVar);
    }

    public void e(l lVar) {
        if (this.f9375i != null) {
            g(new a(lVar));
        } else {
            this.f9373g.a(this, new b(lVar));
        }
    }

    public boolean f() {
        Map<String, String> map = this.f9370d;
        return map != null && map.size() > 0;
    }

    public final void g(Runnable runnable) {
        this.f9374h.post(runnable);
    }

    public Request(c cVar) {
        this.f9375i = cVar.j;
        this.f9372f = cVar.f9384a;
        this.f9374h = new Handler(this.f9372f.getMainLooper());
        this.f9367a = cVar.f9386c;
        this.f9368b = cVar.f9387d;
        this.f9369c = cVar.f9388e;
        this.f9370d = cVar.f9389f;
        boolean unused = cVar.f9390g;
        this.f9371e = cVar.f9391h != null ? cVar.f9391h : this;
        this.f9373g = d.a.d0.d.a.c.c(this.f9372f);
        this.j = cVar.f9392i;
    }
}
