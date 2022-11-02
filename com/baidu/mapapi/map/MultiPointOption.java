package com.baidu.mapapi.map;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public final class MultiPointOption extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MultiPointItem> a;
    public BitmapDescriptor b;
    public int c;
    public int d;
    public float e;
    public float f;
    public boolean g;

    public MultiPointOption() {
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
        this.e = 0.5f;
        this.f = 0.5f;
        this.g = true;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public BitmapDescriptor getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (BitmapDescriptor) invokeV.objValue;
    }

    public List<MultiPointItem> getMultiPointItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public int getPointSizeHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int getPointSizeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MultiPoint multiPoint = new MultiPoint();
            multiPoint.b = this.b;
            List<MultiPointItem> list = this.a;
            if (list != null) {
                multiPoint.a = list;
                multiPoint.d = this.d;
                multiPoint.c = this.c;
                multiPoint.e = this.e;
                multiPoint.f = this.f;
                multiPoint.H = this.g;
                return multiPoint;
            }
            throw new IllegalStateException("BDMapSDKException: when you add mMultiPointItems, you must set the mMultiPointItems");
        }
        return (Overlay) invokeV.objValue;
    }

    public MultiPointOption setAnchor(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
                this.e = f;
                this.f = f2;
            }
            return this;
        }
        return (MultiPointOption) invokeCommon.objValue;
    }

    public MultiPointOption setIcon(BitmapDescriptor bitmapDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmapDescriptor)) == null) {
            if (bitmapDescriptor != null) {
                if (this.c == 0) {
                    this.c = bitmapDescriptor.getBitmap().getWidth();
                }
                if (this.d == 0) {
                    this.d = bitmapDescriptor.getBitmap().getHeight();
                }
                this.b = bitmapDescriptor;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: MultiPoint icon can not be null");
        }
        return (MultiPointOption) invokeL.objValue;
    }

    public MultiPointOption setMultiPointItems(List<MultiPointItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list != null) {
                if (!list.contains(null)) {
                    this.a = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
        }
        return (MultiPointOption) invokeL.objValue;
    }

    public MultiPointOption visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.g = z;
            return this;
        }
        return (MultiPointOption) invokeZ.objValue;
    }

    public MultiPointOption setPointSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            if (this.c > 0 && this.d > 0) {
                this.c = i;
                this.d = i2;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
        }
        return (MultiPointOption) invokeII.objValue;
    }
}
