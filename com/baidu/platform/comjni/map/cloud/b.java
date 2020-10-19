package com.baidu.platform.comjni.map.cloud;

import android.os.Handler;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3181a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3181a = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        if (httpStateError == HttpClient.HttpStateError.NETWORK_ERROR) {
            this.f3181a.a(-3);
        } else {
            this.f3181a.a(1);
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean a2;
        Handler handler;
        this.f3181a.h = str;
        a2 = this.f3181a.a();
        if (a2) {
            this.f3181a.f(str);
            return;
        }
        handler = this.f3181a.g;
        handler.post(new c(this, str));
    }
}
