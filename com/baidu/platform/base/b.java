package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends HttpClient.ProtoResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f44271a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f44272b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f44273c;

    public b(a aVar, d dVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, dVar, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44273c = aVar;
        this.f44271a = dVar;
        this.f44272b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpStateError) == null) {
            this.f44273c.a(httpStateError, this.f44271a, this.f44272b);
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        AsyncHttpClient asyncHttpClient;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String a2 = this.f44271a instanceof com.baidu.platform.core.b.e ? this.f44273c.a(str) : "";
            String str2 = !TextUtils.isEmpty(a2) ? a2 : str;
            this.f44273c.c(str2);
            a aVar = this.f44273c;
            d dVar = this.f44271a;
            Object obj = this.f44272b;
            asyncHttpClient = aVar.f44266b;
            aVar.a(str2, dVar, obj, asyncHttpClient, this);
        }
    }
}
