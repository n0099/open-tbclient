package com.baidu.android.util.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
/* loaded from: classes6.dex */
public class VersionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VersionUtils";
    public static String sBoxVersionCode;
    public static String sBoxVersionName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(282426819, "Lcom/baidu/android/util/android/VersionUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(282426819, "Lcom/baidu/android/util/android/VersionUtils;");
        }
    }

    public VersionUtils() {
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

    @Deprecated
    public static String getVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? getVersionCode() : (String) invokeL.objValue;
    }

    @Deprecated
    public static String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? getVersionName(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Deprecated
    public static String readFourDotVersionName() {
        InterceptResult invokeV;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            try {
                ApplicationInfo applicationInfo = appContext.getPackageManager().getApplicationInfo(appContext.getPackageName(), 128);
                return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString(PushManager.APP_VERSION_NAME);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (TextUtils.isEmpty(sBoxVersionCode)) {
                try {
                    PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                    sBoxVersionCode = packageInfo.versionCode + "";
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return sBoxVersionCode;
        }
        return (String) invokeV.objValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (TextUtils.isEmpty(sBoxVersionName)) {
                try {
                    PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                    sBoxVersionName = packageInfo.versionName + "";
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return sBoxVersionName;
        }
        return (String) invokeL.objValue;
    }
}
