package com.baidu.mapapi.search.poi;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PoiSearch extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.core.c.a f41906a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41907b;

    public PoiSearch() {
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
        this.f41907b = false;
        this.f41906a = new com.baidu.platform.core.c.f();
    }

    public static PoiSearch newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            BMapManager.init();
            return new PoiSearch();
        }
        return (PoiSearch) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41907b) {
            return;
        }
        this.f41907b = true;
        this.f41906a.a();
        BMapManager.destroy();
    }

    public boolean searchInBound(PoiBoundSearchOption poiBoundSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, poiBoundSearchOption)) == null) {
            com.baidu.platform.core.c.a aVar = this.f41906a;
            if (aVar != null) {
                if (poiBoundSearchOption == null || poiBoundSearchOption.mBound == null || poiBoundSearchOption.mKeyword == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or bound or keyworld can not be null");
                }
                return aVar.a(poiBoundSearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        return invokeL.booleanValue;
    }

    public boolean searchInCity(PoiCitySearchOption poiCitySearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, poiCitySearchOption)) == null) {
            com.baidu.platform.core.c.a aVar = this.f41906a;
            if (aVar != null) {
                if (poiCitySearchOption == null || poiCitySearchOption.mCity == null || poiCitySearchOption.mKeyword == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or city or keyworld can not be null");
                }
                return aVar.a(poiCitySearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        return invokeL.booleanValue;
    }

    public boolean searchNearby(PoiNearbySearchOption poiNearbySearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, poiNearbySearchOption)) == null) {
            com.baidu.platform.core.c.a aVar = this.f41906a;
            if (aVar != null) {
                if (poiNearbySearchOption == null || poiNearbySearchOption.mLocation == null || poiNearbySearchOption.mKeyword == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or location or keyworld can not be null");
                }
                if (poiNearbySearchOption.mRadius <= 0) {
                    return false;
                }
                return aVar.a(poiNearbySearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        return invokeL.booleanValue;
    }

    public boolean searchPoiDetail(PoiDetailSearchOption poiDetailSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, poiDetailSearchOption)) == null) {
            if (this.f41906a != null) {
                if (poiDetailSearchOption == null || poiDetailSearchOption.getUid() == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
                }
                return this.f41906a.a(poiDetailSearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        return invokeL.booleanValue;
    }

    public boolean searchPoiIndoor(PoiIndoorOption poiIndoorOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, poiIndoorOption)) == null) {
            com.baidu.platform.core.c.a aVar = this.f41906a;
            if (aVar != null) {
                if (poiIndoorOption == null || poiIndoorOption.bid == null || poiIndoorOption.wd == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or indoor bid or keyword can not be null");
                }
                return aVar.a(poiIndoorOption);
            }
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        return invokeL.booleanValue;
    }

    public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onGetPoiSearchResultListener) == null) {
            com.baidu.platform.core.c.a aVar = this.f41906a;
            if (aVar == null) {
                throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
            }
            if (onGetPoiSearchResultListener == null) {
                throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
            }
            aVar.a(onGetPoiSearchResultListener);
        }
    }
}
