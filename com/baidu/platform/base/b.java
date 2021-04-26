package com.baidu.platform.base;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9722a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9723b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9724c;

    public b(a aVar, d dVar, Object obj) {
        this.f9724c = aVar;
        this.f9722a = dVar;
        this.f9723b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9724c.a(httpStateError, this.f9722a, this.f9723b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        this.f9724c.a(str);
        a aVar = this.f9724c;
        d dVar = this.f9722a;
        Object obj = this.f9723b;
        asyncHttpClient = aVar.f9718b;
        aVar.a(str, dVar, obj, asyncHttpClient, this);
    }
}
