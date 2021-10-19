package com.baidu.platform.comapi.pano;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends HttpClient.ProtoResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC1693a f44289a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f44290b;

    public b(a aVar, a.InterfaceC1693a interfaceC1693a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, interfaceC1693a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44290b = aVar;
        this.f44289a = interfaceC1693a;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpStateError) == null) {
            this.f44289a.a(httpStateError);
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            a.InterfaceC1693a interfaceC1693a = this.f44289a;
            a2 = this.f44290b.a(str);
            interfaceC1693a.a((a.InterfaceC1693a) a2);
        }
    }
}
