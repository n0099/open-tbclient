package com.baidu.sapi2.a;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
class c implements HttpRequestRetryHandler {
    private static final int a = 1500;
    private static HashSet<Class<?>> b = new HashSet<>();
    private static HashSet<Class<?>> c = new HashSet<>();
    private final int d;

    static {
        b.add(NoHttpResponseException.class);
        b.add(UnknownHostException.class);
        b.add(SocketException.class);
        c.add(InterruptedIOException.class);
        c.add(SSLException.class);
    }

    public c(int i) {
        this.d = i;
    }

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        boolean z;
        boolean z2 = true;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z3 = bool != null && bool.booleanValue();
        if (i > this.d) {
            z = false;
        } else if (a(c, iOException)) {
            z = false;
        } else if (a(b, iOException)) {
            z = true;
        } else {
            z = !z3 ? true : true;
        }
        if (!z) {
            z2 = z;
        } else if (((HttpUriRequest) httpContext.getAttribute("http.request")).getMethod().equals("POST")) {
            z2 = false;
        }
        if (z2) {
            SystemClock.sleep(1500L);
        } else {
            iOException.printStackTrace();
        }
        return z2;
    }

    protected boolean a(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
