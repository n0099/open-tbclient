package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class Circle extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LatLng a;
    public int b;
    public int c;
    public Stroke d;
    public boolean e;
    public int f;
    public List<HoleOptions> g;
    public HoleOptions h;

    public Circle() {
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
        this.f = 0;
        this.type = com.baidu.mapsdkplatform.comapi.map.i.h;
    }

    public LatLng getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (LatLng) invokeV.objValue;
    }

    public int getDottedStrokeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public HoleOptions getHoleOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (HoleOptions) invokeV.objValue;
    }

    public List<HoleOptions> getHoleOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public int getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public Stroke getStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (Stroke) invokeV.objValue;
    }

    public boolean isDottedStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    private void b(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            if (this.f == 1) {
                str = "CircleDashTexture.png";
            } else {
                str = "lineDashTexture.png";
            }
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (fromAsset != null) {
                bundle.putBundle("image_info", fromAsset.b());
            }
        }
    }

    public void setCenter(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, latLng) == null) {
            if (latLng != null) {
                this.a = latLng;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
        }
    }

    public void setDottedStroke(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.e = z;
            this.listener.c(this);
        }
    }

    public void setDottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, circleDottedStrokeType) == null) {
            this.f = circleDottedStrokeType.ordinal();
            this.listener.c(this);
        }
    }

    public void setFillColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.b = i;
            this.listener.c(this);
        }
    }

    public void setHoleOption(HoleOptions holeOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, holeOptions) == null) {
            this.h = holeOptions;
            this.g = null;
            this.listener.c(this);
        }
    }

    public void setHoleOptions(List<HoleOptions> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.g = list;
            this.h = null;
            this.listener.c(this);
        }
    }

    public void setRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.c = i;
            this.listener.c(this);
        }
    }

    public void setStroke(Stroke stroke) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, stroke) == null) {
            this.d = stroke;
            this.listener.c(this);
        }
    }

    private void c(List<HoleOptions> list, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, list, bundle) == null) {
            Bundle bundle2 = new Bundle();
            boolean b = Overlay.b(list, bundle2);
            bundle.putInt("has_holes", b ? 1 : 0);
            if (b) {
                bundle.putBundle("holes", bundle2);
            }
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.a);
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            if (this.e) {
                bundle.putDouble("dotted_stroke_location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("dotted_stroke_location_y", ll2mc.getLatitudeE6());
                bundle.putInt("has_dotted_stroke", 1);
                b(bundle);
            } else {
                bundle.putInt("has_dotted_stroke", 0);
            }
            bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.a, this.c));
            Overlay.a(this.b, bundle);
            if (this.d == null) {
                bundle.putInt("has_stroke", 0);
            } else {
                bundle.putInt("has_stroke", 1);
                bundle.putBundle("stroke", this.d.a(new Bundle()));
            }
            List<HoleOptions> list = this.g;
            if (list != null && list.size() != 0) {
                c(this.g, bundle);
            } else if (this.h != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.h);
                c((List<HoleOptions>) arrayList, bundle);
            } else {
                bundle.putInt("has_holes", 0);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
