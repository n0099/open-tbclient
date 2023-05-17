package com.baidu.platform.comapi.map;

import android.os.Bundle;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String id;
    public long mLayerID;
    public int mType;

    public Overlay() {
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
        this.id = System.currentTimeMillis() + "_" + hashCode();
    }

    public static void putColorInfoIntoBundle(int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i, bundle) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
            bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
            bundle2.putFloat("blue", (i & 255) / 255.0f);
            bundle2.putFloat(Key.ALPHA, (i >>> 24) / 255.0f);
            bundle.putBundle("color", bundle2);
        }
    }

    public static void putPointsInfoIntoBundle(List<GeoPoint> list, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, list, bundle) == null) {
            int size = list.size();
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            for (int i = 0; i < size; i++) {
                GeoPoint a = aa.a(list.get(i));
                dArr[i] = a.getLongitude();
                dArr2[i] = a.getLatitude();
            }
            bundle.putDoubleArray("x_array", dArr);
            bundle.putDoubleArray("y_array", dArr2);
        }
    }
}
