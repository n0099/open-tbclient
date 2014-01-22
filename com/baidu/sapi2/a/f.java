package com.baidu.sapi2.a;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
class f implements Runnable {
    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final i d;
    private boolean e;
    private int f;

    public f(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, i iVar) {
        this.a = abstractHttpClient;
        this.b = httpContext;
        this.c = httpUriRequest;
        this.d = iVar;
        if (iVar instanceof g) {
            this.e = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.d != null) {
                this.d.a();
            }
            b();
            if (this.d != null) {
                this.d.b();
            }
        } catch (IOException e) {
            if (this.d != null) {
                this.d.b();
                if (this.e) {
                    this.d.a(e, (byte[]) null);
                } else {
                    this.d.b(e, (String) null);
                }
            }
        }
    }

    private void a() {
        if (!Thread.currentThread().isInterrupted()) {
            HttpResponse execute = this.a.execute(this.c, this.b);
            if (!Thread.currentThread().isInterrupted() && this.d != null) {
                this.d.a(execute);
            }
        }
    }

    private void b() {
        boolean z = true;
        IOException e = null;
        HttpRequestRetryHandler httpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
        while (z) {
            try {
                a();
                return;
            } catch (NullPointerException e2) {
                e = new IOException("NPE in HttpClient" + e2.getMessage());
                int i = this.f + 1;
                this.f = i;
                z = httpRequestRetryHandler.retryRequest(e, i, this.b);
            } catch (SocketException e3) {
                if (this.d != null) {
                    this.d.b(e3, "can't resolve host");
                    return;
                }
                return;
            } catch (SocketTimeoutException e4) {
                if (this.d != null) {
                    this.d.b(e4, "socket time out");
                    return;
                }
                return;
            } catch (UnknownHostException e5) {
                if (this.d != null) {
                    this.d.b(e5, "can't resolve host");
                    return;
                }
                return;
            } catch (ConnectTimeoutException e6) {
                if (this.d != null) {
                    this.d.b(e6, "connect time out");
                    return;
                }
                return;
            } catch (IOException e7) {
                e = e7;
                int i2 = this.f + 1;
                this.f = i2;
                z = httpRequestRetryHandler.retryRequest(e, i2, this.b);
            }
        }
        ConnectException connectException = new ConnectException();
        connectException.initCause(e);
        throw connectException;
    }
}
