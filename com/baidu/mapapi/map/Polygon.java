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
import java.util.List;
/* loaded from: classes7.dex */
public final class Polygon extends Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Stroke f40292a;

    /* renamed from: b  reason: collision with root package name */
    public int f40293b;

    /* renamed from: c  reason: collision with root package name */
    public List<LatLng> f40294c;

    public Polygon() {
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
        this.type = com.baidu.mapsdkplatform.comapi.map.h.j;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            super.a(bundle);
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f40294c.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            Overlay.a(this.f40294c, bundle);
            Overlay.a(this.f40293b, bundle);
            if (this.f40292a == null) {
                bundle.putInt("has_stroke", 0);
            } else {
                bundle.putInt("has_stroke", 1);
                bundle.putBundle("stroke", this.f40292a.a(new Bundle()));
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public int getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40293b : invokeV.intValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40294c : (List) invokeV.objValue;
    }

    public Stroke getStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40292a : (Stroke) invokeV.objValue;
    }

    public void setFillColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f40293b = i2;
            this.listener.b(this);
        }
    }

    public void setPoints(List<LatLng> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list == null) {
                throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
            }
            if (list.size() <= 2) {
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
            }
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            int i2 = 0;
            while (i2 < list.size()) {
                int i3 = i2 + 1;
                for (int i4 = i3; i4 < list.size(); i4++) {
                    if (list.get(i2) == list.get(i4)) {
                        throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                    }
                }
                i2 = i3;
            }
            this.f40294c = list;
            this.listener.b(this);
        }
    }

    public void setStroke(Stroke stroke) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, stroke) == null) {
            this.f40292a = stroke;
            this.listener.b(this);
        }
    }
}
