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
/* loaded from: classes8.dex */
public final class Request {
    protected final Map<String, String> bGT;
    private final e bGU;
    private final RequestError bGV;
    protected boolean bGW;
    protected boolean bGX;
    private final Context context;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.bGV = aVar.bGV;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.bGT = aVar.bGT;
        this.bGW = aVar.bGW;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.bGU = c.aO(this.context);
        this.bGX = aVar.bHd;
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
                    com.baidu.prologue.a.c.g.bEK.e("Request", "failed to read is", e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.prologue.a.c.l.d(byteArrayOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Runnable runnable) {
        this.handler.post(runnable);
    }

    public void a(final m mVar) {
        if (this.bGV != null) {
            g(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.o(Request.this.bGV);
                }
            });
        } else {
            this.bGU.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                    final String str = new String(Request.h(inputStream));
                    Request.this.g(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mVar.onResponse(str);
                        }
                    });
                }

                @Override // com.baidu.prologue.service.network.l
                public void o(final Throwable th) {
                    Request.this.g(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            mVar.o(th);
                        }
                    });
                }
            });
        }
    }

    public void a(l lVar) {
        this.bGU.a(this, lVar);
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Map<String, String> bGT;
        private RequestError bGV;
        private boolean bGW;
        private final String bHc;
        private boolean bHd;
        private final Context context;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.bHc = str;
        }

        public Request Qh() {
            if (this.method == null) {
                Qi();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.d(this.url.toString(), this.bGT));
                } catch (MalformedURLException e) {
                    this.bGV = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.bGV = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a Qi() {
            if (this.url != null) {
                this.bGV = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bHc);
            } catch (MalformedURLException e) {
                this.bGV = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a Qj() {
            if (this.url != null) {
                this.bGV = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bHc);
            } catch (MalformedURLException e) {
                this.bGV = new RequestError(e);
            }
            this.method = "POST";
            return this;
        }

        public a aM(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2.trim());
            return this;
        }

        public a aN(String str, String str2) {
            if (this.bGT == null) {
                this.bGT = new HashMap();
            }
            this.bGT.put(str, str2);
            return this;
        }

        public a df(boolean z) {
            this.bHd = z;
            return this;
        }
    }

    /* loaded from: classes8.dex */
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
