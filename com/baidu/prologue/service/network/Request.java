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
/* loaded from: classes9.dex */
public final class Request {
    protected boolean bMA;
    protected boolean bMB;
    protected final Map<String, String> bMx;
    private final e bMy;
    private final RequestError bMz;
    private final Context context;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.bMz = aVar.bMz;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.bMx = aVar.bMx;
        this.bMA = aVar.bMA;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.bMy = c.aT(this.context);
        this.bMB = aVar.bMH;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                } catch (IOException e) {
                    com.baidu.prologue.a.c.g.bKo.e("Request", "failed to read is", e);
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
        if (this.bMz != null) {
            e(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.n(Request.this.bMz);
                }
            });
        } else {
            this.bMy.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                    final String str = new String(Request.h(inputStream));
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
        this.bMy.a(this, lVar);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean bMA;
        private final String bMG;
        private boolean bMH;
        private Map<String, String> bMx;
        private RequestError bMz;
        private final Context context;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.bMG = str;
        }

        public Request Wc() {
            if (this.method == null) {
                Wd();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.d(this.url.toString(), this.bMx));
                } catch (MalformedURLException e) {
                    this.bMz = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.bMz = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a Wd() {
            if (this.url != null) {
                this.bMz = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bMG);
            } catch (MalformedURLException e) {
                this.bMz = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a We() {
            if (this.url != null) {
                this.bMz = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bMG);
            } catch (MalformedURLException e) {
                this.bMz = new RequestError(e);
            }
            this.method = "POST";
            return this;
        }

        public a aQ(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2.trim());
            return this;
        }

        public a aR(String str, String str2) {
            if (this.bMx == null) {
                this.bMx = new HashMap();
            }
            this.bMx.put(str, str2);
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public a m32do(boolean z) {
            this.bMH = z;
            return this;
        }
    }

    /* loaded from: classes9.dex */
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
