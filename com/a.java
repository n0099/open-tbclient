package com;

import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import java.security.KeyStore;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
/* loaded from: classes.dex */
public class a implements ClientConnectionManagerFactory {
    final /* synthetic */ AsyncHttpClient a;

    public a(AsyncHttpClient asyncHttpClient) {
        this.a = asyncHttpClient;
    }

    public ClientConnectionManager newInstance(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        SSLSocketFactory socketFactory;
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            socketFactory = new f(keyStore);
            socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (Exception e) {
            socketFactory = SSLSocketFactory.getSocketFactory();
        }
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", socketFactory, 443));
        return new ThreadSafeClientConnManager(httpParams, schemeRegistry);
    }
}
