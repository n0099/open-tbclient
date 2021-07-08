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
/* loaded from: classes2.dex */
public final class GroundOverlay extends Overlay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String j = "GroundOverlay";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f6930a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f6931b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6932c;

    /* renamed from: d  reason: collision with root package name */
    public double f6933d;

    /* renamed from: e  reason: collision with root package name */
    public double f6934e;

    /* renamed from: f  reason: collision with root package name */
    public float f6935f;

    /* renamed from: g  reason: collision with root package name */
    public float f6936g;

    /* renamed from: h  reason: collision with root package name */
    public LatLngBounds f6937h;

    /* renamed from: i  reason: collision with root package name */
    public float f6938i;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = com.baidu.mapsdkplatform.comapi.map.h.f7724d;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            bundle.putBundle("image_info", this.f6931b.b());
            if (this.f6930a == 1) {
                GeoPoint ll2mc = CoordUtil.ll2mc(this.f6937h.southwest);
                double longitudeE6 = ll2mc.getLongitudeE6();
                double latitudeE6 = ll2mc.getLatitudeE6();
                GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f6937h.northeast);
                double longitudeE62 = ll2mc2.getLongitudeE6();
                double latitudeE62 = ll2mc2.getLatitudeE6();
                double d2 = longitudeE62 - longitudeE6;
                this.f6933d = d2;
                double d3 = latitudeE62 - latitudeE6;
                this.f6934e = d3;
                this.f6932c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d3 / 2.0d), longitudeE6 + (d2 / 2.0d)));
                this.f6935f = 0.5f;
                this.f6936g = 0.5f;
            }
            double d4 = this.f6933d;
            if (d4 <= 0.0d || this.f6934e <= 0.0d) {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
            }
            bundle.putDouble("x_distance", d4);
            if (this.f6934e == 2.147483647E9d) {
                this.f6934e = (int) ((this.f6933d * this.f6931b.f6898a.getHeight()) / this.f6931b.f6898a.getWidth());
            }
            bundle.putDouble("y_distance", this.f6934e);
            GeoPoint ll2mc3 = CoordUtil.ll2mc(this.f6932c);
            bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
            bundle.putFloat("anchor_x", this.f6935f);
            bundle.putFloat("anchor_y", this.f6936g);
            bundle.putFloat("transparency", this.f6938i);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6935f : invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6936g : invokeV.floatValue;
    }

    public LatLngBounds getBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6937h : (LatLngBounds) invokeV.objValue;
    }

    public double getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6934e : invokeV.doubleValue;
    }

    public BitmapDescriptor getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6931b : (BitmapDescriptor) invokeV.objValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6932c : (LatLng) invokeV.objValue;
    }

    public float getTransparency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6938i : invokeV.floatValue;
    }

    public double getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f6933d : invokeV.doubleValue;
    }

    public void setAnchor(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 < 0.0f || f2 > 1.0f || f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.f6935f = f2;
        this.f6936g = f3;
        this.listener.b(this);
    }

    public void setDimensions(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f6933d = i2;
            this.f6934e = 2.147483647E9d;
            this.listener.b(this);
        }
    }

    public void setDimensions(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            this.f6933d = i2;
            this.f6934e = i3;
            this.listener.b(this);
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bitmapDescriptor) == null) {
            if (bitmapDescriptor == null) {
                throw new IllegalArgumentException("BDMapSDKException: image can not be null");
            }
            this.f6931b = bitmapDescriptor;
            this.listener.b(this);
        }
    }

    public void setPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, latLng) == null) {
            if (latLng == null) {
                throw new IllegalArgumentException("BDMapSDKException: position can not be null");
            }
            this.f6930a = 2;
            this.f6932c = latLng;
            this.listener.b(this);
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, latLngBounds) == null) {
            if (latLngBounds == null) {
                throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
            }
            this.f6930a = 1;
            this.f6937h = latLngBounds;
            this.listener.b(this);
        }
    }

    public void setTransparency(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        this.f6938i = f2;
        this.listener.b(this);
    }
}
