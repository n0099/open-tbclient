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
    protected final Map<String, String> bBG;
    private final e bBH;
    private final RequestError bBI;
    protected boolean bBJ;
    protected boolean bBK;
    private final Context context;
    private final Handler handler;
    protected final Map<String, String> headers;
    protected final String method;
    protected final Object tag;
    protected final URL url;

    private Request(a aVar) {
        this.bBI = aVar.bBI;
        this.context = aVar.context;
        this.handler = new Handler(this.context.getMainLooper());
        this.url = aVar.url;
        this.method = aVar.method;
        this.headers = aVar.headers;
        this.bBG = aVar.bBG;
        this.bBJ = aVar.bBJ;
        this.tag = aVar.tag != null ? aVar.tag : this;
        this.bBH = c.aM(this.context);
        this.bBK = aVar.bBQ;
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
                    com.baidu.prologue.a.c.f.bzz.e("Request", "failed to read is", e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.prologue.a.c.k.d(byteArrayOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Runnable runnable) {
        this.handler.post(runnable);
    }

    public void a(final m mVar) {
        if (this.bBI != null) {
            h(new Runnable() { // from class: com.baidu.prologue.service.network.Request.1
                @Override // java.lang.Runnable
                public void run() {
                    mVar.o(Request.this.bBI);
                }
            });
        } else {
            this.bBH.a(this, new l() { // from class: com.baidu.prologue.service.network.Request.2
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
                public void o(final Throwable th) {
                    Request.this.h(new Runnable() { // from class: com.baidu.prologue.service.network.Request.2.2
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
        this.bBH.a(this, lVar);
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Map<String, String> bBG;
        private RequestError bBI;
        private boolean bBJ;
        private final String bBP;
        private boolean bBQ;
        private final Context context;
        private Map<String, String> headers;
        private String method;
        private Object tag;
        private URL url;

        public a(Context context, String str) {
            this.context = context.getApplicationContext();
            this.bBP = str;
        }

        public Request OM() {
            if (this.method == null) {
                ON();
            }
            if ("GET".equals(this.method)) {
                try {
                    this.url = new URL(b.d(this.url.toString(), this.bBG));
                } catch (MalformedURLException e) {
                    this.bBI = new RequestError("Failed to create url", e);
                } catch (URISyntaxException e2) {
                    this.bBI = new RequestError("Failed to add parameters to url", e2);
                }
            }
            return new Request(this);
        }

        public a ON() {
            if (this.url != null) {
                this.bBI = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bBP);
            } catch (MalformedURLException e) {
                this.bBI = new RequestError(e);
            }
            this.method = "GET";
            return this;
        }

        public a OO() {
            if (this.url != null) {
                this.bBI = new RequestError("Method called twice");
            }
            try {
                this.url = new URL(this.bBP);
            } catch (MalformedURLException e) {
                this.bBI = new RequestError(e);
            }
            this.method = "POST";
            return this;
        }

        public a aK(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2.trim());
            return this;
        }

        public a aL(String str, String str2) {
            if (this.bBG == null) {
                this.bBG = new HashMap();
            }
            this.bBG.put(str, str2);
            return this;
        }

        public a cY(boolean z) {
            this.bBQ = z;
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
