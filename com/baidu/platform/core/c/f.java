package com.baidu.platform.core.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f extends com.baidu.platform.base.a implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public OnGetPoiSearchResultListener f42065b;

    public f() {
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
        this.f42065b = null;
    }

    @Override // com.baidu.platform.core.c.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f42027a.lock();
            this.f42065b = null;
            this.f42027a.unlock();
        }
    }

    @Override // com.baidu.platform.core.c.a
    public void a(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGetPoiSearchResultListener) == null) {
            this.f42027a.lock();
            this.f42065b = onGetPoiSearchResultListener;
            this.f42027a.unlock();
        }
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiBoundSearchOption poiBoundSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, poiBoundSearchOption)) == null) {
            g gVar = new g(poiBoundSearchOption.mPageNum, poiBoundSearchOption.mPageCapacity);
            gVar.a(SearchType.f42020c);
            return a(new i(poiBoundSearchOption), this.f42065b, gVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiCitySearchOption poiCitySearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, poiCitySearchOption)) == null) {
            g gVar = new g(poiCitySearchOption.mPageNum, poiCitySearchOption.mPageCapacity);
            gVar.a(SearchType.f42019b);
            return a(new i(poiCitySearchOption), this.f42065b, gVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiDetailSearchOption poiDetailSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, poiDetailSearchOption)) == null) {
            d dVar = new d();
            if (poiDetailSearchOption != null) {
                dVar.a(poiDetailSearchOption.isSearchByUids());
            }
            dVar.a(SearchType.f42021d);
            return a(new e(poiDetailSearchOption), this.f42065b, dVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiIndoorOption poiIndoorOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, poiIndoorOption)) == null) {
            b bVar = new b();
            bVar.a(SearchType.f42022e);
            return a(new c(poiIndoorOption), this.f42065b, bVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiNearbySearchOption poiNearbySearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, poiNearbySearchOption)) == null) {
            g gVar = new g(poiNearbySearchOption.mPageNum, poiNearbySearchOption.mPageCapacity);
            gVar.a(SearchType.f42018a);
            return a(new i(poiNearbySearchOption), this.f42065b, gVar);
        }
        return invokeL.booleanValue;
    }
}
