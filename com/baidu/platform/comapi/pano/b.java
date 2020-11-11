package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.InterfaceC0284a f2937a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.InterfaceC0284a interfaceC0284a) {
        this.b = aVar;
        this.f2937a = interfaceC0284a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f2937a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0284a interfaceC0284a = this.f2937a;
        a2 = this.b.a(str);
        interfaceC0284a.a((a.InterfaceC0284a) a2);
    }
}
