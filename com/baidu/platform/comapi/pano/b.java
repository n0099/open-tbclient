package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC0118a f9327a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f9328b;

    public b(a aVar, a.InterfaceC0118a interfaceC0118a) {
        this.f9328b = aVar;
        this.f9327a = interfaceC0118a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9327a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0118a interfaceC0118a = this.f9327a;
        a2 = this.f9328b.a(str);
        interfaceC0118a.a((a.InterfaceC0118a) a2);
    }
}
