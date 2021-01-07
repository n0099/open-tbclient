package com.baidu.mapapi.http;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a extends AsyncHttpClient.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HttpClient.ProtoResultCallback f2787a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f2788b;
    final /* synthetic */ AsyncHttpClient c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, String str) {
        super(null);
        this.c = asyncHttpClient;
        this.f2787a = protoResultCallback;
        this.f2788b = str;
    }

    @Override // com.baidu.mapapi.http.AsyncHttpClient.a
    public void a() {
        int i;
        int i2;
        HttpClient httpClient = new HttpClient("GET", this.f2787a);
        i = this.c.f2783a;
        httpClient.setMaxTimeOut(i);
        i2 = this.c.f2784b;
        httpClient.setReadTimeOut(i2);
        httpClient.request(this.f2788b);
    }
}
