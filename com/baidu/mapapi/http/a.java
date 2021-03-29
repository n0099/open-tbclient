package com.baidu.mapapi.http;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class a extends AsyncHttpClient.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HttpClient.ProtoResultCallback f6789a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6790b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AsyncHttpClient f6791c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, String str) {
        super(null);
        this.f6791c = asyncHttpClient;
        this.f6789a = protoResultCallback;
        this.f6790b = str;
    }

    @Override // com.baidu.mapapi.http.AsyncHttpClient.a
    public void a() {
        int i;
        int i2;
        HttpClient httpClient = new HttpClient("GET", this.f6789a);
        i = this.f6791c.f6779a;
        httpClient.setMaxTimeOut(i);
        i2 = this.f6791c.f6780b;
        httpClient.setReadTimeOut(i2);
        httpClient.request(this.f6790b);
    }
}
