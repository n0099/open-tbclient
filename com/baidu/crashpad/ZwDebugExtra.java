package com.baidu.crashpad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ZwDebugExtra {
    public static /* synthetic */ Interceptable $ic;
    public static boolean debugModel;
    public transient /* synthetic */ FieldHolder $fh;

    public ZwDebugExtra() {
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

    public static boolean debugModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return debugModel;
        }
        return invokeV.booleanValue;
    }

    public static void clearCrashKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            ZwCrashpad.clearCrashKey(str);
        }
    }

    public static void crashIntentionally(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, null, i) == null) && debugModel) {
            ZwCrashpad.crashIntentionally(i);
        }
    }

    public static synchronized void init(Context context) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            synchronized (ZwDebugExtra.class) {
                try {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    if (applicationInfo != null) {
                        if ((applicationInfo.flags & 2) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        debugModel = z;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            ZwCrashpad.setCrashKeyValue(str, str2);
        }
    }
}
