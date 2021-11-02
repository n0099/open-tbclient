package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public final class PolygonOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39463a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39464b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f39465c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f39466d;

    /* renamed from: e  reason: collision with root package name */
    public int f39467e;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f39468f;

    public PolygonOptions() {
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
        this.f39467e = -16777216;
        this.f39464b = true;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Polygon polygon = new Polygon();
            polygon.A = this.f39464b;
            polygon.z = this.f39463a;
            polygon.B = this.f39465c;
            List<LatLng> list = this.f39468f;
            if (list == null || list.size() < 2) {
                throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
            }
            polygon.f39462c = this.f39468f;
            polygon.f39461b = this.f39467e;
            polygon.f39460a = this.f39466d;
            return polygon;
        }
        return (Overlay) invokeV.objValue;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f39465c = bundle;
            return this;
        }
        return (PolygonOptions) invokeL.objValue;
    }

    public PolygonOptions fillColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f39467e = i2;
            return this;
        }
        return (PolygonOptions) invokeI.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39465c : (Bundle) invokeV.objValue;
    }

    public int getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39467e : invokeV.intValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39468f : (List) invokeV.objValue;
    }

    public Stroke getStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39466d : (Stroke) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39463a : invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39464b : invokeV.booleanValue;
    }

    public PolygonOptions points(List<LatLng> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, list)) == null) {
            if (list != null) {
                if (list.size() > 2) {
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
                    this.f39468f = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        return (PolygonOptions) invokeL.objValue;
    }

    public PolygonOptions stroke(Stroke stroke) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, stroke)) == null) {
            this.f39466d = stroke;
            return this;
        }
        return (PolygonOptions) invokeL.objValue;
    }

    public PolygonOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.f39464b = z;
            return this;
        }
        return (PolygonOptions) invokeZ.objValue;
    }

    public PolygonOptions zIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.f39463a = i2;
            return this;
        }
        return (PolygonOptions) invokeI.objValue;
    }
}
