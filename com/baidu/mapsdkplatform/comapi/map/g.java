package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.map.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g extends HttpClient.ProtoResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f.a c;
    public final /* synthetic */ f d;

    public g(f fVar, Context context, String str, f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, context, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = fVar;
        this.a = context;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        String a;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, httpStateError) != null) {
            return;
        }
        a = this.d.a(this.a, this.b);
        a2 = this.d.a(a);
        if (!a2) {
            a = null;
        }
        f.a aVar = this.c;
        if (aVar != null) {
            aVar.a(httpStateError.ordinal(), httpStateError.name(), a);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b a3 = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
            a3.a("CustomMap failed error = " + httpStateError.ordinal());
        }
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
            return;
        }
        this.d.b(this.a, str, this.b, this.c);
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b a = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
            a.a("CustomMap result = " + str);
        }
    }
}
