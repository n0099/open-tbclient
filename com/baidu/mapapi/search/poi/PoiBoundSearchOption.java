package com.baidu.mapapi.search.poi;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PoiBoundSearchOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LatLngBounds mBound;
    public boolean mIsExtendAdcode;
    public String mKeyword;
    public LanguageType mLanguageType;
    public int mPageCapacity;
    public int mPageNum;
    public PoiFilter mPoiFilter;
    public int mScope;
    public String mTag;

    public PoiBoundSearchOption() {
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
        this.mBound = null;
        this.mIsExtendAdcode = true;
        this.mKeyword = null;
        this.mPageNum = 0;
        this.mPageCapacity = 10;
        this.mTag = "";
        this.mScope = 1;
        this.mPoiFilter = null;
        this.mLanguageType = LanguageType.LanguageTypeChinese;
    }

    public PoiBoundSearchOption bound(LatLngBounds latLngBounds) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, latLngBounds)) == null) {
            this.mBound = latLngBounds;
            return this;
        }
        return (PoiBoundSearchOption) invokeL.objValue;
    }

    public PoiBoundSearchOption extendAdcode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.mIsExtendAdcode = z;
            return this;
        }
        return (PoiBoundSearchOption) invokeZ.objValue;
    }

    public PoiBoundSearchOption keyword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.mKeyword = str;
            return this;
        }
        return (PoiBoundSearchOption) invokeL.objValue;
    }

    public PoiBoundSearchOption language(LanguageType languageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, languageType)) == null) {
            this.mLanguageType = languageType;
            return this;
        }
        return (PoiBoundSearchOption) invokeL.objValue;
    }

    public PoiBoundSearchOption pageCapacity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.mPageCapacity = i;
            return this;
        }
        return (PoiBoundSearchOption) invokeI.objValue;
    }

    public PoiBoundSearchOption pageNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.mPageNum = i;
            return this;
        }
        return (PoiBoundSearchOption) invokeI.objValue;
    }

    public PoiBoundSearchOption poiFilter(PoiFilter poiFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, poiFilter)) == null) {
            this.mPoiFilter = poiFilter;
            return this;
        }
        return (PoiBoundSearchOption) invokeL.objValue;
    }

    public PoiBoundSearchOption scope(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.mScope = i;
            return this;
        }
        return (PoiBoundSearchOption) invokeI.objValue;
    }

    public PoiBoundSearchOption tag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.mTag = str;
            return this;
        }
        return (PoiBoundSearchOption) invokeL.objValue;
    }

    public boolean isExtendAdcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mIsExtendAdcode;
        }
        return invokeV.booleanValue;
    }
}
