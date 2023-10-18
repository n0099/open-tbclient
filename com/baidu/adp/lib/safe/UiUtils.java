package com.baidu.adp.lib.safe;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class UiUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UiUtils";
    public static Handler sBackgroundHandler;
    public static Handler sMainHandler;
    public transient /* synthetic */ FieldHolder $fh;

    public UiUtils() {
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

    public static Handler getBackgroundHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sBackgroundHandler == null) {
                synchronized (UiUtils.class) {
                    if (sBackgroundHandler == null) {
                        HandlerThread handlerThread = new HandlerThread("UiUtils-Background");
                        handlerThread.start();
                        sBackgroundHandler = new Handler(handlerThread.getLooper());
                    }
                }
            }
            return sBackgroundHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public static Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sMainHandler == null) {
                synchronized (UiUtils.class) {
                    if (sMainHandler == null) {
                        sMainHandler = new Handler(Looper.getMainLooper());
                    }
                }
            }
            return sMainHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public static void post(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            getMainHandler().post(runnable);
        }
    }

    public static void postOnBgThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            getBackgroundHandler().post(runnable);
        }
    }

    public static void removeCallbacksOnBgThread(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, runnable) == null) {
            getBackgroundHandler().removeCallbacks(runnable);
        }
    }

    public static void runOnBgThread(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, runnable) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                getBackgroundHandler().post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, runnable) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                getMainHandler().post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void runOnBgThreadDelay(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, null, runnable, j) == null) {
            getBackgroundHandler().postDelayed(runnable, j);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, null, runnable, j) == null) {
            getMainHandler().postDelayed(runnable, j);
        }
    }
}
