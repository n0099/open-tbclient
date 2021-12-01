package com.baidu.ar.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String xU = "pro";
    public static String xV = "101";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1921142671, "Lcom/baidu/ar/h/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1921142671, "Lcom/baidu/ar/h/c;");
        }
    }

    public static int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return 5010;
        }
        return invokeV.intValue;
    }

    public static String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "5.1.0" : (String) invokeV.objValue;
    }

    public static String gx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? xU : (String) invokeV.objValue;
    }

    public static String gy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? xV : (String) invokeV.objValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                StringBuilder sb = new StringBuilder(context.getApplicationContext().getPackageName());
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
                    if (packageInfo != null) {
                        String str = packageInfo.versionName;
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("_");
                            sb.append(str);
                            b.aQ("appId = " + sb.toString());
                        }
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
                return sb.toString();
            } catch (NullPointerException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
