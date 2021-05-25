package com.baidu.platform.comapi.pano;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC0117a f9262a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f9263b;

    public b(a aVar, a.InterfaceC0117a interfaceC0117a) {
        this.f9263b = aVar;
        this.f9262a = interfaceC0117a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9262a.a(httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        a.InterfaceC0117a interfaceC0117a = this.f9262a;
        a2 = this.f9263b.a(str);
        interfaceC0117a.a((a.InterfaceC0117a) a2);
    }
}
