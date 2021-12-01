package com.baidu.android.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class UiThreadUtils {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Handler sMainHandler;
    public transient /* synthetic */ FieldHolder $fh;

    public UiThreadUtils() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sMainHandler == null) {
                synchronized (UiThreadUtils.class) {
                    if (sMainHandler == null) {
                        sMainHandler = new Handler(Looper.getMainLooper());
                    }
                }
            }
            return sMainHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public static boolean isOnUiThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Looper.getMainLooper().getThread() == Thread.currentThread() : invokeV.booleanValue;
    }

    public static void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                getMainHandler().post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void runOnUiThreadAtFrontOfQueue(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, runnable) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                getMainHandler().postAtFrontOfQueue(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void runOnUiThread(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable, j2) == null) {
            if (j2 > 0) {
                getMainHandler().postDelayed(runnable, j2);
            } else {
                runOnUiThread(runnable);
            }
        }
    }
}
