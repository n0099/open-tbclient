package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class MultiPoint extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MultiPointItem> a;
    public BitmapDescriptor b;
    public int c;
    public int d;
    public float e;
    public float f;

    public MultiPoint() {
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
        this.type = com.baidu.mapsdkplatform.comapi.map.i.k;
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public BitmapDescriptor getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (BitmapDescriptor) invokeV.objValue;
    }

    public List<MultiPointItem> getMultiPointItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public int getPointSizeHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int getPointSizeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            List<MultiPointItem> list = this.a;
            if (list != null && list.size() > 0) {
                GeoPoint ll2mc = CoordUtil.ll2mc(this.a.get(0).getPoint());
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.a.size(); i++) {
                    MultiPointItem multiPointItem = this.a.get(i);
                    if (multiPointItem != null) {
                        arrayList.add(multiPointItem.getPoint());
                    }
                }
                Overlay.a(arrayList, bundle);
            }
            BitmapDescriptor bitmapDescriptor = this.b;
            if (bitmapDescriptor != null) {
                bundle.putBundle("image_info", bitmapDescriptor.b());
            }
            bundle.putInt("isClickable", 1);
            bundle.putFloat("anchor_x", this.e);
            bundle.putFloat("anchor_y", this.f);
            bundle.putFloat("pointsize_x", this.c);
            bundle.putFloat("pointsize_y", this.d);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void anchor(float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.e = f;
            this.f = f2;
            this.listener.c(this);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmapDescriptor) == null) {
            if (bitmapDescriptor != null) {
                this.b = bitmapDescriptor;
                if (this.c == 0) {
                    this.c = bitmapDescriptor.getBitmap().getWidth();
                }
                if (this.d == 0) {
                    this.d = bitmapDescriptor.getBitmap().getHeight();
                }
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
    }

    public void setMultiPointItems(List<MultiPointItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null) {
                if (!list.contains(null)) {
                    this.a = list;
                    this.listener.c(this);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
        }
    }

    public void setPointSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            if (this.c > 0 && this.d > 0) {
                this.c = i;
                this.d = i2;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
        }
    }
}
