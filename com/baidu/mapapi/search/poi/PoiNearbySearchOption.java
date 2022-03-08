package com.baidu.mapapi.search.poi;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PoiNearbySearchOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mKeyword;
    public LatLng mLocation;
    public int mPageCapacity;
    public int mPageNum;
    public PoiFilter mPoiFilter;
    public int mRadius;
    public boolean mRadiusLimit;
    public int mScope;
    public String mTag;
    public PoiSortType sortType;

    public PoiNearbySearchOption() {
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
        this.mKeyword = null;
        this.mLocation = null;
        this.mRadius = -1;
        this.mPageNum = 0;
        this.mPageCapacity = 10;
        this.sortType = PoiSortType.comprehensive;
        this.mTag = "";
        this.mScope = 1;
        this.mRadiusLimit = false;
        this.mPoiFilter = null;
    }

    public PoiNearbySearchOption keyword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mKeyword = str;
            return this;
        }
        return (PoiNearbySearchOption) invokeL.objValue;
    }

    public PoiNearbySearchOption location(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng)) == null) {
            this.mLocation = latLng;
            return this;
        }
        return (PoiNearbySearchOption) invokeL.objValue;
    }

    public PoiNearbySearchOption pageCapacity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.mPageCapacity = i2;
            return this;
        }
        return (PoiNearbySearchOption) invokeI.objValue;
    }

    public PoiNearbySearchOption pageNum(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.mPageNum = i2;
            return this;
        }
        return (PoiNearbySearchOption) invokeI.objValue;
    }

    public PoiNearbySearchOption poiFilter(PoiFilter poiFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, poiFilter)) == null) {
            this.mPoiFilter = poiFilter;
            return this;
        }
        return (PoiNearbySearchOption) invokeL.objValue;
    }

    public PoiNearbySearchOption radius(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.mRadius = i2;
            return this;
        }
        return (PoiNearbySearchOption) invokeI.objValue;
    }

    public PoiNearbySearchOption radiusLimit(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.mRadiusLimit = z;
            return this;
        }
        return (PoiNearbySearchOption) invokeZ.objValue;
    }

    public PoiNearbySearchOption scope(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.mScope = i2;
            return this;
        }
        return (PoiNearbySearchOption) invokeI.objValue;
    }

    public PoiNearbySearchOption sortType(PoiSortType poiSortType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, poiSortType)) == null) {
            if (poiSortType != null) {
                this.sortType = poiSortType;
            }
            return this;
        }
        return (PoiNearbySearchOption) invokeL.objValue;
    }

    public PoiNearbySearchOption tag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.mTag = str;
            return this;
        }
        return (PoiNearbySearchOption) invokeL.objValue;
    }
}
