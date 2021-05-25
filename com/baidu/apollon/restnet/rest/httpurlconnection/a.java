package com.baidu.apollon.restnet.rest.httpurlconnection;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes.dex */
public class a implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    public static final X509Certificate[] f3882a = new X509Certificate[0];

    /* renamed from: b  reason: collision with root package name */
    public static TrustManager[] f3883b;

    public static void a() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e2;
        KeyManagementException e3;
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.apollon.restnet.rest.httpurlconnection.a.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        });
        if (f3883b == null) {
            f3883b = new TrustManager[]{new a()};
        }
        try {
            sSLContext = SSLContext.getInstance("TLS");
        } catch (KeyManagementException e4) {
            sSLContext = null;
            e3 = e4;
        } catch (NoSuchAlgorithmException e5) {
            sSLContext = null;
            e2 = e5;
        }
        try {
            sSLContext.init(null, f3883b, null);
        } catch (KeyManagementException e6) {
            e3 = e6;
            e3.printStackTrace();
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (NoSuchAlgorithmException e7) {
            e2 = e7;
            e2.printStackTrace();
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
    }

    public boolean a(X509Certificate[] x509CertificateArr) {
        return true;
    }

    public boolean b(X509Certificate[] x509CertificateArr) {
        return true;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return f3882a;
    }
}
