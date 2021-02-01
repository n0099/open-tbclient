package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.InterfaceC0281a f4184a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f4185b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.InterfaceC0281a interfaceC0281a) {
        this.f4185b = aVar;
        this.f4184a = interfaceC0281a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f4184a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0281a interfaceC0281a = this.f4184a;
        a2 = this.f4185b.a(str);
        interfaceC0281a.a((a.InterfaceC0281a) a2);
    }
}
