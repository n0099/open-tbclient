package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class Arc extends Overlay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String f = "Arc";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public LatLng c;
    public LatLng d;
    public LatLng e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-310720513, "Lcom/baidu/mapapi/map/Arc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-310720513, "Lcom/baidu/mapapi/map/Arc;");
        }
    }

    public Arc() {
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
        this.type = com.baidu.mapsdkplatform.comapi.map.i.f;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public LatLng getEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (LatLng) invokeV.objValue;
    }

    public LatLng getMiddlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (LatLng) invokeV.objValue;
    }

    public LatLng getStartPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (LatLng) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt("width", this.b);
            Overlay.a(arrayList, bundle);
            Overlay.a(this.a, bundle);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void setColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a = i;
            this.listener.c(this);
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && i > 0) {
            this.b = i;
            this.listener.c(this);
        }
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, latLng, latLng2, latLng3) == null) {
            if (latLng != null && latLng2 != null && latLng3 != null) {
                if (latLng != latLng2 && latLng != latLng3 && latLng2 != latLng3) {
                    this.c = latLng;
                    this.d = latLng2;
                    this.e = latLng3;
                    this.listener.c(this);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
            }
            throw new IllegalArgumentException("BDMapSDKException:start and middle and end points can not be null");
        }
    }
}
