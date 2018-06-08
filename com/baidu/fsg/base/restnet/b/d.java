package com.baidu.fsg.base.restnet.b;

import android.text.TextUtils;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d implements HostnameVerifier {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        f fVar;
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            fVar = this.a.e;
            String v = fVar.b().v();
            if (!TextUtils.isEmpty(v) && peerCertificates != null && peerCertificates.length > 0) {
                X509Certificate x509Certificate = (X509Certificate) peerCertificates[0];
                Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                if (subjectAlternativeNames != null) {
                    for (List<?> list : subjectAlternativeNames) {
                        if (((Integer) list.get(0)).intValue() == 2) {
                            String str2 = (String) list.get(1);
                            if (v.equals(str2)) {
                                return true;
                            }
                            if (str2 != null && str2.startsWith("*") && Pattern.compile(str2.replace("*", "(\\w*-*\\w*)")).matcher(v).matches()) {
                                return true;
                            }
                        }
                    }
                } else {
                    String name = x509Certificate.getSubjectDN().getName();
                    if (!TextUtils.isEmpty(name) && name.contains("CN=")) {
                        int indexOf = name.indexOf("CN=") + 3;
                        int indexOf2 = name.indexOf(",", indexOf);
                        if (v.equals(indexOf2 > indexOf ? name.substring(indexOf, indexOf2) : name.substring(indexOf))) {
                            return true;
                        }
                    }
                }
            }
        } catch (CertificateParsingException e) {
            e.printStackTrace();
        } catch (SSLPeerUnverifiedException e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
