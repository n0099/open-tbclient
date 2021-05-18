package com.baidu.mapapi.http;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class a extends AsyncHttpClient.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HttpClient.ProtoResultCallback f6871a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AsyncHttpClient f6873c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, String str) {
        super(null);
        this.f6873c = asyncHttpClient;
        this.f6871a = protoResultCallback;
        this.f6872b = str;
    }

    @Override // com.baidu.mapapi.http.AsyncHttpClient.a
    public void a() {
        int i2;
        int i3;
        HttpClient httpClient = new HttpClient("GET", this.f6871a);
        i2 = this.f6873c.f6861a;
        httpClient.setMaxTimeOut(i2);
        i3 = this.f6873c.f6862b;
        httpClient.setReadTimeOut(i3);
        httpClient.request(this.f6872b);
    }
}
