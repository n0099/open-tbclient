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
    public boolean f36303b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f36304c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f36305d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f36306e;

    /* renamed from: f  reason: collision with root package name */
    public int f36307f;

    /* renamed from: g  reason: collision with root package name */
    public int f36308g;

    /* renamed from: h  reason: collision with root package name */
    public float f36309h;

    /* renamed from: i  reason: collision with root package name */
    public float f36310i;

    /* renamed from: j  reason: collision with root package name */
    public LatLngBounds f36311j;

    /* renamed from: k  reason: collision with root package name */
    public float f36312k;

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
        this.f36309h = 0.5f;
        this.f36310i = 0.5f;
        this.f36312k = 1.0f;
        this.f36303b = true;
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
            groundOverlay.A = this.f36303b;
            groundOverlay.z = this.a;
            groundOverlay.B = this.f36304c;
            BitmapDescriptor bitmapDescriptor = this.f36305d;
            if (bitmapDescriptor != null) {
                groundOverlay.f36295b = bitmapDescriptor;
                if (this.f36311j == null && (latLng = this.f36306e) != null) {
                    int i4 = this.f36307f;
                    if (i4 <= 0 || (i3 = this.f36308g) <= 0) {
                        throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
                    }
                    groundOverlay.f36296c = latLng;
                    groundOverlay.f36299f = this.f36309h;
                    groundOverlay.f36300g = this.f36310i;
                    groundOverlay.f36297d = i4;
                    groundOverlay.f36298e = i3;
                    i2 = 2;
                } else if (this.f36306e != null || (latLngBounds = this.f36311j) == null) {
                    throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
                } else {
                    groundOverlay.f36301h = latLngBounds;
                    i2 = 1;
                }
                groundOverlay.a = i2;
                groundOverlay.f36302i = this.f36312k;
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
                this.f36309h = f2;
                this.f36310i = f3;
            }
            return this;
        }
        return (GroundOverlayOptions) invokeCommon.objValue;
    }

    public GroundOverlayOptions dimensions(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f36307f = i2;
            this.f36308g = Integer.MAX_VALUE;
            return this;
        }
        return (GroundOverlayOptions) invokeI.objValue;
    }

    public GroundOverlayOptions dimensions(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            this.f36307f = i2;
            this.f36308g = i3;
            return this;
        }
        return (GroundOverlayOptions) invokeII.objValue;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            this.f36304c = bundle;
            return this;
        }
        return (GroundOverlayOptions) invokeL.objValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36309h : invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36310i : invokeV.floatValue;
    }

    public LatLngBounds getBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36311j : (LatLngBounds) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36304c : (Bundle) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f36308g;
            return i2 == Integer.MAX_VALUE ? (int) ((this.f36307f * this.f36305d.a.getHeight()) / this.f36305d.a.getWidth()) : i2;
        }
        return invokeV.intValue;
    }

    public BitmapDescriptor getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f36305d : (BitmapDescriptor) invokeV.objValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f36306e : (LatLng) invokeV.objValue;
    }

    public float getTransparency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36312k : invokeV.floatValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f36307f : invokeV.intValue;
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
                this.f36305d = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        return (GroundOverlayOptions) invokeL.objValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36303b : invokeV.booleanValue;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, latLng)) == null) {
            if (latLng != null) {
                this.f36306e = latLng;
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
                this.f36311j = latLngBounds;
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
                this.f36312k = f2;
            }
            return this;
        }
        return (GroundOverlayOptions) invokeF.objValue;
    }

    public GroundOverlayOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.f36303b = z;
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
