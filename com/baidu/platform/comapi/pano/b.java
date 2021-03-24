package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC0119a f9889a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f9890b;

    public b(a aVar, a.InterfaceC0119a interfaceC0119a) {
        this.f9890b = aVar;
        this.f9889a = interfaceC0119a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9889a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0119a interfaceC0119a = this.f9889a;
        a2 = this.f9890b.a(str);
        interfaceC0119a.a((a.InterfaceC0119a) a2);
    }
}
