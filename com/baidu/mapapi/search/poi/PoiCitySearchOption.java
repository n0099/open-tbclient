package com.baidu.mapapi.search.poi;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PoiCitySearchOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCity;
    public boolean mIsCityLimit;
    public boolean mIsReturnAddr;
    public String mKeyword;
    public int mPageCapacity;
    public int mPageNum;
    public PoiFilter mPoiFilter;
    public int mScope;
    public String mTag;

    public PoiCitySearchOption() {
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
        this.mCity = null;
        this.mKeyword = null;
        this.mPageNum = 0;
        this.mPageCapacity = 10;
        this.mIsReturnAddr = true;
        this.mTag = "";
        this.mScope = 1;
        this.mIsCityLimit = true;
        this.mPoiFilter = null;
    }

    public PoiCitySearchOption city(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mCity = str;
            return this;
        }
        return (PoiCitySearchOption) invokeL.objValue;
    }

    public PoiCitySearchOption cityLimit(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.mIsCityLimit = z;
            return this;
        }
        return (PoiCitySearchOption) invokeZ.objValue;
    }

    public PoiCitySearchOption isReturnAddr(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.mIsReturnAddr = z;
            return this;
        }
        return (PoiCitySearchOption) invokeZ.objValue;
    }

    public PoiCitySearchOption keyword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.mKeyword = str;
            return this;
        }
        return (PoiCitySearchOption) invokeL.objValue;
    }

    public PoiCitySearchOption pageCapacity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.mPageCapacity = i2;
            return this;
        }
        return (PoiCitySearchOption) invokeI.objValue;
    }

    public PoiCitySearchOption pageNum(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.mPageNum = i2;
            return this;
        }
        return (PoiCitySearchOption) invokeI.objValue;
    }

    public PoiCitySearchOption poiFilter(PoiFilter poiFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, poiFilter)) == null) {
            this.mPoiFilter = poiFilter;
            return this;
        }
        return (PoiCitySearchOption) invokeL.objValue;
    }

    public PoiCitySearchOption scope(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.mScope = i2;
            return this;
        }
        return (PoiCitySearchOption) invokeI.objValue;
    }

    public PoiCitySearchOption tag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.mTag = str;
            return this;
        }
        return (PoiCitySearchOption) invokeL.objValue;
    }
}
