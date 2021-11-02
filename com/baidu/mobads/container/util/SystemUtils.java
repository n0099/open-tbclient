package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SystemUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SystemUtils() {
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

    public static String getProcessName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(10)) {
                if (runningServiceInfo.pid == myPid) {
                    return runningServiceInfo.process;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isAdbEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? 17 <= Build.VERSION.SDK_INT ? 1 == Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) : 1 == Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) : invokeL.booleanValue;
    }

    public static String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
