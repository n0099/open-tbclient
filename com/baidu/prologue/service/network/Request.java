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
/* loaded from: classes19.dex */
public final class Request {
    protected final Map<String, String> bVg;
    private final e bVh;
    private final RequestError bVi;
    protected boolean bVj;
    protected boolean bVk;
    private final Context context;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.bVi = aVar.bVi;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.bVg = aVar.bVg;
        this.bVj = aVar.bVj;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.bVh = c.aW(this.context);
        this.bVk = aVar.bVq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] i(InputStream inputStream) {
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
                    com.baidu.prologue.a.c.g.bSX.e("Request", "failed to read is", e);
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
        if (this.bVi != null) {
            e(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.n(Request.this.bVi);
                }
            });
        } else {
            this.bVh.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                    final String str = new String(Request.i(inputStream));
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
        this.bVh.a(this, lVar);
    }

    /* loaded from: classes19.dex */
    public static class a {
        private Map<String, String> bVg;
        private RequestError bVi;
        private boolean bVj;
        private final String bVp;
        private boolean bVq;
        private final Context context;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.bVp = str;
        }

        public Request YI() {
            if (this.method == null) {
                YJ();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.d(this.url.toString(), this.bVg));
                } catch (MalformedURLException e) {
                    this.bVi = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.bVi = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a YJ() {
            if (this.url != null) {
                this.bVi = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bVp);
            } catch (MalformedURLException e) {
                this.bVi = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a YK() {
            if (this.url != null) {
                this.bVi = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bVp);
            } catch (MalformedURLException e) {
                this.bVi = new RequestError(e);
            }
            this.method = "POST";
            return this;
        }

        public a aV(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2.trim());
            return this;
        }

        public a aW(String str, String str2) {
            if (this.bVg == null) {
                this.bVg = new HashMap();
            }
            this.bVg.put(str, str2);
            return this;
        }

        public a dt(boolean z) {
            this.bVq = z;
            return this;
        }
    }

    /* loaded from: classes19.dex */
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
