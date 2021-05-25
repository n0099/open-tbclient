package com.baidu.mapsdkplatform.comapi.util;

import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class c extends HttpClient.ProtoResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomMapStyleLoader f7903a;

    public c(CustomMapStyleLoader customMapStyleLoader) {
        this.f7903a = customMapStyleLoader;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        String str = CustomMapStyleLoader.f7871a;
        Log.e(str, "sendRequest onFailed error = " + httpStateError);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        this.f7903a.b(str);
    }
}
