package com.baidu.mapapi.search.share;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.core.g.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ShareUrlSearch extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.platform.core.g.a a;
    public boolean b;

    public ShareUrlSearch() {
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
        this.b = false;
        this.a = new h();
    }

    public static ShareUrlSearch newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            BMapManager.init();
            return new ShareUrlSearch();
        }
        return (ShareUrlSearch) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b) {
            return;
        }
        this.b = true;
        this.a.a();
        BMapManager.destroy();
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, poiDetailShareURLOption)) == null) {
            com.baidu.platform.core.g.a aVar = this.a;
            if (aVar != null) {
                if (poiDetailShareURLOption != null && poiDetailShareURLOption.mUid != null) {
                    return aVar.a(poiDetailShareURLOption);
                }
                throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
            }
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        return invokeL.booleanValue;
    }

    public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onGetShareUrlResultListener) == null) {
            com.baidu.platform.core.g.a aVar = this.a;
            if (aVar != null) {
                if (onGetShareUrlResultListener != null) {
                    aVar.a(onGetShareUrlResultListener);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
            }
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
    }

    public boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationShareURLOption)) == null) {
            com.baidu.platform.core.g.a aVar = this.a;
            if (aVar != null) {
                if (locationShareURLOption != null && locationShareURLOption.mLocation != null && locationShareURLOption.mName != null && locationShareURLOption.mSnippet != null) {
                    return aVar.a(locationShareURLOption);
                }
                throw new IllegalArgumentException("BDMapSDKException: option or name or snippet  can not be null");
            }
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        return invokeL.booleanValue;
    }

    public boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, routeShareURLOption)) == null) {
            if (this.a != null) {
                if (routeShareURLOption != null) {
                    if (routeShareURLOption.getmMode().ordinal() < 0) {
                        return false;
                    }
                    PlanNode planNode = routeShareURLOption.mFrom;
                    if (planNode != null && routeShareURLOption.mTo != null) {
                        if (routeShareURLOption.mMode == RouteShareURLOption.RouteShareMode.BUS_ROUTE_SHARE_MODE) {
                            if ((planNode.getLocation() == null || routeShareURLOption.mTo.getLocation() == null) && routeShareURLOption.mCityCode < 0) {
                                throw new IllegalArgumentException("BDMapSDKException: city code can not be null if don't set start or end point");
                            }
                        } else if (planNode.getLocation() == null && !a(routeShareURLOption.mFrom.getCity())) {
                            throw new IllegalArgumentException("BDMapSDKException: start cityCode must be set if not set start location");
                        } else {
                            if (routeShareURLOption.mTo.getLocation() == null && !a(routeShareURLOption.mTo.getCity())) {
                                throw new IllegalArgumentException("BDMapSDKException: end cityCode must be set if not set end location");
                            }
                        }
                        return this.a.a(routeShareURLOption);
                    }
                    throw new IllegalArgumentException("BDMapSDKException: start or end point can not be null");
                }
                throw new IllegalArgumentException("BDMapSDKException: option is null");
            }
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        return invokeL.booleanValue;
    }
}
