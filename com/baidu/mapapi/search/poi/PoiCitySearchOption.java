package com.baidu.mapapi.search.poi;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PoiCitySearchOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCity;
    public boolean mIsCityLimit;
    public boolean mIsExtendAdcode;
    public boolean mIsReturnAddr;
    public String mKeyword;
    public LanguageType mLanguageType;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mIsExtendAdcode = true;
        this.mLanguageType = LanguageType.LanguageTypeChinese;
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

    public PoiCitySearchOption extendAdcode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.mIsExtendAdcode = z;
            return this;
        }
        return (PoiCitySearchOption) invokeZ.objValue;
    }

    public PoiCitySearchOption isReturnAddr(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.mIsReturnAddr = z;
            return this;
        }
        return (PoiCitySearchOption) invokeZ.objValue;
    }

    public PoiCitySearchOption keyword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.mKeyword = str;
            return this;
        }
        return (PoiCitySearchOption) invokeL.objValue;
    }

    public PoiCitySearchOption language(LanguageType languageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, languageType)) == null) {
            this.mLanguageType = languageType;
            return this;
        }
        return (PoiCitySearchOption) invokeL.objValue;
    }

    public PoiCitySearchOption pageCapacity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.mPageCapacity = i;
            return this;
        }
        return (PoiCitySearchOption) invokeI.objValue;
    }

    public PoiCitySearchOption pageNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.mPageNum = i;
            return this;
        }
        return (PoiCitySearchOption) invokeI.objValue;
    }

    public PoiCitySearchOption poiFilter(PoiFilter poiFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, poiFilter)) == null) {
            this.mPoiFilter = poiFilter;
            return this;
        }
        return (PoiCitySearchOption) invokeL.objValue;
    }

    public PoiCitySearchOption scope(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.mScope = i;
            return this;
        }
        return (PoiCitySearchOption) invokeI.objValue;
    }

    public PoiCitySearchOption tag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.mTag = str;
            return this;
        }
        return (PoiCitySearchOption) invokeL.objValue;
    }

    public boolean isExtendAdcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mIsExtendAdcode;
        }
        return invokeV.booleanValue;
    }
}
