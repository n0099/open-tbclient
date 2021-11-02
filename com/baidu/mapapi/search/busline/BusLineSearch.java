package com.baidu.mapapi.search.busline;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.platform.core.busline.IBusLineSearch;
import com.baidu.platform.core.busline.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BusLineSearch extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IBusLineSearch f39640a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39641b;

    public BusLineSearch() {
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
        this.f39641b = false;
        this.f39640a = new c();
    }

    public static BusLineSearch newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            BMapManager.init();
            return new BusLineSearch();
        }
        return (BusLineSearch) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f39641b) {
            return;
        }
        this.f39641b = true;
        this.f39640a.a();
        BMapManager.destroy();
    }

    public boolean searchBusLine(BusLineSearchOption busLineSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, busLineSearchOption)) == null) {
            IBusLineSearch iBusLineSearch = this.f39640a;
            if (iBusLineSearch != null) {
                if (busLineSearchOption == null || busLineSearchOption.mCity == null || busLineSearchOption.mUid == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or city or uid can not be null");
                }
                return iBusLineSearch.a(busLineSearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        return invokeL.booleanValue;
    }

    public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onGetBusLineSearchResultListener) == null) {
            IBusLineSearch iBusLineSearch = this.f39640a;
            if (iBusLineSearch == null) {
                throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
            }
            if (onGetBusLineSearchResultListener == null) {
                throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
            }
            iBusLineSearch.a(onGetBusLineSearchResultListener);
        }
    }
}
