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
/* loaded from: classes10.dex */
public final class Request {
    protected boolean bOA;
    protected boolean bOB;
    protected final Map<String, String> bOx;
    private final e bOy;
    private final RequestError bOz;
    private final Context context;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.bOz = aVar.bOz;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.bOx = aVar.bOx;
        this.bOA = aVar.bOA;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.bOy = c.aS(this.context);
        this.bOB = aVar.bOH;
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
                    com.baidu.prologue.a.c.g.bMo.e("Request", "failed to read is", e);
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
        if (this.bOz != null) {
            e(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.n(Request.this.bOz);
                }
            });
        } else {
            this.bOy.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
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
        this.bOy.a(this, lVar);
    }

    /* loaded from: classes10.dex */
    public static class a {
        private boolean bOA;
        private final String bOG;
        private boolean bOH;
        private Map<String, String> bOx;
        private RequestError bOz;
        private final Context context;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.bOG = str;
        }

        public Request WL() {
            if (this.method == null) {
                WM();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.d(this.url.toString(), this.bOx));
                } catch (MalformedURLException e) {
                    this.bOz = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.bOz = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a WM() {
            if (this.url != null) {
                this.bOz = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bOG);
            } catch (MalformedURLException e) {
                this.bOz = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a WN() {
            if (this.url != null) {
                this.bOz = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bOG);
            } catch (MalformedURLException e) {
                this.bOz = new RequestError(e);
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
            if (this.bOx == null) {
                this.bOx = new HashMap();
            }
            this.bOx.put(str, str2);
            return this;
        }

        public a dm(boolean z) {
            this.bOH = z;
            return this;
        }
    }

    /* loaded from: classes10.dex */
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
