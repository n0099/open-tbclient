package com.baidu.mapapi.search.district;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.platform.core.a.d;
import com.baidu.platform.core.a.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DistrictSearch extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f41855a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41856b;

    public DistrictSearch() {
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
        this.f41855a = null;
        this.f41856b = false;
        this.f41855a = new d();
    }

    public static DistrictSearch newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            BMapManager.init();
            return new DistrictSearch();
        }
        return (DistrictSearch) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41856b) {
            return;
        }
        this.f41856b = true;
        this.f41855a.a();
        BMapManager.destroy();
    }

    public boolean searchDistrict(DistrictSearchOption districtSearchOption) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, districtSearchOption)) == null) {
            if (this.f41855a != null) {
                if (districtSearchOption == null || (str = districtSearchOption.mCityName) == null || str.equals("")) {
                    throw new IllegalArgumentException("BDMapSDKException: option or city name can not be null or empty.");
                }
                return this.f41855a.a(districtSearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        return invokeL.booleanValue;
    }

    public void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onGetDistricSearchResultListener) == null) {
            e eVar = this.f41855a;
            if (eVar == null) {
                throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
            }
            if (onGetDistricSearchResultListener == null) {
                throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
            }
            eVar.a(onGetDistricSearchResultListener);
        }
    }
}
