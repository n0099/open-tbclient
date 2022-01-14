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
    public boolean f35263b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f35264c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f35265d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f35266e;

    /* renamed from: f  reason: collision with root package name */
    public int f35267f;

    /* renamed from: g  reason: collision with root package name */
    public int f35268g;

    /* renamed from: h  reason: collision with root package name */
    public float f35269h;

    /* renamed from: i  reason: collision with root package name */
    public float f35270i;

    /* renamed from: j  reason: collision with root package name */
    public LatLngBounds f35271j;
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
        this.f35269h = 0.5f;
        this.f35270i = 0.5f;
        this.k = 1.0f;
        this.f35263b = true;
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
            groundOverlay.A = this.f35263b;
            groundOverlay.z = this.a;
            groundOverlay.B = this.f35264c;
            BitmapDescriptor bitmapDescriptor = this.f35265d;
            if (bitmapDescriptor != null) {
                groundOverlay.f35255b = bitmapDescriptor;
                if (this.f35271j == null && (latLng = this.f35266e) != null) {
                    int i4 = this.f35267f;
                    if (i4 <= 0 || (i3 = this.f35268g) <= 0) {
                        throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
                    }
                    groundOverlay.f35256c = latLng;
                    groundOverlay.f35259f = this.f35269h;
                    groundOverlay.f35260g = this.f35270i;
                    groundOverlay.f35257d = i4;
                    groundOverlay.f35258e = i3;
                    i2 = 2;
                } else if (this.f35266e != null || (latLngBounds = this.f35271j) == null) {
                    throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
                } else {
                    groundOverlay.f35261h = latLngBounds;
                    i2 = 1;
                }
                groundOverlay.a = i2;
                groundOverlay.f35262i = this.k;
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
                this.f35269h = f2;
                this.f35270i = f3;
            }
            return this;
        }
        return (GroundOverlayOptions) invokeCommon.objValue;
    }

    public GroundOverlayOptions dimensions(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f35267f = i2;
            this.f35268g = Integer.MAX_VALUE;
            return this;
        }
        return (GroundOverlayOptions) invokeI.objValue;
    }

    public GroundOverlayOptions dimensions(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            this.f35267f = i2;
            this.f35268g = i3;
            return this;
        }
        return (GroundOverlayOptions) invokeII.objValue;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            this.f35264c = bundle;
            return this;
        }
        return (GroundOverlayOptions) invokeL.objValue;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35269h : invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35270i : invokeV.floatValue;
    }

    public LatLngBounds getBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35271j : (LatLngBounds) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35264c : (Bundle) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f35268g;
            return i2 == Integer.MAX_VALUE ? (int) ((this.f35267f * this.f35265d.a.getHeight()) / this.f35265d.a.getWidth()) : i2;
        }
        return invokeV.intValue;
    }

    public BitmapDescriptor getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f35265d : (BitmapDescriptor) invokeV.objValue;
    }

    public LatLng getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35266e : (LatLng) invokeV.objValue;
    }

    public float getTransparency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.floatValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f35267f : invokeV.intValue;
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
                this.f35265d = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        return (GroundOverlayOptions) invokeL.objValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f35263b : invokeV.booleanValue;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, latLng)) == null) {
            if (latLng != null) {
                this.f35266e = latLng;
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
                this.f35271j = latLngBounds;
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
            this.f35263b = z;
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
