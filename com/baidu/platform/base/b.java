package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9309a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9311c;

    public b(a aVar, d dVar, Object obj) {
        this.f9311c = aVar;
        this.f9309a = dVar;
        this.f9310b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.f9311c.a(httpStateError, this.f9309a, this.f9310b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        String a2 = this.f9309a instanceof com.baidu.platform.core.b.e ? this.f9311c.a(str) : "";
        String str2 = !TextUtils.isEmpty(a2) ? a2 : str;
        this.f9311c.c(str2);
        a aVar = this.f9311c;
        d dVar = this.f9309a;
        Object obj = this.f9310b;
        asyncHttpClient = aVar.f9304b;
        aVar.a(str2, dVar, obj, asyncHttpClient, this);
    }
}
