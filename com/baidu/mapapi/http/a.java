package com.baidu.mapapi.http;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class a extends AsyncHttpClient.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HttpClient.ProtoResultCallback f7060a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7061b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AsyncHttpClient f7062c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, String str) {
        super(null);
        this.f7062c = asyncHttpClient;
        this.f7060a = protoResultCallback;
        this.f7061b = str;
    }

    @Override // com.baidu.mapapi.http.AsyncHttpClient.a
    public void a() {
        int i2;
        int i3;
        HttpClient httpClient = new HttpClient("GET", this.f7060a);
        i2 = this.f7062c.f7050a;
        httpClient.setMaxTimeOut(i2);
        i3 = this.f7062c.f7051b;
        httpClient.setReadTimeOut(i3);
        httpClient.request(this.f7061b);
    }
}
