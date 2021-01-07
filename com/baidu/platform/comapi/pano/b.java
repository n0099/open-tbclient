package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.InterfaceC0293a f4371a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f4372b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.InterfaceC0293a interfaceC0293a) {
        this.f4372b = aVar;
        this.f4371a = interfaceC0293a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f4371a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0293a interfaceC0293a = this.f4371a;
        a2 = this.f4372b.a(str);
        interfaceC0293a.a((a.InterfaceC0293a) a2);
    }
}
