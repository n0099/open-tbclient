package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PkgUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "PkgUtils";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2022489033, "Lcom/baidu/android/util/android/PkgUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2022489033, "Lcom/baidu/android/util/android/PkgUtils;");
        }
    }

    public PkgUtils() {
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

    @SuppressLint({"PackageManagerGetSignatures"})
    public static PackageInfo getPackageInfo(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 64);
            } catch (PackageManager.NameNotFoundException e2) {
                if (DEBUG) {
                    Log.w(TAG, e2.getMessage());
                    return null;
                }
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static String getPackageSourcePath(Context context) {
        InterceptResult invokeL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getPackageVersion(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, str)) == null) {
            PackageInfo packageInfo = getPackageInfo(context, str);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String getSign(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                return (packageInfo == null || packageInfo.signatures.length <= 0) ? "" : packageInfo.signatures[0].toCharsString();
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e(TAG, "get sign error!!!", e2);
                    return "";
                }
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getSignByPermission(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            try {
                str2 = context.getPackageManager().getPermissionInfo(str, 128).packageName;
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e(TAG, "get packageName error!!!", e2);
                }
                str2 = "";
            }
            return TextUtils.isEmpty(str2) ? str2 : getSign(context, str2);
        }
        return (String) invokeLL.objValue;
    }
}
