package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.map.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2227a;
    final /* synthetic */ String b;
    final /* synthetic */ f.a c;
    final /* synthetic */ f d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Context context, String str, f.a aVar) {
        this.d = fVar;
        this.f2227a = context;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        String a2;
        boolean a3;
        a2 = this.d.a(this.f2227a, this.b);
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
        this.d.b(this.f2227a, str, this.b, this.c);
    }
}
