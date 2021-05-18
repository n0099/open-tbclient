package com.baidu.apollon.b;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final X509TrustManager f3585a = b();

    public static X509TrustManager a() {
        return f3585a;
    }

    public static X509TrustManager b() {
        TrustManager[] trustManagers;
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            X509TrustManager x509TrustManager = null;
            trustManagerFactory.init((KeyStore) null);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                }
            }
            if (x509TrustManager != null) {
                return x509TrustManager;
            }
            throw new IllegalStateException("Should never happen");
        } catch (KeyStoreException unused) {
            throw new IllegalStateException("Should never happen");
        } catch (NoSuchAlgorithmException unused2) {
            throw new IllegalStateException("Should never happen");
        }
    }
}
