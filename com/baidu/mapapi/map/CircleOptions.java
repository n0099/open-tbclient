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
import java.util.List;
/* loaded from: classes2.dex */
public final class CircleOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "CircleOptions";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public Bundle c;
    public LatLng e;
    public int f;
    public int g;
    public Stroke h;
    public boolean i;
    public int j;
    public List<HoleOptions> k;
    public HoleOptions l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1725873501, "Lcom/baidu/mapapi/map/CircleOptions;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1725873501, "Lcom/baidu/mapapi/map/CircleOptions;");
        }
    }

    public CircleOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = -16777216;
        this.i = false;
        this.j = 0;
        this.b = true;
    }

    public LatLng getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (LatLng) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (Bundle) invokeV.objValue;
    }

    public int getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public Stroke getStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h;
        }
        return (Stroke) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Circle circle = new Circle();
            circle.H = this.b;
            circle.G = this.a;
            circle.I = this.c;
            circle.b = this.f;
            circle.a = this.e;
            circle.c = this.g;
            circle.d = this.h;
            circle.e = this.i;
            circle.f = this.j;
            circle.g = this.k;
            circle.h = this.l;
            return circle;
        }
        return (Overlay) invokeV.objValue;
    }

    public CircleOptions addHoleOption(HoleOptions holeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, holeOptions)) == null) {
            this.l = holeOptions;
            return this;
        }
        return (CircleOptions) invokeL.objValue;
    }

    public CircleOptions addHoleOptions(List<HoleOptions> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            this.k = list;
            return this;
        }
        return (CircleOptions) invokeL.objValue;
    }

    public CircleOptions center(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, latLng)) == null) {
            if (latLng != null) {
                this.e = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
        }
        return (CircleOptions) invokeL.objValue;
    }

    public CircleOptions dottedStroke(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (CircleOptions) invokeZ.objValue;
    }

    public CircleOptions dottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, circleDottedStrokeType)) == null) {
            this.j = circleDottedStrokeType.ordinal();
            return this;
        }
        return (CircleOptions) invokeL.objValue;
    }

    public CircleOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundle)) == null) {
            this.c = bundle;
            return this;
        }
        return (CircleOptions) invokeL.objValue;
    }

    public CircleOptions fillColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.f = i;
            return this;
        }
        return (CircleOptions) invokeI.objValue;
    }

    public CircleOptions radius(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            this.g = i;
            return this;
        }
        return (CircleOptions) invokeI.objValue;
    }

    public CircleOptions stroke(Stroke stroke) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, stroke)) == null) {
            this.h = stroke;
            return this;
        }
        return (CircleOptions) invokeL.objValue;
    }

    public CircleOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.b = z;
            return this;
        }
        return (CircleOptions) invokeZ.objValue;
    }

    public CircleOptions zIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (CircleOptions) invokeI.objValue;
    }
}
