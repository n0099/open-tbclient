package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.map.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g extends HttpClient.ProtoResultCallback {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ f.a c;
    final /* synthetic */ f d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Context context, String str, f.a aVar) {
        this.d = fVar;
        this.a = context;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        String a;
        boolean a2;
        a = this.d.a(this.a, this.b);
        a2 = this.d.a(a);
        if (!a2) {
            a = null;
        }
        if (this.c != null) {
            this.c.a(httpStateError.ordinal(), httpStateError.name(), a);
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        this.d.b(this.a, str, this.b, this.c);
    }
}
