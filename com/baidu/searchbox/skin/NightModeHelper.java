package com.baidu.searchbox.skin;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.skin.ioc.NightRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class NightModeHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NightModeHelper() {
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

    public static void forceSyncNightModeState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            NightRuntime.getNightContext().forceSyncNightModeState(z);
        }
    }

    public static boolean getNightModeSwitcherState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? NightRuntime.getNightContext().getNightModeSwitcherState() : invokeV.booleanValue;
    }

    public static boolean isNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? getNightModeSwitcherState() : invokeV.booleanValue;
    }

    public static void setNightModeSwitcherState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            NightRuntime.getNightContext().setNightModeSwitcherState(z);
        }
    }

    public static boolean shouldShowNightModeBubble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? NightRuntime.getNightContext().shouldShowNightModeBubble() : invokeV.booleanValue;
    }

    public static void subscribeNightModeChangeEvent(Object obj, NightModeChangeListener nightModeChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, nightModeChangeListener) == null) {
            NightRuntime.getNightContext().subscribeNightModeChangeEvent(obj, nightModeChangeListener);
        }
    }

    public static void unsubscribeNightModeChangedEvent(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, obj) == null) {
            NightRuntime.getNightContext().unsubscribeNightModeChangedEvent(obj);
        }
    }
}
