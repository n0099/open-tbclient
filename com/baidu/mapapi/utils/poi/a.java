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
public final class a implements a.InterfaceC0136a<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7544a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7544a = context;
    }

    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0136a
    public void a(HttpClient.HttpStateError httpStateError) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpStateError) == null) {
            int i2 = b.f7546b[httpStateError.ordinal()];
            if (i2 == 1) {
                str = "current network is not available";
            } else if (i2 != 2) {
                return;
            } else {
                str = "network inner error, please check network";
            }
            Log.d("baidumapsdk", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.platform.comapi.pano.a.InterfaceC0136a
    public void a(c cVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null) {
                Log.d("baidumapsdk", "pano info is null");
                return;
            }
            int i2 = b.f7545a[cVar.a().ordinal()];
            if (i2 == 1) {
                str = "pano uid is error, please check param poi uid";
            } else if (i2 == 2) {
                str = "pano id not found for this poi point";
            } else if (i2 == 3) {
                str = "please check ak for permission";
            } else if (i2 != 4) {
                return;
            } else {
                if (cVar.c() == 1) {
                    try {
                        BaiduMapPoiSearch.b(cVar.b(), this.f7544a);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                str = "this point do not support for pano show";
            }
            Log.d("baidumapsdk", str);
        }
    }
}
