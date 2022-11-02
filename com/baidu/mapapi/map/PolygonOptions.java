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
import java.util.List;
/* loaded from: classes2.dex */
public final class PolygonOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public Bundle c;
    public Stroke d;
    public int e;
    public List<LatLng> f;
    public List<HoleOptions> g;
    public HoleOptions h;
    public boolean i;
    public String j;
    public EncodePointType k;
    public int l;

    public PolygonOptions() {
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
        this.e = -16777216;
        this.i = false;
        this.l = 0;
        this.b = true;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (Bundle) invokeV.objValue;
    }

    public int getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public Stroke getStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return (Stroke) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Polygon polygon = new Polygon();
            polygon.H = this.b;
            polygon.G = this.a;
            polygon.I = this.c;
            List<LatLng> list = this.f;
            if (list == null || list.size() < 2) {
                String str = this.j;
                if (str != null && str.length() > 0) {
                    polygon.g = this.j;
                    polygon.h = this.k;
                } else {
                    throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
                }
            }
            polygon.c = this.f;
            polygon.b = this.e;
            polygon.a = this.d;
            polygon.d = this.g;
            polygon.e = this.h;
            polygon.f = this.i;
            polygon.i = this.l;
            return polygon;
        }
        return (Overlay) invokeV.objValue;
    }

    public PolygonOptions addHoleOption(HoleOptions holeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, holeOptions)) == null) {
            this.h = holeOptions;
            return this;
        }
        return (PolygonOptions) invokeL.objValue;
    }

    public PolygonOptions addHoleOptions(List<HoleOptions> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            this.g = list;
            return this;
        }
        return (PolygonOptions) invokeL.objValue;
    }

    public PolygonOptions dottedStroke(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (PolygonOptions) invokeZ.objValue;
    }

    public PolygonOptions dottedStrokeType(PolylineDottedLineType polylineDottedLineType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, polylineDottedLineType)) == null) {
            this.l = polylineDottedLineType.ordinal();
            return this;
        }
        return (PolygonOptions) invokeL.objValue;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bundle)) == null) {
            this.c = bundle;
            return this;
        }
        return (PolygonOptions) invokeL.objValue;
    }

    public PolygonOptions fillColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.e = i;
            return this;
        }
        return (PolygonOptions) invokeI.objValue;
    }

    public PolygonOptions stroke(Stroke stroke) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, stroke)) == null) {
            this.d = stroke;
            return this;
        }
        return (PolygonOptions) invokeL.objValue;
    }

    public PolygonOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            this.b = z;
            return this;
        }
        return (PolygonOptions) invokeZ.objValue;
    }

    public PolygonOptions zIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.a = i;
            return this;
        }
        return (PolygonOptions) invokeI.objValue;
    }

    public PolygonOptions points(String str, EncodePointType encodePointType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, encodePointType)) == null) {
            this.j = str;
            this.k = encodePointType;
            return this;
        }
        return (PolygonOptions) invokeLL.objValue;
    }

    public PolygonOptions points(List<LatLng> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (list != null) {
                if (list.size() > 2) {
                    if (!list.contains(null)) {
                        int i = 0;
                        while (i < list.size()) {
                            int i2 = i + 1;
                            for (int i3 = i2; i3 < list.size(); i3++) {
                                if (list.get(i) == list.get(i3)) {
                                    throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                                }
                            }
                            i = i2;
                        }
                        this.f = list;
                        return this;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        return (PolygonOptions) invokeL.objValue;
    }
}
