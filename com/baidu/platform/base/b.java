package com.baidu.platform.base;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9371a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9372b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9373c;

    public b(a aVar, d dVar, Object obj) {
        this.f9373c = aVar;
        this.f9371a = dVar;
        this.f9372b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9373c.a(httpStateError, this.f9371a, this.f9372b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        this.f9373c.a(str);
        a aVar = this.f9373c;
        d dVar = this.f9371a;
        Object obj = this.f9372b;
        asyncHttpClient = aVar.f9367b;
        aVar.a(str, dVar, obj, asyncHttpClient, this);
    }
}
