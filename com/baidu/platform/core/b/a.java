package com.baidu.platform.core.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends com.baidu.platform.base.a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public OnGetGeoCoderResultListener f28200b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28200b = null;
    }

    @Override // com.baidu.platform.core.b.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.lock();
            this.f28200b = null;
            this.a.unlock();
        }
    }

    @Override // com.baidu.platform.core.b.d
    public void a(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGetGeoCoderResultListener) == null) {
            this.a.lock();
            this.f28200b = onGetGeoCoderResultListener;
            this.a.unlock();
        }
    }

    @Override // com.baidu.platform.core.b.d
    public boolean a(GeoCodeOption geoCodeOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, geoCodeOption)) == null) {
            b bVar = new b();
            com.baidu.platform.base.e cVar = new c(geoCodeOption);
            bVar.a(SearchType.f28176g);
            if (geoCodeOption != null) {
                bVar.b(geoCodeOption.getAddress());
            }
            return a(cVar, this.f28200b, bVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.b.d
    public boolean a(ReverseGeoCodeOption reverseGeoCodeOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, reverseGeoCodeOption)) == null) {
            e eVar = new e();
            f fVar = new f(reverseGeoCodeOption);
            eVar.a(SearchType.f28177h);
            return a(fVar, this.f28200b, eVar);
        }
        return invokeL.booleanValue;
    }
}
