package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends HttpClient.ProtoResultCallback {
    final /* synthetic */ a.InterfaceC0101a a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.InterfaceC0101a interfaceC0101a) {
        this.b = aVar;
        this.a = interfaceC0101a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a;
        a.InterfaceC0101a interfaceC0101a = this.a;
        a = this.b.a(str);
        interfaceC0101a.a((a.InterfaceC0101a) a);
    }
}
