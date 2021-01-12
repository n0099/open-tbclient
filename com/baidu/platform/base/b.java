package com.baidu.platform.base;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4135a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f4136b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, d dVar, Object obj) {
        this.c = aVar;
        this.f4135a = dVar;
        this.f4136b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.c.a(httpStateError, this.f4135a, this.f4136b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        this.c.a(str);
        a aVar = this.c;
        d dVar = this.f4135a;
        Object obj = this.f4136b;
        asyncHttpClient = this.c.f4134b;
        aVar.a(str, dVar, obj, asyncHttpClient, this);
    }
}
