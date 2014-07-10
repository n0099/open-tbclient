package com.baidu.cloudsdk.common.http;

import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* loaded from: classes.dex */
class SSLSocketFactoryEx extends SSLSocketFactory {
    private SSLContext mSslContext;

    public SSLSocketFactoryEx(KeyStore keyStore) {
        super(keyStore);
        X509TrustManager x509TrustManager = new X509TrustManager() { // from class: com.baidu.cloudsdk.common.http.SSLSocketFactoryEx.1
            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }
        };
        this.mSslContext = SSLContext.getInstance("TLS");
        this.mSslContext.init(null, new TrustManager[]{x509TrustManager}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.mSslContext.getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.mSslContext.getSocketFactory().createSocket(socket, str, i, z);
    }
}
