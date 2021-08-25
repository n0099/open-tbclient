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
/* loaded from: classes5.dex */
public final class ArcOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f41244d = "ArcOptions";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41245a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41246b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f41247c;

    /* renamed from: e  reason: collision with root package name */
    public int f41248e;

    /* renamed from: f  reason: collision with root package name */
    public int f41249f;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f41250g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f41251h;

    /* renamed from: i  reason: collision with root package name */
    public LatLng f41252i;

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
        this.f41248e = -16777216;
        this.f41249f = 5;
        this.f41246b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Arc arc = new Arc();
            arc.A = this.f41246b;
            arc.z = this.f41245a;
            arc.B = this.f41247c;
            arc.f41239a = this.f41248e;
            arc.f41240b = this.f41249f;
            arc.f41241c = this.f41250g;
            arc.f41242d = this.f41251h;
            arc.f41243e = this.f41252i;
            return arc;
        }
        return (Overlay) invokeV.objValue;
    }

    public ArcOptions color(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f41248e = i2;
            return this;
        }
        return (ArcOptions) invokeI.objValue;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            this.f41247c = bundle;
            return this;
        }
        return (ArcOptions) invokeL.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41248e : invokeV.intValue;
    }

    public LatLng getEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41252i : (LatLng) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41247c : (Bundle) invokeV.objValue;
    }

    public LatLng getMiddlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41251h : (LatLng) invokeV.objValue;
    }

    public LatLng getStartPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41250g : (LatLng) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f41249f : invokeV.intValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f41245a : invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f41246b : invokeV.booleanValue;
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
            this.f41250g = latLng;
            this.f41251h = latLng2;
            this.f41252i = latLng3;
            return this;
        }
        return (ArcOptions) invokeLLL.objValue;
    }

    public ArcOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.f41246b = z;
            return this;
        }
        return (ArcOptions) invokeZ.objValue;
    }

    public ArcOptions width(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 > 0) {
                this.f41249f = i2;
            }
            return this;
        }
        return (ArcOptions) invokeI.objValue;
    }

    public ArcOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f41245a = i2;
            return this;
        }
        return (ArcOptions) invokeI.objValue;
    }
}
