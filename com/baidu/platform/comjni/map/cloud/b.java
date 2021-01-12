package com.baidu.platform.comjni.map.cloud;

import android.os.Handler;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4478a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4478a = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        if (httpStateError == HttpClient.HttpStateError.NETWORK_ERROR) {
            this.f4478a.a(-3);
        } else {
            this.f4478a.a(1);
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean a2;
        Handler handler;
        this.f4478a.h = str;
        a2 = this.f4478a.a();
        if (a2) {
            this.f4478a.f(str);
            return;
        }
        handler = this.f4478a.g;
        handler.post(new c(this, str));
    }
}
