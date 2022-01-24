package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class GroundOverlayOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35291b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f35292c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f35293d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f35294e;

    /* renamed from: f  reason: collision with root package name */
    public int f35295f;

    /* renamed from: g  reason: collision with root package name */
    public int f35296g;

    /* renamed from: h  reason: collision with root package name */
    public float f35297h;

    /* renamed from: i  reason: collision with root package name */
    public float f35298i;

    /* renamed from: j  reason: collision with root package name */
    public LatLngBounds f35299j;
    public float k;

    public GroundOverlayOptions() {
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
        this.f35297h = 0.5f;
        this.f35298i = 0.5f;
        this.k = 1.0f;
        this.f35291b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        LatLngBounds latLngBounds;
        int i2;
        LatLng latLng;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GroundOverlay groundOverlay = new GroundOverlay();
            groundOverlay.A = this.f35291b;
            groundOverlay.z = this.a;
            groundOverlay.B = this.f35292c;
            BitmapDescriptor bitmapDescriptor = this.f35293d;
            if (bitmapDescriptor != null) {
                groundOverlay.f35283b = bitmapDescriptor;
                if (this.f35299j == null && (latLng = this.f35294e) != null) {
                    int i4 = this.f35295f;
                    if (i4 <= 0 || (i3 = this.f35296g) <= 0) {
                        throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
                    }
                    groundOverlay.f35284c = latLng;
                    groundOverlay.f35287f = this.f35297h;
                    groundOverlay.f35288g = this.f35298i;
                    groundOverlay.f35285d = i4;
                    groundOverlay.f35286e = i3;
                    i2 = 2;
                } else if (this.f35294e != null || (latLngBounds = this.f35299j) == null) {
                    throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
                } else {
                    groundOverlay.f35289h = latLngBounds;
                    i2 = 1;
                }
                groundOverlay.a = i2;
                groundOverlay.f35290i = this.k;
                return groundOverlay;
            }
            throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
        }
        return (Overlay) invokeV.objValue;
    }

    public GroundOverlayOptions anchor(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f) {
                this.f35297h = f2;
                this.f35298i = f3;
            }
            return this;
        }
        return (GroundOverlayOptions) invokeCommon.objValue;
    }

    public GroundOverlayOptions dimensions(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f35295f = i2;
            this.f35296g = Integer.MAX_VALUE;
            return this;
        }
        return (GroundOverlayOptions) invokeI.objValue;
    }

    public GroundOverlayOptions dimensions(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            this.f35295f = i2;
            this.f35296g = i3;
            return this;
        }
        return (GroundOverlayOptions) invokeII.objValue;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            this.f35292c = bundle;
            return this;
        }
        return (GroundOverlayOptions) invokeL.objValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35297h : invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35298i : invokeV.floatValue;
    }

    public LatLngBounds getBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35299j : (LatLngBounds) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35292c : (Bundle) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f35296g;
            return i2 == Integer.MAX_VALUE ? (int) ((this.f35295f * this.f35293d.a.getHeight()) / this.f35293d.a.getWidth()) : i2;
        }
        return invokeV.intValue;
    }

    public BitmapDescriptor getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f35293d : (BitmapDescriptor) invokeV.objValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35294e : (LatLng) invokeV.objValue;
    }

    public float getTransparency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.floatValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f35295f : invokeV.intValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a : invokeV.intValue;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                this.f35293d = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        return (GroundOverlayOptions) invokeL.objValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f35291b : invokeV.booleanValue;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, latLng)) == null) {
            if (latLng != null) {
                this.f35294e = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        return (GroundOverlayOptions) invokeL.objValue;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, latLngBounds)) == null) {
            if (latLngBounds != null) {
                this.f35299j = latLngBounds;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
        }
        return (GroundOverlayOptions) invokeL.objValue;
    }

    public GroundOverlayOptions transparency(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048595, this, f2)) == null) {
            if (f2 <= 1.0f && f2 >= 0.0f) {
                this.k = f2;
            }
            return this;
        }
        return (GroundOverlayOptions) invokeF.objValue;
    }

    public GroundOverlayOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.f35291b = z;
            return this;
        }
        return (GroundOverlayOptions) invokeZ.objValue;
    }

    public GroundOverlayOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            this.a = i2;
            return this;
        }
        return (GroundOverlayOptions) invokeI.objValue;
    }
}
