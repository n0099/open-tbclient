package com.baidu.platform.base;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b extends HttpClient.ProtoResultCallback {
    final /* synthetic */ d a;
    final /* synthetic */ Object b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, d dVar, Object obj) {
        this.c = aVar;
        this.a = dVar;
        this.b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.c.a(httpStateError, this.a, this.b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        this.c.a(str);
        a aVar = this.c;
        d dVar = this.a;
        Object obj = this.b;
        asyncHttpClient = this.c.b;
        aVar.a(str, dVar, obj, asyncHttpClient, this);
    }
}
