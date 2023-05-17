package com.baidu.platform.base;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends HttpClient.ProtoResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ d a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ a c;

    public b(a aVar, d dVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, dVar, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = aVar;
        this.a = dVar;
        this.b = obj;
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onFailed(HttpClient.HttpStateError httpStateError) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, httpStateError) != null) {
            return;
        }
        this.c.a(httpStateError, this.a, this.b);
    }

    @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
    public void onSuccess(String str) {
        boolean c;
        String str2;
        AsyncHttpClient asyncHttpClient;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
            return;
        }
        c = this.c.c(str);
        if (!c) {
            if (!(this.a instanceof com.baidu.platform.core.c.e)) {
                str3 = "";
            } else {
                str3 = this.c.a(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                str2 = str3;
                a aVar = this.c;
                d dVar = this.a;
                Object obj = this.b;
                asyncHttpClient = aVar.b;
                aVar.a(str2, dVar, obj, asyncHttpClient, this);
            }
        }
        str2 = str;
        a aVar2 = this.c;
        d dVar2 = this.a;
        Object obj2 = this.b;
        asyncHttpClient = aVar2.b;
        aVar2.a(str2, dVar2, obj2, asyncHttpClient, this);
    }
}
