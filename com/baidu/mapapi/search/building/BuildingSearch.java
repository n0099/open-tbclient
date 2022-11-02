package com.baidu.mapapi.search.building;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
import com.baidu.platform.core.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BuildingSearch extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;
    public boolean b;

    public BuildingSearch() {
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
        this.a = new b();
    }

    public static BuildingSearch newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            BMapManager.init();
            return new BuildingSearch();
        }
        return (BuildingSearch) invokeV.objValue;
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

    public boolean requestBuilding(BuildingSearchOption buildingSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buildingSearchOption)) == null) {
            if (this.a != null) {
                if (buildingSearchOption != null && buildingSearchOption.getLatLng() != null) {
                    return this.a.a(buildingSearchOption);
                }
                throw new IllegalStateException("BDMapSDKException: option or location can not be null");
            }
            throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public void setOnGetBuildingSearchResultListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onGetBuildingSearchResultListener) == null) {
            b bVar = this.a;
            if (bVar != null) {
                if (onGetBuildingSearchResultListener != null) {
                    bVar.a(onGetBuildingSearchResultListener);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
            }
            throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance first.");
        }
    }
}
