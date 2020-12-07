package com.baidu.prologue.service.network;

import android.content.Context;
import android.os.Handler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public final class Request {

    /* renamed from: com  reason: collision with root package name */
    protected final Map<String, String> f3198com;
    private final Context context;
    private final e coo;
    private final RequestError cop;
    protected boolean coq;
    protected boolean cor;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.cop = aVar.cop;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.f3198com = aVar.f3199com;
        this.coq = aVar.coq;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.coo = c.bC(this.context);
        this.cor = aVar.cox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] j(InputStream inputStream) {
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
                } catch (IOException e) {
                    com.baidu.prologue.a.c.g.cmb.e("Request", "failed to read is", e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.prologue.a.c.l.d(byteArrayOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Runnable runnable) {
        this.handler.post(runnable);
    }

    public void a(final m mVar) {
        if (this.cop != null) {
            e(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.n(Request.this.cop);
                }
            });
        } else {
            this.coo.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                    final String str = new String(Request.j(inputStream));
                    Request.this.e(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mVar.onResponse(str);
                        }
                    });
                }

                @Override // com.baidu.prologue.service.network.l
                public void n(final Throwable th) {
                    Request.this.e(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            mVar.n(th);
                        }
                    });
                }
            });
        }
    }

    public void a(l lVar) {
        this.coo.a(this, lVar);
    }

    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: com  reason: collision with root package name */
        private Map<String, String> f3199com;
        private final Context context;
        private RequestError cop;
        private boolean coq;
        private final String cow;
        private boolean cox;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.cow = str;
        }

        public Request afz() {
            if (this.method == null) {
                afA();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.c(this.url.toString(), this.f3199com));
                } catch (MalformedURLException e) {
                    this.cop = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.cop = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a afA() {
            if (this.url != null) {
                this.cop = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.cow);
            } catch (MalformedURLException e) {
                this.cop = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a afB() {
            if (this.url != null) {
                this.cop = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.cow);
            } catch (MalformedURLException e) {
                this.cop = new RequestError(e);
            }
            this.method = "POST";
            return this;
        }

        public a bi(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2.trim());
            return this;
        }

        public a bj(String str, String str2) {
            if (this.f3199com == null) {
                this.f3199com = new HashMap();
            }
            this.f3199com.put(str, str2);
            return this;
        }

        public a eg(boolean z) {
            this.cox = z;
            return this;
        }
    }

    /* loaded from: classes14.dex */
    public static class RequestError extends IOException {
        public RequestError() {
        }

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
}
