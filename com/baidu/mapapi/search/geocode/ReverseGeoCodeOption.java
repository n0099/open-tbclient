package com.baidu.mapapi.search.geocode;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ReverseGeoCodeOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f7278a;

    /* renamed from: b  reason: collision with root package name */
    public int f7279b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7280c;

    /* renamed from: d  reason: collision with root package name */
    public int f7281d;

    /* renamed from: e  reason: collision with root package name */
    public int f7282e;

    public ReverseGeoCodeOption() {
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
        this.f7278a = 10;
        this.f7279b = 0;
        this.f7280c = null;
        this.f7281d = 0;
        this.f7282e = 1000;
    }

    public int getLatestAdmin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7281d : invokeV.intValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7280c : (LatLng) invokeV.objValue;
    }

    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7279b : invokeV.intValue;
    }

    public int getPageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7278a : invokeV.intValue;
    }

    public int getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7282e : invokeV.intValue;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, latLng)) == null) {
            this.f7280c = latLng;
            return this;
        }
        return (ReverseGeoCodeOption) invokeL.objValue;
    }

    public ReverseGeoCodeOption newVersion(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f7281d = i2;
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }

    public ReverseGeoCodeOption pageNum(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.f7279b = i2;
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }

    public ReverseGeoCodeOption pageSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 <= 0) {
                i2 = 10;
            } else if (i2 > 100) {
                this.f7278a = 100;
                return this;
            }
            this.f7278a = i2;
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }

    public ReverseGeoCodeOption radius(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > 1000) {
                this.f7282e = 1000;
                return this;
            }
            this.f7282e = i2;
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }
}
