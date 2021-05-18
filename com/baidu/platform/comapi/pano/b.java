package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC0116a f9362a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f9363b;

    public b(a aVar, a.InterfaceC0116a interfaceC0116a) {
        this.f9363b = aVar;
        this.f9362a = interfaceC0116a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9362a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0116a interfaceC0116a = this.f9362a;
        a2 = this.f9363b.a(str);
        interfaceC0116a.a((a.InterfaceC0116a) a2);
    }
}
