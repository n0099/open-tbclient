package com.baidu.mapapi.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes7.dex */
class b implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HttpClient f1992a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HttpClient httpClient) {
        this.f1992a = httpClient;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
