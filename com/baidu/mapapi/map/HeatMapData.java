package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes2.dex */
public class HeatMapData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double[] a;
    public double[] b;
    public double[] c;
    public float d;

    public HeatMapData(Collection<WeightedLatLng> collection, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection, Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int size = collection.size();
        this.a = new double[size];
        this.b = new double[size];
        this.c = new double[size];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (WeightedLatLng weightedLatLng : collection) {
            this.a[i3] = weightedLatLng.getPoint().x;
            this.b[i4] = weightedLatLng.getPoint().y;
            this.c[i5] = weightedLatLng.getIntensity();
            i5++;
            i4++;
            i3++;
        }
        this.d = f;
    }

    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putDoubleArray("x_array", this.a);
            bundle.putDoubleArray("y_array", this.b);
            bundle.putDoubleArray("z_array", this.c);
            bundle.putFloat("max_intentity", this.d);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }
}
