package com.baidu.fsg.base.restnet.b;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes2.dex */
public class a implements X509TrustManager {
    private static final X509Certificate[] a = new X509Certificate[0];
    private static TrustManager[] b;

    public static void a() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e;
        KeyManagementException e2;
        HttpsURLConnection.setDefaultHostnameVerifier(new b());
        if (b == null) {
            b = new TrustManager[]{new a()};
        }
        try {
            sSLContext = SSLContext.getInstance("TLS");
            try {
                sSLContext.init(null, b, null);
            } catch (KeyManagementException e3) {
                e2 = e3;
                e2.printStackTrace();
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                e.printStackTrace();
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            }
        } catch (KeyManagementException e5) {
            sSLContext = null;
            e2 = e5;
        } catch (NoSuchAlgorithmException e6) {
            sSLContext = null;
            e = e6;
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public boolean a(X509Certificate[] x509CertificateArr) {
        return true;
    }

    public boolean b(X509Certificate[] x509CertificateArr) {
        return true;
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return a;
    }
}
