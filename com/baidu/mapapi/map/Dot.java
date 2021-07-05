package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class Dot extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6897a;

    /* renamed from: b  reason: collision with root package name */
    public int f6898b;

    /* renamed from: c  reason: collision with root package name */
    public int f6899c;

    public Dot() {
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
        this.type = com.baidu.mapsdkplatform.comapi.map.h.f7710g;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f6897a);
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt("radius", this.f6899c);
            Overlay.a(this.f6898b, bundle);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public LatLng getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6897a : (LatLng) invokeV.objValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6898b : invokeV.intValue;
    }

    public int getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6899c : invokeV.intValue;
    }

    public void setCenter(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, latLng) == null) {
            if (latLng == null) {
                throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
            }
            this.f6897a = latLng;
            this.listener.b(this);
        }
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f6898b = i2;
            this.listener.b(this);
        }
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f6899c = i2;
        this.listener.b(this);
    }
}
