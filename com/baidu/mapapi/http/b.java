package com.baidu.mapapi.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes20.dex */
class b implements HostnameVerifier {
    final /* synthetic */ HttpClient a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HttpClient httpClient) {
        this.a = httpClient;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
