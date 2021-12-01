package com.baidu.searchbox.player.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class MainThreadUtil {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Handler sMainHandler;
    public transient /* synthetic */ FieldHolder $fh;

    public MainThreadUtil() {
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
                synchronized (MainThreadUtil.class) {
                    if (sMainHandler == null) {
                        sMainHandler = new Handler(Looper.getMainLooper());
                    }
                }
            }
            return sMainHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public static void runOnUiThread(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                getMainHandler().post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void runOnUiThread(@NonNull Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65539, null, runnable, j2) == null) {
            if (j2 > 0) {
                getMainHandler().postDelayed(runnable, j2);
            } else {
                runOnUiThread(runnable);
            }
        }
    }
}
