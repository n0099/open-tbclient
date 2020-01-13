package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b extends HttpClient.ProtoResultCallback {
    final /* synthetic */ a.InterfaceC0131a a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.InterfaceC0131a interfaceC0131a) {
        this.b = aVar;
        this.a = interfaceC0131a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a;
        a.InterfaceC0131a interfaceC0131a = this.a;
        a = this.b.a(str);
        interfaceC0131a.a((a.InterfaceC0131a) a);
    }
}
