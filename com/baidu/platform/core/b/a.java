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
/* loaded from: classes2.dex */
public class a extends com.baidu.platform.base.a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public OnGetGeoCoderResultListener f9426b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9426b = null;
    }

    @Override // com.baidu.platform.core.b.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9394a.lock();
            this.f9426b = null;
            this.f9394a.unlock();
        }
    }

    @Override // com.baidu.platform.core.b.d
    public void a(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGetGeoCoderResultListener) == null) {
            this.f9394a.lock();
            this.f9426b = onGetGeoCoderResultListener;
            this.f9394a.unlock();
        }
    }

    @Override // com.baidu.platform.core.b.d
    public boolean a(GeoCodeOption geoCodeOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, geoCodeOption)) == null) {
            b bVar = new b();
            com.baidu.platform.base.e cVar = new c(geoCodeOption);
            bVar.a(SearchType.f9391g);
            if (geoCodeOption != null) {
                bVar.b(geoCodeOption.getAddress());
            }
            return a(cVar, this.f9426b, bVar);
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
            eVar.a(SearchType.f9392h);
            return a(fVar, this.f9426b, eVar);
        }
        return invokeL.booleanValue;
    }
}
