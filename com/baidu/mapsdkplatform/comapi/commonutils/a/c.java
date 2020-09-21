package com.baidu.mapsdkplatform.comapi.commonutils.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes3.dex */
class c implements HostnameVerifier {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
