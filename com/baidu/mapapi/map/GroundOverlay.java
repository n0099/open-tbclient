package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class GroundOverlay extends Overlay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String j = "GroundOverlay";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f26160b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f26161c;

    /* renamed from: d  reason: collision with root package name */
    public double f26162d;

    /* renamed from: e  reason: collision with root package name */
    public double f26163e;

    /* renamed from: f  reason: collision with root package name */
    public float f26164f;

    /* renamed from: g  reason: collision with root package name */
    public float f26165g;

    /* renamed from: h  reason: collision with root package name */
    public LatLngBounds f26166h;
    public float i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1556852968, "Lcom/baidu/mapapi/map/GroundOverlay;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1556852968, "Lcom/baidu/mapapi/map/GroundOverlay;");
        }
    }

    public GroundOverlay() {
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
        this.type = com.baidu.mapsdkplatform.comapi.map.h.f26712d;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            bundle.putBundle("image_info", this.f26160b.b());
            if (this.a == 1) {
                GeoPoint ll2mc = CoordUtil.ll2mc(this.f26166h.southwest);
                double longitudeE6 = ll2mc.getLongitudeE6();
                double latitudeE6 = ll2mc.getLatitudeE6();
                GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f26166h.northeast);
                double longitudeE62 = ll2mc2.getLongitudeE6();
                double latitudeE62 = ll2mc2.getLatitudeE6();
                double d2 = longitudeE62 - longitudeE6;
                this.f26162d = d2;
                double d3 = latitudeE62 - latitudeE6;
                this.f26163e = d3;
                this.f26161c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d3 / 2.0d), longitudeE6 + (d2 / 2.0d)));
                this.f26164f = 0.5f;
                this.f26165g = 0.5f;
            }
            double d4 = this.f26162d;
            if (d4 <= 0.0d || this.f26163e <= 0.0d) {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
            }
            bundle.putDouble("x_distance", d4);
            if (this.f26163e == 2.147483647E9d) {
                this.f26163e = (int) ((this.f26162d * this.f26160b.a.getHeight()) / this.f26160b.a.getWidth());
            }
            bundle.putDouble("y_distance", this.f26163e);
            GeoPoint ll2mc3 = CoordUtil.ll2mc(this.f26161c);
            bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
            bundle.putFloat("anchor_x", this.f26164f);
            bundle.putFloat("anchor_y", this.f26165g);
            bundle.putFloat("transparency", this.i);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26164f : invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26165g : invokeV.floatValue;
    }

    public LatLngBounds getBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26166h : (LatLngBounds) invokeV.objValue;
    }

    public double getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26163e : invokeV.doubleValue;
    }

    public BitmapDescriptor getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26160b : (BitmapDescriptor) invokeV.objValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26161c : (LatLng) invokeV.objValue;
    }

    public float getTransparency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : invokeV.floatValue;
    }

    public double getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26162d : invokeV.doubleValue;
    }

    public void setAnchor(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 < 0.0f || f2 > 1.0f || f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.f26164f = f2;
        this.f26165g = f3;
        this.listener.b(this);
    }

    public void setDimensions(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f26162d = i;
            this.f26163e = 2.147483647E9d;
            this.listener.b(this);
        }
    }

    public void setDimensions(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            this.f26162d = i;
            this.f26163e = i2;
            this.listener.b(this);
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bitmapDescriptor) == null) {
            if (bitmapDescriptor == null) {
                throw new IllegalArgumentException("BDMapSDKException: image can not be null");
            }
            this.f26160b = bitmapDescriptor;
            this.listener.b(this);
        }
    }

    public void setPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, latLng) == null) {
            if (latLng == null) {
                throw new IllegalArgumentException("BDMapSDKException: position can not be null");
            }
            this.a = 2;
            this.f26161c = latLng;
            this.listener.b(this);
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, latLngBounds) == null) {
            if (latLngBounds == null) {
                throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
            }
            this.a = 1;
            this.f26166h = latLngBounds;
            this.listener.b(this);
        }
    }

    public void setTransparency(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        this.i = f2;
        this.listener.b(this);
    }
}
