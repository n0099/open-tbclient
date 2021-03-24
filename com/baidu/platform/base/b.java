package com.baidu.platform.base;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9812a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9814c;

    public b(a aVar, d dVar, Object obj) {
        this.f9814c = aVar;
        this.f9812a = dVar;
        this.f9813b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9814c.a(httpStateError, this.f9812a, this.f9813b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        this.f9814c.a(str);
        a aVar = this.f9814c;
        d dVar = this.f9812a;
        Object obj = this.f9813b;
        asyncHttpClient = aVar.f9808b;
        aVar.a(str, dVar, obj, asyncHttpClient, this);
    }
}
