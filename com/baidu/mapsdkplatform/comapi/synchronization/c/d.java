package com.baidu.mapsdkplatform.comapi.synchronization.c;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3102a = cVar;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
