package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class ProcessUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final ProcessUtils sProcessUtils;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCurProcessName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(692172811, "Lcom/baidu/mobads/container/util/ProcessUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(692172811, "Lcom/baidu/mobads/container/util/ProcessUtils;");
                return;
            }
        }
        sProcessUtils = new ProcessUtils();
    }

    public ProcessUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ProcessUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sProcessUtils : (ProcessUtils) invokeV.objValue;
    }

    public int getCurrentProcessId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return Process.myPid();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (this.mCurProcessName == null) {
                    int myPid = Process.myPid();
                    if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.pid == myPid) {
                                this.mCurProcessName = runningAppProcessInfo.processName;
                            }
                        }
                    }
                }
                return this.mCurProcessName;
            } catch (Exception unused) {
                return this.mCurProcessName;
            }
        }
        return (String) invokeL.objValue;
    }
}
