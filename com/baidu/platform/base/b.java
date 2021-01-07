package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4173a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f4174b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, d dVar, Object obj) {
        this.c = aVar;
        this.f4173a = dVar;
        this.f4174b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        this.c.a(httpStateError, this.f4173a, this.f4174b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean c;
        String str2;
        AsyncHttpClient asyncHttpClient;
        c = this.c.c(str);
        if (!c) {
            String a2 = this.f4173a instanceof com.baidu.platform.core.b.e ? this.c.a(str) : "";
            if (!TextUtils.isEmpty(a2)) {
                str2 = a2;
                a aVar = this.c;
                d dVar = this.f4173a;
                Object obj = this.f4174b;
                asyncHttpClient = this.c.f4172b;
                aVar.a(str2, dVar, obj, asyncHttpClient, this);
            }
        }
        str2 = str;
        a aVar2 = this.c;
        d dVar2 = this.f4173a;
        Object obj2 = this.f4174b;
        asyncHttpClient = this.c.f4172b;
        aVar2.a(str2, dVar2, obj2, asyncHttpClient, this);
    }
}
