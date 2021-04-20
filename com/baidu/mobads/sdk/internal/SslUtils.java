package com.baidu.mobads.sdk.internal;

import com.baidu.browser.sailor.BdSailorConfig;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes2.dex */
public class SslUtils {

    /* loaded from: classes2.dex */
    public static class TrustMgr implements TrustManager, X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isClientTrusted(X509Certificate[] x509CertificateArr) {
            return true;
        }

        public boolean isServerTrusted(X509Certificate[] x509CertificateArr) {
            return true;
        }
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public static void ignoreSsl() {
        try {
            HostnameVerifier hostnameVerifier = new HostnameVerifier() { // from class: com.baidu.mobads.sdk.internal.SslUtils.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        } catch (Throwable unused) {
        }
    }

    public static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustManagerArr = {new TrustMgr()};
        SSLContext sSLContext = SSLContext.getInstance(BdSailorConfig.SAILOR_BASE_SSL);
        sSLContext.init(null, trustManagerArr, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
    }
}
