package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9344a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9345b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9346c;

    public b(a aVar, d dVar, Object obj) {
        this.f9346c = aVar;
        this.f9344a = dVar;
        this.f9345b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9346c.a(httpStateError, this.f9344a, this.f9345b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        String a2 = this.f9344a instanceof com.baidu.platform.core.b.e ? this.f9346c.a(str) : "";
        String str2 = !TextUtils.isEmpty(a2) ? a2 : str;
        this.f9346c.c(str2);
        a aVar = this.f9346c;
        d dVar = this.f9344a;
        Object obj = this.f9345b;
        asyncHttpClient = aVar.f9339b;
        aVar.a(str2, dVar, obj, asyncHttpClient, this);
    }
}
