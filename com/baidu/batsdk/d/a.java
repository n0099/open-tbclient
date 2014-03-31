package com.baidu.batsdk.d;

import com.baidu.batsdk.b.e;
import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public class a {
    private static DefaultHttpClient a;
    private static String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public static DefaultHttpClient a() {
        if (a == null) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            a = defaultHttpClient;
            HttpParams params = defaultHttpClient.getParams();
            params.setParameter("http.connection.timeout", Integer.valueOf(com.baidu.batsdk.a.z));
            params.setParameter("http.socket.timeout", Integer.valueOf(com.baidu.batsdk.a.z));
            if (b == null) {
                b = "BatSDK/1.0.0 (" + e.a() + " " + e.c() + ")";
            }
            params.setParameter("http.useragent", b);
            a.setHttpRequestRetryHandler(new HttpRequestRetryHandler() { // from class: com.baidu.batsdk.d.a.1
                public final boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
                    return i <= com.baidu.batsdk.a.A;
                }
            });
        }
        return a;
    }
}
