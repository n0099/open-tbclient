package com.baidu.mapapi.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
public class b implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HttpClient f7063a;

    public b(HttpClient httpClient) {
        this.f7063a = httpClient;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
