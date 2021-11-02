package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
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
public abstract class Overlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public Bundle B;
    public a listener;
    public com.baidu.mapsdkplatform.comapi.map.h type;
    public String y;
    public int z;

    /* loaded from: classes7.dex */
    public interface a {
        void a(Overlay overlay);

        void b(Overlay overlay);
    }

    public Overlay() {
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
        this.y = System.currentTimeMillis() + "_" + hashCode();
    }

    public static void a(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i2, bundle) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("red", ((i2 >> 16) & 255) / 255.0f);
            bundle2.putFloat("green", ((i2 >> 8) & 255) / 255.0f);
            bundle2.putFloat("blue", (i2 & 255) / 255.0f);
            bundle2.putFloat(Key.ALPHA, (i2 >>> 24) / 255.0f);
            bundle.putBundle("color", bundle2);
        }
    }

    public static void a(List<LatLng> list, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, list, bundle) == null) {
            int size = list.size();
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            for (int i2 = 0; i2 < size; i2++) {
                GeoPoint ll2mc = CoordUtil.ll2mc(list.get(i2));
                dArr[i2] = ll2mc.getLongitudeE6();
                dArr2[i2] = ll2mc.getLatitudeE6();
            }
            bundle.putDoubleArray("x_array", dArr);
            bundle.putDoubleArray("y_array", dArr2);
        }
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("id", this.y);
            bundle.putInt("type", this.type.ordinal());
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            bundle.putString("id", this.y);
            bundle.putInt("type", this.type.ordinal());
            bundle.putInt("visibility", this.A ? 1 : 0);
            bundle.putInt("z_index", this.z);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.B : (Bundle) invokeV.objValue;
    }

    public int getZIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.z : invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.listener.a(this);
        }
    }

    public void setExtraInfo(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            this.B = bundle;
        }
    }

    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.A = z;
            this.listener.b(this);
        }
    }

    public void setZIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.z = i2;
            this.listener.b(this);
        }
    }
}
