package com.baidu.mapapi.http;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends AsyncHttpClient.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HttpClient.ProtoResultCallback f6861a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6862b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AsyncHttpClient f6863c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, String str) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {asyncHttpClient, protoResultCallback, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6863c = asyncHttpClient;
        this.f6861a = protoResultCallback;
        this.f6862b = str;
    }

    @Override // com.baidu.mapapi.http.AsyncHttpClient.a
    public void a() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpClient httpClient = new HttpClient("GET", this.f6861a);
            i2 = this.f6863c.f6851a;
            httpClient.setMaxTimeOut(i2);
            i3 = this.f6863c.f6852b;
            httpClient.setReadTimeOut(i3);
            httpClient.request(this.f6862b);
        }
    }
}
