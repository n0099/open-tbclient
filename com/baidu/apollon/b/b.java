package com.baidu.apollon.b;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes.dex */
public class b implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    public final X509TrustManager f3542a = d.a();

    /* renamed from: b  reason: collision with root package name */
    public final Set<c> f3543b;

    public b(@NonNull Set<c> set) {
        this.f3543b = set;
    }

    public static boolean a(List<X509Certificate> list, Set<c> set) {
        for (X509Certificate x509Certificate : list) {
            if (set.contains(new c(x509Certificate))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f3542a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f3542a.checkServerTrusted(x509CertificateArr, str);
        if (this.f3543b.isEmpty() || a(Arrays.asList(x509CertificateArr), this.f3543b)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Pin verification failed");
        sb.append("\n  Configured pins: ");
        for (c cVar : this.f3543b) {
            sb.append(cVar);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("\n  Peer certificate chain: ");
        for (Certificate certificate : Arrays.asList(x509CertificateArr)) {
            sb.append("\n    ");
            sb.append(new c(certificate));
            sb.append(" - ");
            sb.append(((X509Certificate) certificate).getSubjectDN());
        }
        throw new CertificateException(sb.toString());
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.f3542a.getAcceptedIssuers();
    }
}
