package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.v;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class WeightedLatLng extends v.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double DEFAULT_INTENSITY = 1.0d;
    public transient /* synthetic */ FieldHolder $fh;
    public Point a;
    public final double intensity;
    public final LatLng mLatLng;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {latLng};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((LatLng) objArr2[0], ((Double) objArr2[1]).doubleValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public WeightedLatLng(LatLng latLng, double d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {latLng, Double.valueOf(d)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (latLng != null) {
            this.mLatLng = latLng;
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            this.a = new Point((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6());
            if (d > 0.0d) {
                this.intensity = d;
                return;
            } else {
                this.intensity = 1.0d;
                return;
            }
        }
        throw new IllegalArgumentException("BDMapSDKException: latLng can not be null");
    }

    public double getIntensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.intensity;
        }
        return invokeV.doubleValue;
    }

    @Override // com.baidu.mapapi.map.v.a
    public Point getPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (Point) invokeV.objValue;
    }
}
