package com.baidu.mapapi.search.sug;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SuggestionSearchOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCity;
    public Boolean mCityLimit;
    public String mKeyword;
    public LatLng mLocation;

    public SuggestionSearchOption() {
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
        this.mLocation = null;
        this.mCityLimit = Boolean.FALSE;
    }

    public SuggestionSearchOption city(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mCity = str;
            return this;
        }
        return (SuggestionSearchOption) invokeL.objValue;
    }

    public SuggestionSearchOption citylimit(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
            this.mCityLimit = bool;
            return this;
        }
        return (SuggestionSearchOption) invokeL.objValue;
    }

    public SuggestionSearchOption keyword(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.mKeyword = str;
            return this;
        }
        return (SuggestionSearchOption) invokeL.objValue;
    }

    public SuggestionSearchOption location(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, latLng)) == null) {
            this.mLocation = latLng;
            return this;
        }
        return (SuggestionSearchOption) invokeL.objValue;
    }
}
