package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
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
        boolean c;
        String str2;
        AsyncHttpClient asyncHttpClient;
        c = this.c.c(str);
        if (!c) {
            String a = this.a instanceof com.baidu.platform.core.b.e ? this.c.a(str) : "";
            if (!TextUtils.isEmpty(a)) {
                str2 = a;
                a aVar = this.c;
                d dVar = this.a;
                Object obj = this.b;
                asyncHttpClient = this.c.b;
                aVar.a(str2, dVar, obj, asyncHttpClient, this);
            }
        }
        str2 = str;
        a aVar2 = this.c;
        d dVar2 = this.a;
        Object obj2 = this.b;
        asyncHttpClient = this.c.b;
        aVar2.a(str2, dVar2, obj2, asyncHttpClient, this);
    }
}
