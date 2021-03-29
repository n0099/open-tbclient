package com.baidu.platform.base;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9813a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9814b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9815c;

    public b(a aVar, d dVar, Object obj) {
        this.f9815c = aVar;
        this.f9813a = dVar;
        this.f9814b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9815c.a(httpStateError, this.f9813a, this.f9814b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        this.f9815c.a(str);
        a aVar = this.f9815c;
        d dVar = this.f9813a;
        Object obj = this.f9814b;
        asyncHttpClient = aVar.f9809b;
        aVar.a(str, dVar, obj, asyncHttpClient, this);
    }
}
