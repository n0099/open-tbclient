package com.baidu.mapapi.search.poi;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLngBounds;
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
    public String mKeyword;
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
        this.mKeyword = null;
        this.mPageNum = 0;
        this.mPageCapacity = 10;
        this.mTag = "";
        this.mScope = 1;
        this.mPoiFilter = null;
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

    public PoiBoundSearchOption keyword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.mKeyword = str;
            return this;
        }
        return (PoiBoundSearchOption) invokeL.objValue;
    }

    public PoiBoundSearchOption pageCapacity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.mPageCapacity = i;
            return this;
        }
        return (PoiBoundSearchOption) invokeI.objValue;
    }

    public PoiBoundSearchOption pageNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.mPageNum = i;
            return this;
        }
        return (PoiBoundSearchOption) invokeI.objValue;
    }

    public PoiBoundSearchOption poiFilter(PoiFilter poiFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, poiFilter)) == null) {
            this.mPoiFilter = poiFilter;
            return this;
        }
        return (PoiBoundSearchOption) invokeL.objValue;
    }

    public PoiBoundSearchOption scope(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.mScope = i;
            return this;
        }
        return (PoiBoundSearchOption) invokeI.objValue;
    }

    public PoiBoundSearchOption tag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.mTag = str;
            return this;
        }
        return (PoiBoundSearchOption) invokeL.objValue;
    }
}
