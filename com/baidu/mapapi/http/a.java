package com.baidu.mapapi.http;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes2.dex */
public class a extends AsyncHttpClient.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HttpClient.ProtoResultCallback f6771a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6772b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AsyncHttpClient f6773c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, String str) {
        super(null);
        this.f6773c = asyncHttpClient;
        this.f6771a = protoResultCallback;
        this.f6772b = str;
    }

    @Override // com.baidu.mapapi.http.AsyncHttpClient.a
    public void a() {
        int i2;
        int i3;
        HttpClient httpClient = new HttpClient("GET", this.f6771a);
        i2 = this.f6773c.f6761a;
        httpClient.setMaxTimeOut(i2);
        i3 = this.f6773c.f6762b;
        httpClient.setReadTimeOut(i3);
        httpClient.request(this.f6772b);
    }
}
