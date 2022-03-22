package com.baidu.searchbox.fluency.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FpsSpUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FPS_FLOAT_VIEW_SWITCH = "key_fps_float_view_switch";
    public transient /* synthetic */ FieldHolder $fh;

    public FpsSpUtil() {
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

    public static boolean getFpsFloatSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? SharedPrefsUtil.getBoolean(KEY_FPS_FLOAT_VIEW_SWITCH, false) : invokeV.booleanValue;
    }

    public static void putFpsFloatSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            SharedPrefsUtil.putBoolean(KEY_FPS_FLOAT_VIEW_SWITCH, z);
        }
    }
}
