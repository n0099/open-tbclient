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
/* loaded from: classes6.dex */
public final class Request {
    protected final Map<String, String> btY;
    private final e btZ;
    private final RequestError bua;
    protected boolean bub;
    protected boolean buc;
    private final Context context;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.bua = aVar.bua;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.btY = aVar.btY;
        this.bub = aVar.bub;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.btZ = c.aO(this.context);
        this.buc = aVar.buj;
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
                    com.baidu.prologue.a.c.f.brS.e("Request", "failed to read is", e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.prologue.a.c.k.b(byteArrayOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Runnable runnable) {
        this.handler.post(runnable);
    }

    public void a(final m mVar) {
        if (this.bua != null) {
            h(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.n(Request.this.bua);
                }
            });
        } else {
            this.btZ.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                    final String str = new String(Request.h(inputStream));
                    Request.this.h(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mVar.onResponse(str);
                        }
                    });
                }

                @Override // com.baidu.prologue.service.network.l
                public void n(final Throwable th) {
                    Request.this.h(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.2
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
        this.btZ.a(this, lVar);
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Map<String, String> btY;
        private RequestError bua;
        private boolean bub;
        private final String bui;
        private boolean buj;
        private final Context context;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.bui = str;
        }

        public Request MA() {
            if (this.method == null) {
                MB();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.c(this.url.toString(), this.btY));
                } catch (MalformedURLException e) {
                    this.bua = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.bua = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a MB() {
            if (this.url != null) {
                this.bua = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bui);
            } catch (MalformedURLException e) {
                this.bua = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a MC() {
            if (this.url != null) {
                this.bua = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bui);
            } catch (MalformedURLException e) {
                this.bua = new RequestError(e);
            }
            this.method = "POST";
            return this;
        }

        public a av(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2.trim());
            return this;
        }

        public a aw(String str, String str2) {
            if (this.btY == null) {
                this.btY = new HashMap();
            }
            this.btY.put(str, str2);
            return this;
        }

        public a cM(boolean z) {
            this.buj = z;
            return this;
        }
    }

    /* loaded from: classes6.dex */
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
