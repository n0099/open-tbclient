package com.baidu.platform.comapi.d;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 621133959;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1126016691, "Lcom/baidu/platform/comapi/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1126016691, "Lcom/baidu/platform/comapi/d/a;");
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return c(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (b(context) == a) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION).signingInfo.hasMultipleSigners()) {
                        signatureArr = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION).signingInfo.getApkContentsSigners();
                    } else {
                        signatureArr = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION).signingInfo.getSigningCertificateHistory();
                    }
                } else {
                    signatureArr = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 64).signatures;
                }
                return signatureArr[0].hashCode();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
