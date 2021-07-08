package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
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

    /* renamed from: f  reason: collision with root package name */
    public static final String f6865f = "Arc";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f6866a;

    /* renamed from: b  reason: collision with root package name */
    public int f6867b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6868c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6869d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6870e;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = com.baidu.mapsdkplatform.comapi.map.h.f7726f;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(this.f6868c);
            arrayList.add(this.f6869d);
            arrayList.add(this.f6870e);
            GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt("width", this.f6867b);
            Overlay.a(arrayList, bundle);
            Overlay.a(this.f6866a, bundle);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6866a : invokeV.intValue;
    }

    public LatLng getEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6870e : (LatLng) invokeV.objValue;
    }

    public LatLng getMiddlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6869d : (LatLng) invokeV.objValue;
    }

    public LatLng getStartPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6868c : (LatLng) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6867b : invokeV.intValue;
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f6866a = i2;
            this.listener.b(this);
        }
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, latLng, latLng2, latLng3) == null) {
            if (latLng == null || latLng2 == null || latLng3 == null) {
                throw new IllegalArgumentException("BDMapSDKException:start and middle and end points can not be null");
            }
            if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
                throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
            }
            this.f6868c = latLng;
            this.f6869d = latLng2;
            this.f6870e = latLng3;
            this.listener.b(this);
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f6867b = i2;
        this.listener.b(this);
    }
}
