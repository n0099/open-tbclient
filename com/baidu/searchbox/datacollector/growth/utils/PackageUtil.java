package com.baidu.searchbox.datacollector.growth.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PackageUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-240523597, "Lcom/baidu/searchbox/datacollector/growth/utils/PackageUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-240523597, "Lcom/baidu/searchbox/datacollector/growth/utils/PackageUtil;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public PackageUtil() {
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

    public static String getFirstInstallTime(Context context) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                j2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (PackageManager.NameNotFoundException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                j2 = 0;
            }
            return Base64.encodeToString(Long.toString(j2).getBytes(), 0);
        }
        return (String) invokeL.objValue;
    }

    public static String getLastUpdateTime(Context context) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                j2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            } catch (PackageManager.NameNotFoundException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                j2 = 0;
            }
            return Base64.encodeToString(Long.toString(j2).getBytes(), 0);
        }
        return (String) invokeL.objValue;
    }
}
