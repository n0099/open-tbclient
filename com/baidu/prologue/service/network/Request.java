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
/* loaded from: classes5.dex */
public final class Request {
    private final Context context;
    protected final Map<String, String> cvt;
    private final e cvu;
    private final RequestError cvv;
    protected boolean cvw;
    protected boolean cvx;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.cvv = aVar.cvv;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.cvt = aVar.cvt;
        this.cvw = aVar.cvw;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.cvu = c.bP(this.context);
        this.cvx = aVar.cvD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] k(InputStream inputStream) {
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
                    com.baidu.prologue.a.c.g.ctf.e("Request", "failed to read is", e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.prologue.a.c.l.e(byteArrayOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Runnable runnable) {
        this.handler.post(runnable);
    }

    public void a(final m mVar) {
        if (this.cvv != null) {
            d(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.l(Request.this.cvv);
                }
            });
        } else {
            this.cvu.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                    final String str = new String(Request.k(inputStream));
                    Request.this.d(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mVar.onResponse(str);
                        }
                    });
                }

                @Override // com.baidu.prologue.service.network.l
                public void l(final Throwable th) {
                    Request.this.d(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            mVar.l(th);
                        }
                    });
                }
            });
        }
    }

    public void a(l lVar) {
        this.cvu.a(this, lVar);
    }

    /* loaded from: classes5.dex */
    public static class a {
        private final Context context;
        private final String cvC;
        private boolean cvD;
        private Map<String, String> cvt;
        private RequestError cvv;
        private boolean cvw;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.cvC = str;
        }

        public Request ahv() {
            if (this.method == null) {
                ahw();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.c(this.url.toString(), this.cvt));
                } catch (MalformedURLException e) {
                    this.cvv = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.cvv = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a ahw() {
            if (this.url != null) {
                this.cvv = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.cvC);
            } catch (MalformedURLException e) {
                this.cvv = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a ahx() {
            if (this.url != null) {
                this.cvv = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.cvC);
            } catch (MalformedURLException e) {
                this.cvv = new RequestError(e);
            }
            this.method = "POST";
            return this;
        }

        public a bh(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2.trim());
            return this;
        }

        public a bi(String str, String str2) {
            if (this.cvt == null) {
                this.cvt = new HashMap();
            }
            this.cvt.put(str, str2);
            return this;
        }

        public a ep(boolean z) {
            this.cvD = z;
            return this;
        }
    }

    /* loaded from: classes5.dex */
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
