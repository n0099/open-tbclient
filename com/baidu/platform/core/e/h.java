package com.baidu.platform.core.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h extends com.baidu.platform.base.a implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public OnGetShareUrlResultListener f44313b;

    public h() {
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
        this.f44313b = null;
    }

    @Override // com.baidu.platform.core.e.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f44265a.lock();
            this.f44313b = null;
            this.f44265a.unlock();
        }
    }

    @Override // com.baidu.platform.core.e.a
    public void a(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGetShareUrlResultListener) == null) {
            this.f44265a.lock();
            this.f44313b = onGetShareUrlResultListener;
            this.f44265a.unlock();
        }
    }

    @Override // com.baidu.platform.core.e.a
    public boolean a(LocationShareURLOption locationShareURLOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locationShareURLOption)) == null) {
            f fVar = new f();
            fVar.a(SearchType.r);
            return a(new b(locationShareURLOption), this.f44313b, fVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.e.a
    public boolean a(PoiDetailShareURLOption poiDetailShareURLOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, poiDetailShareURLOption)) == null) {
            f fVar = new f();
            fVar.a(SearchType.q);
            return a(new c(poiDetailShareURLOption), this.f44313b, fVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.e.a
    public boolean a(RouteShareURLOption routeShareURLOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, routeShareURLOption)) == null) {
            d dVar = new d();
            dVar.a(SearchType.s);
            return a(new e(routeShareURLOption), this.f44313b, dVar);
        }
        return invokeL.booleanValue;
    }
}
