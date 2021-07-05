package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class ArcOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f6854d = "ArcOptions";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f6855a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6856b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6857c;

    /* renamed from: e  reason: collision with root package name */
    public int f6858e;

    /* renamed from: f  reason: collision with root package name */
    public int f6859f;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f6860g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f6861h;

    /* renamed from: i  reason: collision with root package name */
    public LatLng f6862i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1722967353, "Lcom/baidu/mapapi/map/ArcOptions;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1722967353, "Lcom/baidu/mapapi/map/ArcOptions;");
        }
    }

    public ArcOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6858e = -16777216;
        this.f6859f = 5;
        this.f6856b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Arc arc = new Arc();
            arc.A = this.f6856b;
            arc.z = this.f6855a;
            arc.B = this.f6857c;
            arc.f6849a = this.f6858e;
            arc.f6850b = this.f6859f;
            arc.f6851c = this.f6860g;
            arc.f6852d = this.f6861h;
            arc.f6853e = this.f6862i;
            return arc;
        }
        return (Overlay) invokeV.objValue;
    }

    public ArcOptions color(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f6858e = i2;
            return this;
        }
        return (ArcOptions) invokeI.objValue;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            this.f6857c = bundle;
            return this;
        }
        return (ArcOptions) invokeL.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6858e : invokeV.intValue;
    }

    public LatLng getEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6862i : (LatLng) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6857c : (Bundle) invokeV.objValue;
    }

    public LatLng getMiddlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6861h : (LatLng) invokeV.objValue;
    }

    public LatLng getStartPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6860g : (LatLng) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6859f : invokeV.intValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f6855a : invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f6856b : invokeV.booleanValue;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, latLng, latLng2, latLng3)) == null) {
            if (latLng == null || latLng2 == null || latLng3 == null) {
                throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
            }
            if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
                throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
            }
            this.f6860g = latLng;
            this.f6861h = latLng2;
            this.f6862i = latLng3;
            return this;
        }
        return (ArcOptions) invokeLLL.objValue;
    }

    public ArcOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.f6856b = z;
            return this;
        }
        return (ArcOptions) invokeZ.objValue;
    }

    public ArcOptions width(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 > 0) {
                this.f6859f = i2;
            }
            return this;
        }
        return (ArcOptions) invokeI.objValue;
    }

    public ArcOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f6855a = i2;
            return this;
        }
        return (ArcOptions) invokeI.objValue;
    }
}
