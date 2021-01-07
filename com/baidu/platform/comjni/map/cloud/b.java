package com.baidu.platform.comjni.map.cloud;

import android.os.Handler;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4755a = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        if (httpStateError == HttpClient.HttpStateError.NETWORK_ERROR) {
            this.f4755a.a(-3);
        } else {
            this.f4755a.a(1);
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean a2;
        Handler handler;
        this.f4755a.h = str;
        a2 = this.f4755a.a();
        if (a2) {
            this.f4755a.f(str);
            return;
        }
        handler = this.f4755a.g;
        handler.post(new c(this, str));
    }
}
