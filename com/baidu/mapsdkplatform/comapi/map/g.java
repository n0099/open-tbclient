package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.map.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class g extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3178a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3179b;
    final /* synthetic */ f.a c;
    final /* synthetic */ f d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Context context, String str, f.a aVar) {
        this.d = fVar;
        this.f3178a = context;
        this.f3179b = str;
        this.c = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        String a2;
        boolean a3;
        a2 = this.d.a(this.f3178a, this.f3179b);
        a3 = this.d.a(a2);
        if (!a3) {
            a2 = null;
        }
        if (this.c != null) {
            this.c.a(httpStateError.ordinal(), httpStateError.name(), a2);
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        this.d.b(this.f3178a, str, this.f3179b, this.c);
    }
}
