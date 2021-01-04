package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.InterfaceC0293a f4370a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f4371b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.InterfaceC0293a interfaceC0293a) {
        this.f4371b = aVar;
        this.f4370a = interfaceC0293a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f4370a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0293a interfaceC0293a = this.f4370a;
        a2 = this.f4371b.a(str);
        interfaceC0293a.a((a.InterfaceC0293a) a2);
    }
}
