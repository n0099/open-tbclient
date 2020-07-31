package com.baidu.platform.comjni.map.cloud;

import android.os.Handler;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b extends HttpClient.ProtoResultCallback {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        if (httpStateError == HttpClient.HttpStateError.NETWORK_ERROR) {
            this.a.a(-3);
        } else {
            this.a.a(1);
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean a;
        Handler handler;
        this.a.h = str;
        a = this.a.a();
        if (a) {
            this.a.f(str);
            return;
        }
        handler = this.a.g;
        handler.post(new c(this, str));
    }
}
