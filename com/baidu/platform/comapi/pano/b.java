package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b extends HttpClient.ProtoResultCallback {
    final /* synthetic */ a.InterfaceC0081a a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.InterfaceC0081a interfaceC0081a) {
        this.b = aVar;
        this.a = interfaceC0081a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a;
        a.InterfaceC0081a interfaceC0081a = this.a;
        a = this.b.a(str);
        interfaceC0081a.a((a.InterfaceC0081a) a);
    }
}
