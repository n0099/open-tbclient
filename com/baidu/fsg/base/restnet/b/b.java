package com.baidu.fsg.base.restnet.b;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
final class b implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
