package com.baidu.mapapi.search.geocode;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ReverseGeoCodeOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public LatLng c;
    public int d;
    public int e;
    public String f;
    public boolean g;
    public LanguageType h;

    public ReverseGeoCodeOption() {
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
        this.a = 10;
        this.b = 0;
        this.c = null;
        this.d = 1;
        this.e = 1000;
        this.f = null;
        this.g = false;
        this.h = LanguageType.LanguageTypeChinese;
    }

    public ReverseGeoCodeOption extensionsRoad(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.g = z;
            return this;
        }
        return (ReverseGeoCodeOption) invokeZ.objValue;
    }

    public ReverseGeoCodeOption language(LanguageType languageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, languageType)) == null) {
            this.h = languageType;
            return this;
        }
        return (ReverseGeoCodeOption) invokeL.objValue;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, latLng)) == null) {
            this.c = latLng;
            return this;
        }
        return (ReverseGeoCodeOption) invokeL.objValue;
    }

    public ReverseGeoCodeOption newVersion(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.d = i;
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }

    public ReverseGeoCodeOption pageNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            this.b = i;
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (i <= 0) {
                this.a = 10;
            } else if (i > 100) {
                this.a = 100;
            } else {
                this.a = i;
            }
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }

    public ReverseGeoCodeOption poiType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f = str;
            return this;
        }
        return (ReverseGeoCodeOption) invokeL.objValue;
    }

    public ReverseGeoCodeOption radius(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (i < 0) {
                this.e = 0;
            } else if (i > 1000) {
                this.e = 1000;
            } else {
                this.e = i;
            }
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }

    public boolean getExtensionsRoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public LanguageType getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (LanguageType) invokeV.objValue;
    }

    public int getLatestAdmin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (LatLng) invokeV.objValue;
    }

    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int getPageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String getPoiType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public int getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }
}
