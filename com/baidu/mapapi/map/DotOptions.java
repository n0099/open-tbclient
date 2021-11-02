package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class DotOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39323a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39324b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f39325c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f39326d;

    /* renamed from: e  reason: collision with root package name */
    public int f39327e;

    /* renamed from: f  reason: collision with root package name */
    public int f39328f;

    public DotOptions() {
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
        this.f39327e = -16777216;
        this.f39328f = 5;
        this.f39324b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Dot dot = new Dot();
            dot.A = this.f39324b;
            dot.z = this.f39323a;
            dot.B = this.f39325c;
            dot.f39321b = this.f39327e;
            dot.f39320a = this.f39326d;
            dot.f39322c = this.f39328f;
            return dot;
        }
        return (Overlay) invokeV.objValue;
    }

    public DotOptions center(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng)) == null) {
            if (latLng != null) {
                this.f39326d = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
        }
        return (DotOptions) invokeL.objValue;
    }

    public DotOptions color(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f39327e = i2;
            return this;
        }
        return (DotOptions) invokeI.objValue;
    }

    public DotOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            this.f39325c = bundle;
            return this;
        }
        return (DotOptions) invokeL.objValue;
    }

    public LatLng getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39326d : (LatLng) invokeV.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39327e : invokeV.intValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39325c : (Bundle) invokeV.objValue;
    }

    public int getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39328f : invokeV.intValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39323a : invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39324b : invokeV.booleanValue;
    }

    public DotOptions radius(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 > 0) {
                this.f39328f = i2;
            }
            return this;
        }
        return (DotOptions) invokeI.objValue;
    }

    public DotOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.f39324b = z;
            return this;
        }
        return (DotOptions) invokeZ.objValue;
    }

    public DotOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.f39323a = i2;
            return this;
        }
        return (DotOptions) invokeI.objValue;
    }
}
