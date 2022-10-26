package com.baidu.live.arch.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class LiveShellUIUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Context sContext;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-386106077, "Lcom/baidu/live/arch/utils/LiveShellUIUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-386106077, "Lcom/baidu/live/arch/utils/LiveShellUIUtil;");
                return;
            }
        }
        sContext = MiniShellRuntime.INSTANCE.getAppContext();
    }

    public LiveShellUIUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getScreenHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return sContext.getResources().getDisplayMetrics().heightPixels;
        }
        return invokeV.intValue;
    }

    public static int getScreenWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return sContext.getResources().getDisplayMetrics().widthPixels;
        }
        return invokeV.intValue;
    }

    public static boolean fixOrientation(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
                declaredField.setAccessible(false);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isTranslucentOrFloating(Activity activity) {
        InterceptResult invokeL;
        Exception e;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            try {
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
                Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
                method.setAccessible(true);
                z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
                try {
                    method.setAccessible(false);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return z;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
