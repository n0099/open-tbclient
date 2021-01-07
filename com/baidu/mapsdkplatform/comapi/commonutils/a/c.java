package com.baidu.mapsdkplatform.comapi.commonutils.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes3.dex */
class c implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3149a = bVar;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
