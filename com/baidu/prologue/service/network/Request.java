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
    protected final Map<String, String> cdF;
    private final e cdG;
    private final RequestError cdH;
    protected boolean cdI;
    protected boolean cdJ;
    private final Context context;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.cdH = aVar.cdH;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.cdF = aVar.cdF;
        this.cdI = aVar.cdI;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.cdG = c.aW(this.context);
        this.cdJ = aVar.cdP;
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
                    com.baidu.prologue.a.c.g.cbu.e("Request", "failed to read is", e);
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
        if (this.cdH != null) {
            e(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.n(Request.this.cdH);
                }
            });
        } else {
            this.cdG.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
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
        this.cdG.a(this, lVar);
    }

    /* loaded from: classes19.dex */
    public static class a {
        private Map<String, String> cdF;
        private RequestError cdH;
        private boolean cdI;
        private final String cdO;
        private boolean cdP;
        private final Context context;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.cdO = str;
        }

        public Request aaB() {
            if (this.method == null) {
                aaC();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.d(this.url.toString(), this.cdF));
                } catch (MalformedURLException e) {
                    this.cdH = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.cdH = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a aaC() {
            if (this.url != null) {
                this.cdH = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.cdO);
            } catch (MalformedURLException e) {
                this.cdH = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a aaD() {
            if (this.url != null) {
                this.cdH = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.cdO);
            } catch (MalformedURLException e) {
                this.cdH = new RequestError(e);
            }
            this.method = "POST";
            return this;
        }

        public a bc(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2.trim());
            return this;
        }

        public a bd(String str, String str2) {
            if (this.cdF == null) {
                this.cdF = new HashMap();
            }
            this.cdF.put(str, str2);
            return this;
        }

        public a dH(boolean z) {
            this.cdP = z;
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
