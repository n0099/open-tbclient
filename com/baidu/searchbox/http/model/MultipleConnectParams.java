package com.baidu.searchbox.http.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class MultipleConnectParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> fromList;
    public int maxMultiConnectNum;
    public boolean multiConnectABSwitch;
    public int multiConnectDelayInMsMobile;
    public int multiConnectDelayInMsWifi;
    public boolean multiConnectEnabledGlobal;

    public MultipleConnectParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getMaxMultiConnectNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.maxMultiConnectNum;
        }
        return invokeV.intValue;
    }

    public int getMultiConnectDelayInMsMobile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.multiConnectDelayInMsMobile;
        }
        return invokeV.intValue;
    }

    public int getMultiConnectDelayInMsWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.multiConnectDelayInMsWifi;
        }
        return invokeV.intValue;
    }

    public List<Integer> getMultiConnectFromList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.fromList;
        }
        return (List) invokeV.objValue;
    }

    public boolean isMultiConnectABSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.multiConnectABSwitch;
        }
        return invokeV.booleanValue;
    }

    public boolean isMultiConnectEnabledGlobal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.multiConnectEnabledGlobal;
        }
        return invokeV.booleanValue;
    }

    public MultipleConnectParams maxMultiConnectNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.maxMultiConnectNum = i;
            return this;
        }
        return (MultipleConnectParams) invokeI.objValue;
    }

    public MultipleConnectParams multiConnectABSwitch(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.multiConnectABSwitch = z;
            return this;
        }
        return (MultipleConnectParams) invokeZ.objValue;
    }

    public MultipleConnectParams multiConnectDelayInMsMobile(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.multiConnectDelayInMsMobile = i;
            return this;
        }
        return (MultipleConnectParams) invokeI.objValue;
    }

    public MultipleConnectParams multiConnectDelayInMsWifi(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            this.multiConnectDelayInMsWifi = i;
            return this;
        }
        return (MultipleConnectParams) invokeI.objValue;
    }

    public MultipleConnectParams multiConnectEnabledGlobal(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.multiConnectEnabledGlobal = z;
            return this;
        }
        return (MultipleConnectParams) invokeZ.objValue;
    }

    public MultipleConnectParams multiConnectFromList(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, list)) == null) {
            this.fromList = list;
            return this;
        }
        return (MultipleConnectParams) invokeL.objValue;
    }
}
