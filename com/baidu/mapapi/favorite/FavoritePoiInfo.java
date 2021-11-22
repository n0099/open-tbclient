package com.baidu.mapapi.favorite;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FavoritePoiInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f40082a;

    /* renamed from: b  reason: collision with root package name */
    public String f40083b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f40084c;

    /* renamed from: d  reason: collision with root package name */
    public String f40085d;

    /* renamed from: e  reason: collision with root package name */
    public String f40086e;

    /* renamed from: f  reason: collision with root package name */
    public String f40087f;

    /* renamed from: g  reason: collision with root package name */
    public long f40088g;

    public FavoritePoiInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public FavoritePoiInfo addr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f40085d = str;
            return this;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public FavoritePoiInfo cityName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f40086e = str;
            return this;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public String getAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40085d : (String) invokeV.objValue;
    }

    public String getCityName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40086e : (String) invokeV.objValue;
    }

    public String getID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40082a : (String) invokeV.objValue;
    }

    public String getPoiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40083b : (String) invokeV.objValue;
    }

    public LatLng getPt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40084c : (LatLng) invokeV.objValue;
    }

    public long getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f40088g : invokeV.longValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40087f : (String) invokeV.objValue;
    }

    public FavoritePoiInfo poiName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f40083b = str;
            return this;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, latLng)) == null) {
            this.f40084c = latLng;
            return this;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }

    public FavoritePoiInfo uid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f40087f = str;
            return this;
        }
        return (FavoritePoiInfo) invokeL.objValue;
    }
}
