package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9301a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9302b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9303c;

    public b(a aVar, d dVar, Object obj) {
        this.f9303c = aVar;
        this.f9301a = dVar;
        this.f9302b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9303c.a(httpStateError, this.f9301a, this.f9302b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        String a2 = this.f9301a instanceof com.baidu.platform.core.b.e ? this.f9303c.a(str) : "";
        String str2 = !TextUtils.isEmpty(a2) ? a2 : str;
        this.f9303c.c(str2);
        a aVar = this.f9303c;
        d dVar = this.f9301a;
        Object obj = this.f9302b;
        asyncHttpClient = aVar.f9296b;
        aVar.a(str2, dVar, obj, asyncHttpClient, this);
    }
}
