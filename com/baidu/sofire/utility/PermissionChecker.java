package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PermissionChecker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String ACCESS_NETWORK_STATE = "android.permission.ACCESS_NETWORK_STATE";
    public static final String ACCESS_WIFI_STATE = "android.permission.ACCESS_WIFI_STATE";
    public static final String CAMERA = "android.permission.CAMERA";
    public static final String GET_ACCOUNT = "android.permission.GET_ACCOUNTS";
    public static final String GET_TASKS = "android.permission.GET_TASKS";
    public static final String INTERNET = "android.permission.INTERNET";
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public transient /* synthetic */ FieldHolder $fh;

    public PermissionChecker() {
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

    public static boolean checkPermissions(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, strArr)) == null) {
            if (strArr != null) {
                try {
                    for (String str : strArr) {
                        if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                            return false;
                        }
                    }
                    return true;
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean hasImeiPermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean hasSdReadPermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != -1;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean hasSdReadWritePermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (hasSdWritePermission(context)) {
                    if (hasSdReadPermission(context)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean hasSdWritePermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != -1;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
