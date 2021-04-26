package com.baidu.platform.comjni.map.cloud;

import android.os.Handler;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class b extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10328a;

    public b(a aVar) {
        this.f10328a = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        a aVar;
        int i2;
        if (httpStateError == HttpClient.HttpStateError.NETWORK_ERROR) {
            aVar = this.f10328a;
            i2 = -3;
        } else {
            aVar = this.f10328a;
            i2 = 1;
        }
        aVar.a(i2);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean a2;
        Handler handler;
        this.f10328a.f10327h = str;
        a2 = this.f10328a.a();
        if (a2) {
            this.f10328a.f(str);
            return;
        }
        handler = this.f10328a.f10326g;
        handler.post(new c(this, str));
    }
}
