package com.baidu.mapapi.search.geocode;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ReverseGeoCodeOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f34178b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f34179c;

    /* renamed from: d  reason: collision with root package name */
    public int f34180d;

    /* renamed from: e  reason: collision with root package name */
    public int f34181e;

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
        this.a = 10;
        this.f34178b = 0;
        this.f34179c = null;
        this.f34180d = 0;
        this.f34181e = 1000;
    }

    public int getLatestAdmin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34180d : invokeV.intValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34179c : (LatLng) invokeV.objValue;
    }

    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34178b : invokeV.intValue;
    }

    public int getPageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public int getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34181e : invokeV.intValue;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, latLng)) == null) {
            this.f34179c = latLng;
            return this;
        }
        return (ReverseGeoCodeOption) invokeL.objValue;
    }

    public ReverseGeoCodeOption newVersion(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f34180d = i2;
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
            this.f34178b = i2;
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
                this.a = 100;
                return this;
            }
            this.a = i2;
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
                this.f34181e = 1000;
                return this;
            }
            this.f34181e = i2;
            return this;
        }
        return (ReverseGeoCodeOption) invokeI.objValue;
    }
}
