package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.a;
import com.baidu.platform.comapi.pano.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class a implements a.InterfaceC0130a<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0130a
    public void a(HttpClient.HttpStateError httpStateError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpStateError) == null) {
            int i = b.b[httpStateError.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    Log.d("baidumapsdk", "network inner error, please check network");
                    return;
                }
                return;
            }
            Log.d("baidumapsdk", "current network is not available");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0130a
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null) {
                Log.d("baidumapsdk", "pano info is null");
                return;
            }
            int i = b.a[cVar.a().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (cVar.c() == 1) {
                                try {
                                    BaiduMapPoiSearch.b(cVar.b(), this.a);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            Log.d("baidumapsdk", "this point do not support for pano show");
                            return;
                        }
                        return;
                    }
                    Log.d("baidumapsdk", "please check ak for permission");
                    return;
                }
                Log.d("baidumapsdk", "pano id not found for this poi point");
                return;
            }
            Log.d("baidumapsdk", "pano uid is error, please check param poi uid");
        }
    }
}
