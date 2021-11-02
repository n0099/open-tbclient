package com.baidu.searchbox.ui;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BarSwitches {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SWITCH_ACTIONBAR = 1;
    public static final int SWITCH_MENU = 2;
    public static final int SWITCH_TITLE = 3;
    public transient /* synthetic */ FieldHolder $fh;

    public BarSwitches() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean getActionBarSwitch(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? getSwitch(i2, 1) : invokeI.booleanValue;
    }

    public static boolean getMenuSwitch(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? getSwitch(i2, 2) : invokeI.booleanValue;
    }

    public static boolean getSwitch(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? (i2 & (1 << (i3 - 1))) != 0 : invokeII.booleanValue;
    }

    public static boolean getTitleSwitch(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? getSwitch(i2, 3) : invokeI.booleanValue;
    }
}
