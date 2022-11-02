package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CircleHoleOptions extends HoleOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LatLng a;
    public int b;

    public CircleHoleOptions() {
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
        this.mHoleType = Config.TRACE_CIRCLE;
    }

    public LatLng getHoleCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (LatLng) invokeV.objValue;
    }

    public int getHoleRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public CircleHoleOptions center(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, latLng)) == null) {
            if (latLng == null) {
                Log.e("baidumapsdk", "CircleHole center can not be null");
                return this;
            }
            this.a = latLng;
            return this;
        }
        return (CircleHoleOptions) invokeL.objValue;
    }

    public CircleHoleOptions radius(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i <= 0) {
                Log.e("baidumapsdk", "CircleHole's radius can not be less than zero");
                return this;
            }
            this.b = i;
            return this;
        }
        return (CircleHoleOptions) invokeI.objValue;
    }
}
