package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.InterfaceC0277a f4181a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f4182b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.InterfaceC0277a interfaceC0277a) {
        this.f4182b = aVar;
        this.f4181a = interfaceC0277a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f4181a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0277a interfaceC0277a = this.f4181a;
        a2 = this.f4182b.a(str);
        interfaceC0277a.a((a.InterfaceC0277a) a2);
    }
}
