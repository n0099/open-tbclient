package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9244a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9245b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9246c;

    public b(a aVar, d dVar, Object obj) {
        this.f9246c = aVar;
        this.f9244a = dVar;
        this.f9245b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9246c.a(httpStateError, this.f9244a, this.f9245b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        String a2 = this.f9244a instanceof com.baidu.platform.core.b.e ? this.f9246c.a(str) : "";
        String str2 = !TextUtils.isEmpty(a2) ? a2 : str;
        this.f9246c.c(str2);
        a aVar = this.f9246c;
        d dVar = this.f9244a;
        Object obj = this.f9245b;
        asyncHttpClient = aVar.f9239b;
        aVar.a(str2, dVar, obj, asyncHttpClient, this);
    }
}
