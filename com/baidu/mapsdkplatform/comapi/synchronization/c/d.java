package com.baidu.mapsdkplatform.comapi.synchronization.c;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
public class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f7749a;

    public d(c cVar) {
        this.f7749a = cVar;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
