package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC0120a f9890a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f9891b;

    public b(a aVar, a.InterfaceC0120a interfaceC0120a) {
        this.f9891b = aVar;
        this.f9890a = interfaceC0120a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9890a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0120a interfaceC0120a = this.f9890a;
        a2 = this.f9891b.a(str);
        interfaceC0120a.a((a.InterfaceC0120a) a2);
    }
}
