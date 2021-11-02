package com.baidu.android.util.concurrent;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes6.dex */
public class UiThreadUtil {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Handler sMainHandler;
    public transient /* synthetic */ FieldHolder $fh;

    public UiThreadUtil() {
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

    public static Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? UiThreadUtils.getMainHandler() : (Handler) invokeV.objValue;
    }

    public static boolean isOnUiThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? UiThreadUtils.isOnUiThread() : invokeV.booleanValue;
    }

    public static void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            UiThreadUtils.runOnUiThread(runnable);
        }
    }

    public static void runOnUiThreadAtFrontOfQueue(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, runnable) == null) {
            UiThreadUtils.runOnUiThreadAtFrontOfQueue(runnable);
        }
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable, j) == null) {
            UiThreadUtils.runOnUiThread(runnable, j);
        }
    }
}
