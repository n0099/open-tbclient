package com.baidu.mapapi.synchronization.histroytrace;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HistoryTraceQueryOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39897a;

    /* renamed from: b  reason: collision with root package name */
    public int f39898b;

    /* renamed from: c  reason: collision with root package name */
    public String f39899c;

    /* renamed from: d  reason: collision with root package name */
    public String f39900d;

    /* renamed from: e  reason: collision with root package name */
    public int f39901e;

    /* renamed from: f  reason: collision with root package name */
    public int f39902f;

    public HistoryTraceQueryOptions() {
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
        this.f39897a = null;
        this.f39898b = 0;
        this.f39899c = null;
        this.f39900d = null;
        this.f39901e = 4;
        this.f39902f = 5;
    }

    public int getCurrentOrderState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39902f : invokeV.intValue;
    }

    public String getDriverId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39900d : (String) invokeV.objValue;
    }

    public String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39897a : (String) invokeV.objValue;
    }

    public int getQueryOrderState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39901e : invokeV.intValue;
    }

    public int getRoleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39898b : invokeV.intValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39899c : (String) invokeV.objValue;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f39902f = i2;
            return this;
        }
        return (HistoryTraceQueryOptions) invokeI.objValue;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.f39900d = str;
            return this;
        }
        return (HistoryTraceQueryOptions) invokeL.objValue;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.f39897a = str;
            return this;
        }
        return (HistoryTraceQueryOptions) invokeL.objValue;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f39901e = i2;
            return this;
        }
        return (HistoryTraceQueryOptions) invokeI.objValue;
    }

    public HistoryTraceQueryOptions setRoleType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.f39898b = i2;
            return this;
        }
        return (HistoryTraceQueryOptions) invokeI.objValue;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f39899c = str;
            return this;
        }
        return (HistoryTraceQueryOptions) invokeL.objValue;
    }
}
