package com.baidu.platform.comjni.map.cloud;

import android.os.Handler;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9960a;

    public b(a aVar) {
        this.f9960a = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        a aVar;
        int i;
        if (httpStateError == HttpClient.HttpStateError.NETWORK_ERROR) {
            aVar = this.f9960a;
            i = -3;
        } else {
            aVar = this.f9960a;
            i = 1;
        }
        aVar.a(i);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean a2;
        Handler handler;
        this.f9960a.f9959h = str;
        a2 = this.f9960a.a();
        if (a2) {
            this.f9960a.f(str);
            return;
        }
        handler = this.f9960a.f9958g;
        handler.post(new c(this, str));
    }
}
